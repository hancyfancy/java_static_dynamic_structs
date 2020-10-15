/*
BSD 3-Clause License

Copyright (c) 2020, hancyfancy
All rights reserved.

Redistribution and use in source and binary forms, with or without
modification, are permitted provided that the following conditions are met:

1. Redistributions of source code must retain the above copyright notice, this
   list of conditions and the following disclaimer.

2. Redistributions in binary form must reproduce the above copyright notice,
   this list of conditions and the following disclaimer in the documentation
   and/or other materials provided with the distribution.

3. Neither the name of the copyright holder nor the names of its
   contributors may be used to endorse or promote products derived from
   this software without specific prior written permission.

THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE
FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
*/

import java.lang.reflect.Method;

public class StaticStore<T> extends ItemStore<T> implements IOneDimensionIterable<T>, IOneDimensionStorable<T> {
    private int length;
    public StaticStore(int length) {
        super();
        if (this.isLengthValid(length)) {
            this.setLength(length);
            super.setItems(new Item[length]);
        }
    }
    private int getIndex(Item<?> item) {
        int index = -1;
        Item<?>[] items = getItems();
        for (int i = 0; i < getLength(); i++) {
            if (items[i].equals(item)) {
                index = i;
                break;
            }
        }
        if (index == -1)
        {
            Class thisClass = this.getClass();
            Method thisMethod = thisClass.getEnclosingMethod();
            throw new Error(thisClass.getName().concat(".").concat(thisMethod.getName()).concat(": Specified item does not exist."));
        }
        return index;
    }
    public int getIndex(Object object) {
        return getIndex(new Item(object));
    }
    public int getLength() {
        return this.length;
    }
    private void setLength(int newLength) {
        if (newLength != getLength()) {
            this.length = newLength;
        }
    }
    private boolean isLengthValid(int newLength) {
        return (newLength > 0);
    }
    private Item<T> getCurrentItem() {
        return (Item<T>)getItems()[getCurrentIndex()];
    }
    private void setItem(Item<?> newItem) {
        int currentIndex = super.getCurrentIndex();
        Item<?>[] items = super.getItems();
        int length = getLength();
        if (currentIndex < length) {
            if (items[currentIndex] == null) {
                items[currentIndex] = newItem;
            } else {
                Class thisClass = this.getClass();
                Method thisMethod = thisClass.getEnclosingMethod();
                throw new Error(thisClass.getName().concat(".").concat(thisMethod.getName()).concat(": Length of static item store is ".concat(String.valueOf(length)).concat(", cannot add extra items.")));
            }
        }
        super.setItems(items);
        int nextIndex = currentIndex + 1;
        if (nextIndex < length) {
            super.setCurrentIndex(nextIndex);
        }
    }
    public void add(Object toBeAdded) {
        this.setItem(new Item(toBeAdded));
    }
    private void replaceItem(int index, Item<?> newItem) {
        if (index < getLength()) {
            Item<?>[] items = getItems();
            if (items[index] != null) {
                items[index] = newItem;
            } else {
                Class thisClass = this.getClass();
                Method thisMethod = thisClass.getEnclosingMethod();
                throw new Error(thisClass.getName().concat(".").concat(thisMethod.getName()).concat(": Null items cannot be replaced, try adding or inserting instead."));
            }
            super.setItems(items);
        }
    }
    public void replace(int index, Object toBeReplaced) {
        this.replaceItem(index, new Item(toBeReplaced)); 
    }
}
