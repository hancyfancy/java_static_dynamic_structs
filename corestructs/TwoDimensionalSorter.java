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

public class TwoDimensionalSorter<K extends Comparable<K>,V extends Comparable<V>> implements ITwoDimensionSortable<K,V> {    
    private DynamicMap<?,?> map;
    private ItemForkerJoiner<?> forkerJoiner;
    public TwoDimensionalSorter(DynamicMap<?,?> newMap) {
        this.setMap(newMap);
    }
    protected DynamicMap<K,V> getMap() {
        return (DynamicMap<K,V>)this.map;
    }
    protected void setMap(DynamicMap<?,?> newMap) {
        this.map = newMap;
    }
    protected ItemForkerJoiner<?> getForkerJoiner(TwoDimensionConstants by) {
        ItemForkerJoiner<?> fj = this.forkerJoiner;
        if (by == TwoDimensionConstants.KEY) {
            fj = (ItemForkerJoiner<K>)fj;
        } else if (by == TwoDimensionConstants.VALUE) {
            fj = (ItemForkerJoiner<V>)fj;
        }
        return fj;
    }
    protected void setForkerJoiner(ItemForkerJoiner<?> newForkerJoiner) {
        this.forkerJoiner = newForkerJoiner;
    }
    public void sort(TwoDimensionConstants by) {
        DynamicMap<?,?> map = getMap();
        DynamicUniqueStore<?> keys = map.getKeys();
        DynamicStore<?> values = map.getValues();
        int[] sortedIndices = new int[map.getLength()];
        ItemDividerConquerer<?> dc = null;
        if (by == TwoDimensionConstants.KEY) {
            DynamicUniqueStore<?> originalKeys = new DynamicUniqueStore<K>();
            for (int i = 0; i < map.getLength(); i++) {
                originalKeys.add(keys.get(i));
            }
            dc = new ItemDividerConquerer<K>(keys.getItems());
            keys.setItems(dc.mergeSort(0, keys.getLength()-1));
            for (int i = 0; i < map.getLength(); i++) {
                sortedIndices[i] = originalKeys.getIndex(keys.get(i));
            }
            DynamicStore<?> sortedValues = new DynamicStore<V>();
            for (int j = 0; j < sortedIndices.length; j++) {
                sortedValues.add(values.get(sortedIndices[j]));
            }
            map.setValues(sortedValues);
        } else if (by == TwoDimensionConstants.VALUE) {
            DynamicStore<?> originalValues = new DynamicStore<V>();
            for (int i = 0; i < map.getLength(); i++) {
                originalValues.add(values.get(i));
            }
            dc = new ItemDividerConquerer<V>(values.getItems());
            values.setItems(dc.mergeSort(0, values.getLength()-1));
            for (int i = 0; i < map.getLength(); i++) {
                sortedIndices[i] = originalValues.getIndex(values.get(i));
            }
            DynamicUniqueStore<?> sortedKeys = new DynamicUniqueStore<K>();
            for (int j = 0; j < sortedIndices.length; j++) {
                sortedKeys.add(keys.get(sortedIndices[j]));
            }
            map.setKeys(sortedKeys);
        }
    }
    public void parallelSort(TwoDimensionConstants by) {
        DynamicMap<?,?> map = getMap();
        ItemForkerJoiner<?> fj = null;
        if (by == TwoDimensionConstants.KEY) {
            fj = new ItemForkerJoiner<K>(1, map.getKeys().getItems(), new Item[map.getLength()], Runtime.getRuntime().availableProcessors());
        } else if (by == TwoDimensionConstants.VALUE) {
            fj = new ItemForkerJoiner<V>(1, map.getValues().getItems(), new Item[map.getLength()], Runtime.getRuntime().availableProcessors());
        }
        this.setForkerJoiner(fj);
        ForkJoinPool pool = new ForkJoinPool();
        pool.invoke(fj);
        if (by == TwoDimensionConstants.KEY) {
            map.getKeys().setItems(fj.getArray());
        } else if (by == TwoDimensionConstants.VALUE) {
            map.getValues().setItems(fj.getArray());
        }
    }
}
