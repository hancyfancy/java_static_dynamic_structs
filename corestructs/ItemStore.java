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

public abstract class ItemStore<T extends Comparable<T>> implements ISortable<T> {
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
    private boolean isPrimeNumber(int num) {
        boolean flag = true;
        for(int i = 2; i <= num/2; ++i) {
            if(num % i == 0) {
                flag = false;
                break;
            }
        }
        return flag;
    }
    private int[] generatePrimeNumbers(int n) {
        int[] primeNumbers = null;
        if (n <= 1) {
            primeNumbers = new int[]{1};
        } else if (n == 2) {
            primeNumbers = new int[]{2};
        } else {
            String primeNumbersAsString = "";
            for (int i = 2; i <= n; i++) {
                if (i <= n) {	 		  
                    if (isPrimeNumber(i)) {
                        primeNumbersAsString = primeNumbersAsString.concat(String.valueOf(i)).concat(",");
                    }
                }
            }
            String[] primeNumbersSplit = primeNumbersAsString.split(",");
            int primeNumbersSplitLength = primeNumbersSplit.length;
            primeNumbers = new int[primeNumbersSplitLength];
            for (int j = 0; j < primeNumbersSplitLength-1; j++) {
                primeNumbers[j] = Integer.parseInt(primeNumbersSplit[j]);
            }
        }
        return primeNumbers;
    }
    private int calculatePrimeDivisions(Item<?>[] unsortedItems) {
        int unsortedItemsLength = unsortedItems.length;
        int[] primeNumbers = generatePrimeNumbers(unsortedItemsLength/2);
        int requiredPrime = -1;
        for (int i = primeNumbers.length-1; i > -1; i--) {
            int currentPrime = primeNumbers[i];
            if (currentPrime > 0) {
                if (unsortedItemsLength % currentPrime == 0) {
                    requiredPrime = currentPrime;
                    break;
                }
            }
        }
        return (requiredPrime == -1 ? 1 : requiredPrime);
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
    private Item<T>[] mergeSort(Item<?>[] unsortedDivision, int l, int r)
    {
        if (l < r) {
            int m = (l + r) / 2;
            mergeSort(unsortedDivision, l, m);
            mergeSort(unsortedDivision, m + 1, r);
            merge(unsortedDivision, l, m, r);
        }
        return (Item<T>[])unsortedDivision;
    }
    private Item<T>[] populateUnsortedSubarray(Item<?>[] unsorted, int index, int numberOfDivisions) {
        Item<?>[] unsortedSubarray = new Item[numberOfDivisions];
        int unsortedSubarrayIndex = 0;
        for (int i = index; i < numberOfDivisions+index; i++) {
            unsortedSubarray[unsortedSubarrayIndex] = unsorted[i];
            unsortedSubarrayIndex++;
        }
        return (Item<T>[])unsortedSubarray;
    }
    private Item<T>[][] getSortedSubarrays(Item<?>[] unsorted, int numberOfDivisions, int divisor) {
        int unsortedLength = unsorted.length;
        Item<?>[][] sortedSubarrays = new Item[divisor][numberOfDivisions];
        int sortedSubarraysIndex = 0;
        for (int i = 0; i < unsortedLength; i+=numberOfDivisions) {
            Item<?>[] unsortedSubarray = populateUnsortedSubarray(unsorted, i, numberOfDivisions);
            Item<?>[] sortedSubarray = mergeSort(unsortedSubarray, 0, unsortedSubarray.length-1);
            sortedSubarrays[sortedSubarraysIndex] = sortedSubarray;
            sortedSubarraysIndex++;
        }
        return (Item<T>[][])sortedSubarrays;
    }
    private Item<T>[][] getSortOrder(Item<?>[][] sortedSubarrays, int numberOfDivisions, int divisor) {
        Item<?>[][] sortedOrderedSubarrays = new Item[numberOfDivisions][divisor];
        int sortLevelIndex = 0;
        while (sortLevelIndex < numberOfDivisions) {
            Item<?>[] unsortedSortLevel = new Item[divisor];
            for (int i = 0; i < unsortedSortLevel.length; i++) {
                unsortedSortLevel[i] = sortedSubarrays[i][sortLevelIndex];
            }
            Item<?>[] sortedSortLevel = mergeSort(unsortedSortLevel, 0, unsortedSortLevel.length-1);
            sortedOrderedSubarrays[sortLevelIndex] = sortedSortLevel;
            sortLevelIndex++;
        }
        return (Item<T>[][])sortedOrderedSubarrays;
    }
    private Item<T>[] subMerge(Item<?>[] firstSortOrderLevel, Item<?>[] secondSortOrderLevel) {
        Item<?>[] subsorted = null;
        if (!(firstSortOrderLevel.length > 0)) {
            subsorted = (Item<T>[])secondSortOrderLevel;
        } else if (!(secondSortOrderLevel.length > 0)) {
            subsorted = (Item<T>[])firstSortOrderLevel;
        } else {
            subsorted = new Item[firstSortOrderLevel.length+secondSortOrderLevel.length];
            int subsortedIndex = 0;
            int firstSortOrderIndex = 0;
            int secondSortOrderIndex = 0;
            while ((firstSortOrderIndex < firstSortOrderLevel.length) && (secondSortOrderIndex < secondSortOrderLevel.length)) {
                if (((Item<T>)firstSortOrderLevel[firstSortOrderIndex]).isLessThan(((Item<T>)secondSortOrderLevel[secondSortOrderIndex]))) {
                    subsorted[subsortedIndex] = (Item<T>)firstSortOrderLevel[firstSortOrderIndex];
                    firstSortOrderIndex++;
                    subsortedIndex++;
                } else if (((Item<T>)firstSortOrderLevel[firstSortOrderIndex]).isGreaterThan(((Item<T>)secondSortOrderLevel[secondSortOrderIndex]))) {
                    subsorted[subsortedIndex] = (Item<T>)secondSortOrderLevel[secondSortOrderIndex];
                    secondSortOrderIndex++;
                    subsortedIndex++;
                } else {
                    subsorted[subsortedIndex] = (Item<T>)firstSortOrderLevel[firstSortOrderIndex];
                    firstSortOrderIndex++;
                    subsorted[subsortedIndex+1] = (Item<T>)secondSortOrderLevel[secondSortOrderIndex];
                    secondSortOrderIndex++;
                    subsortedIndex+=2;
                }
            }
            for (int j = secondSortOrderIndex; j < secondSortOrderLevel.length; j++) {
                subsorted[subsortedIndex] = (Item<T>)secondSortOrderLevel[j];
                subsortedIndex++;
            }
            for (int k = firstSortOrderIndex; k < firstSortOrderLevel.length; k++) {
                subsorted[subsortedIndex] = (Item<T>)firstSortOrderLevel[k];
                subsortedIndex++;
            }
        }
        return (Item<T>[])subsorted;
    }
    private Item<T>[] sortTruncate(Item<?>[][] sortOrder, int numberOfDivisions, int divisor) {
        Item<?>[] sorted = new Item[0];
        for (int i = 0; i < sortOrder.length; i++) {
            sorted = subMerge(sorted, (Item<T>[])sortOrder[i]);
        }
        return (Item<T>[])sorted;
    }
    protected void sort(boolean createSortOrder) {
        Item<?>[] unsortedItems = getItems();
        int primeDivisions = this.calculatePrimeDivisions(unsortedItems);
        int divisor = unsortedItems.length/primeDivisions;
        Item<?>[][] sortedSubarrays = this.getSortedSubarrays(unsortedItems, primeDivisions, divisor);
        Item<?>[] allSorted = null;
        if (createSortOrder) {
            Item<?>[][] sortOrder = this.getSortOrder(sortedSubarrays, primeDivisions, divisor);
            allSorted = this.sortTruncate(sortOrder, primeDivisions, divisor);
        } else {
            allSorted = this.sortTruncate(sortedSubarrays, primeDivisions, divisor);
        }
        setItems(allSorted);
    }
    public void sort() {
        sort(false);
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
