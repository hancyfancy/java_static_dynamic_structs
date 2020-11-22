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

abstract class ItemStore<T extends Comparable<T>> {
    private int currentIndex;
    private Item<?>[] items;
    protected ItemStore() {
        this.setCurrentIndex(0);
    }
    protected int getCurrentIndex() {
        return this.currentIndex;
    }
    protected void setCurrentIndex(int newCurrentIndex) {
        this.currentIndex = newCurrentIndex;
    }
    protected Item<T>[] getItems() {
        return (Item<T>[])this.items;
    }
    protected void setItems(Item<?>[] newItems) {
        this.items = newItems;
    }
    protected Item<T> getItem(int index) {
        return (Item<T>)getItems()[index];
    }
    protected Object getObject(int index) {
        return getItem(index).toObject();
    }
    public T get(int index) {
        return (T)getObject(index);
    }
    public int getLength() {
        return getItems().length;
    }
    protected void replaceAllItems(Item<?> newItem) {
        Item<?>[] items = getItems();
        for (int i = 0; i < items.length; i++) {
            if (items[i] != null) {
                items[i] = newItem;
            } else {
                throw new Error("Null items cannot be replaced, try adding or inserting instead.");
            }
        }
        this.setItems(items);
    }
    public void replaceAll(Object toBeReplaced) {
        this.replaceAllItems(new Item((Comparable)toBeReplaced)); 
    }
    public String toString() {
        String output = "";
        Item<?>[] items = getItems();
        output = output.concat("[");
        for (int i = 0; i < items.length; i++) {
            output = output.concat("{Index ").concat(String.valueOf(i)).concat(": ").concat(String.valueOf(items[i]));
            if (i < items.length - 1) {
                output = output.concat("}, ");
            } else {
                output = output.concat("}");
            }
        }
        output = output.concat("]\n");
        return output;
    }
}
