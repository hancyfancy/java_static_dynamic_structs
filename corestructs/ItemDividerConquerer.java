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

class ItemDividerConquerer<T extends Comparable<T>> {
    private Item<?>[] array;
    protected ItemDividerConquerer(Item<?>[] newArray) {
        this.setArray(newArray);
    }
    protected Item<T>[] getArray() {
        return (Item<T>[])this.array;
    }
    protected void setArray(Item<?>[] newArray) {
        this.array = newArray;
    }
    private void merge(Item<?>[] sortedDivision, int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;
        Item<?>[] left = new Item[n1];
        Item<?>[] right = new Item[n2];
        for (int i = 0; i < n1; ++i) {
            left[i] = sortedDivision[l + i];
        }
        for (int j = 0; j < n2; ++j) {
            right[j] = sortedDivision[m + 1 + j];
        }
        int x = 0, y = 0;
        int k = l;
        while (x < n1 && y < n2) {
            if (((Item<T>)left[x]).isGreaterThan(((Item<T>)right[y]))) {
                sortedDivision[k] = right[y];
                y++;
            } else {
                sortedDivision[k] = left[x];
                x++;
            }
            k++;
        }
        while (x < n1) {
            sortedDivision[k] = left[x];
            x++;
            k++;
        }
        while (y < n2) {
            sortedDivision[k] = right[y];
            y++;
            k++;
        }
    }
    protected Item<T>[] mergeSort(int l, int r)
    {
        Item<?>[] unsortedDivision = getArray();
        if (l < r) {
            int m = (l + r) / 2;
            mergeSort(l, m);
            mergeSort(m + 1, r);
            merge(unsortedDivision, l, m, r);
        }
        return (Item<T>[])unsortedDivision;
    }
}
