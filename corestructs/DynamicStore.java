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

package corestructs;

import java.lang.reflect.Method;

public class DynamicStore<T extends Comparable<T>> extends ItemStore<T> implements IInsertable<T>, IOneDimensionIterable<T>, IOneDimensionStorable<T> {
    public DynamicStore() {
        super();
        super.setItems(new Item[]{});
    }
    private int getIndex(Item<?> item) {
        int index = -1;
        Item<?>[] items = getItems();
        for (int i = 0; i < items.length; i++) {
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
        return getIndex(new Item((Comparable)object));
    }
    private Item<T> getCurrentItem() {
        return (Item<T>)getItems()[getCurrentIndex()];
    }
    protected void setItem(Item<?> newItem) {
        Item<?>[] newItems = null;
        int currentIndex = super.getCurrentIndex();
        Item<?>[] items = super.getItems();
        int itemsLength = items.length;
        newItems = new Item[itemsLength + 1];
        for (int i = 0; i < itemsLength; i++) {
            Item<?> currentItem = items[i];
            if (currentItem != null) {
                newItems[i] = currentItem;
            }
        }
        newItems[currentIndex] = newItem;
        super.setItems(newItems);
        super.setCurrentIndex(currentIndex + 1);
    }
    public void add(Object toBeAdded) {
        this.setItem(new Item((Comparable)toBeAdded));
    }
    private void replaceItem(int index, Item<?> newItem) {
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
    public void replace(int index, Object toBeReplaced) {
        this.replaceItem(index, new Item((Comparable)toBeReplaced)); 
    }
    private void insertItem(int index, Item<?> newItem) {
        Item<?>[] newItems = null;
        Item<?>[] items = super.getItems();
        int itemsLength = items.length;
        if (index > -1) {
            if (index == itemsLength) {
                super.setCurrentIndex(itemsLength);
                setItem(newItem);
            } else if (index > itemsLength) {
                Class thisClass = this.getClass();
                Method thisMethod = thisClass.getEnclosingMethod();
                throw new Error(thisClass.getName().concat(".").concat(thisMethod.getName()).concat(": Index must be less than or equal to length of Dynamic Store."));
            } else {
                newItems = new Item[itemsLength+1];
                if (index == 0) {
                    newItems[index] = newItem;
                    for (int i = index+1; i < newItems.length; i++) {
                        newItems[i] = items[i-1];
                    }
                } else { //index > 0 && index < itemsLength
                    for (int j = 0; j < index; j++) {
                        newItems[j] = items[j];
                    }
                    newItems[index] = newItem;
                    for (int k = index; k < items.length; k++) {
                        newItems[k+1] = items[k];
                    }
                }
                super.setItems(newItems);
            }
        } else {
            Class thisClass = this.getClass();
            Method thisMethod = thisClass.getEnclosingMethod();
            throw new Error(thisClass.getName().concat(".").concat(thisMethod.getName()).concat(": Index must be non negative."));
        }
    }
    public void insert(int index, Object toBeInserted) {
        this.insertItem(index, new Item((Comparable)toBeInserted));
    }
}
