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

import java.util.concurrent.ForkJoinPool;

public class OneDimensionSorter<T extends Comparable<T>> implements IOneDimensionSortable<T> {
    private ItemStore<?> store;
    private ItemForkerJoiner<?> forkerJoiner;
    public OneDimensionSorter(ItemStore<?> newStore) {
        this.setStore(newStore);
        this.setForkerJoiner(new ItemForkerJoiner<T>(1, getStore().getItems(), new Item[getStore().getLength()], Runtime.getRuntime().availableProcessors()));
    }
    protected ItemStore<T> getStore() {
        return (ItemStore<T>)this.store;
    }
    protected void setStore(ItemStore<?> newStore) {
        this.store = newStore;
    }
    protected ItemForkerJoiner<T> getForkerJoiner() {
        return (ItemForkerJoiner<T>)this.forkerJoiner;
    }
    protected void setForkerJoiner(ItemForkerJoiner<?> newForkerJoiner) {
        this.forkerJoiner = newForkerJoiner;
    }
    public void sort() {
        Item<?>[] array = getStore().getItems();
        ItemDividerConquerer<?> dc = new ItemDividerConquerer<T>(array);
        dc.mergeSort(0, array.length-1);
    }
    public void parallelSort() {
        ItemForkerJoiner<?> fj = getForkerJoiner();
        ForkJoinPool pool = new ForkJoinPool();
        pool.invoke(fj);
        getStore().setItems(fj.getArray());
    }
}
