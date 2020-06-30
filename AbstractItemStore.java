abstract class AbstractItemStore<T> implements ISortable<T> {
    private int currentIndex;
    private Item<?>[] items;
    public AbstractItemStore() {
        this.setCurrentIndex(0);
    }
    public int getCurrentIndex() {
        return this.currentIndex;
    }
    protected void setCurrentIndex(int newCurrentIndex) {
        this.currentIndex = newCurrentIndex;
    }
    public Item<T>[] getItems() {
        return (Item<T>[])this.items;
    }
    public Item<T> getItem(int index) {
        return (Item<T>)getItems()[index];
    }
    protected void setItems(Item<?>[] newItems) {
        this.items = newItems;
    }
    public boolean isPrimeNumber(int num) {
        boolean flag = true;
        for(int i = 2; i <= num/2; ++i) {
            if(num % i == 0) {
                flag = false;
                break;
            }
        }
        return flag;
    }
    public int[] generatePrimeNumbers(int n) {
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
            for (int j = 0; j < primeNumbersSplitLength; j++) {
                primeNumbers[j] = Integer.parseInt(primeNumbersSplit[j]);
            }
        }
        return primeNumbers;
    }
    public int calculatePrimeDivisions(Item<?>[] unsortedItems) {
        int unsortedItemsLength = unsortedItems.length;
        int[] primeNumbers = generatePrimeNumbers(unsortedItemsLength/2);
        int requiredPrime = -1;
        for (int i = primeNumbers.length-1; i > -1; i--) {
            int currentPrime = primeNumbers[i];
            if (unsortedItemsLength % currentPrime == 0) {
                requiredPrime = currentPrime;
                break;
            }
        }
        return (requiredPrime == -1 ? 1 : requiredPrime);
    }
    public int linearSearchMin(Item<?>[] array) {
        int min = Integer.MAX_VALUE;
        int minIndex = -1;
        for (int i = 0; i < array.length; i++) {
            int current = ((Item<T>)array[i]).toInt();
            if (current < min) {
                min = current;
                minIndex = i;
            }
        }
        return minIndex;
    }
    public int linearSearchMax(Item<?>[] array) {
        int max = Integer.MIN_VALUE;
        int maxIndex = -1;
        for (int j = 0; j < array.length; j++) {
            int current = ((Item<T>)array[j]).toInt();
            if (current > max) {
                max = current;
                maxIndex = j;
            }
        }
        return maxIndex;
    }
    public Item<T>[] removeSortedDivision(Item<?>[] unsortedDivision, int index) {
        int newUnsortedDivisionLength = unsortedDivision.length - 1;
        Item<?>[] newUnsortedDivision = new Item[newUnsortedDivisionLength];
        for (int i = 0; i < index; i++) {
            newUnsortedDivision[i] = unsortedDivision[i];
        }
        for (int i = index+1; i <= newUnsortedDivisionLength; i++) {
            newUnsortedDivision[i-1] = unsortedDivision[i];
        }
        /*System.out.print("unsortedDivision = [");
        for (int k = 0; k < newUnsortedDivision.length; k++) {
            System.out.print(String.valueOf(newUnsortedDivision[k]).concat(","));
        }
        System.out.print("]\n");*/
        return (Item<T>[])newUnsortedDivision;     
    }
    public Item<T>[] multisortFrame(Item<?>[] unsortedDivision, int numberOfDivisions) {
        Item<?>[] sortedDivision = new Item[numberOfDivisions];
        int sortedArrayLength = sortedDivision.length;
        int halfSortedArrayLength = sortedArrayLength/2;
        int minDivisionIndex = 0;
        int maxDivisionIndex = numberOfDivisions - 1;
        if (sortedArrayLength == 1) {
            sortedDivision[0] = unsortedDivision[0];
        } else if (sortedArrayLength == 2) {
            Item<?> firstItem = (Item<T>)unsortedDivision[0];
            Item<?> secondItem = (Item<T>)unsortedDivision[1];
            if (firstItem.toInt() <= secondItem.toInt()) {
                sortedDivision[0] = firstItem;
                sortedDivision[1] = secondItem;
            } else {
                sortedDivision[0] = secondItem;
                sortedDivision[1] = firstItem;
            }
        } else {
            while ((minDivisionIndex < halfSortedArrayLength) && (maxDivisionIndex > sortedArrayLength-1-halfSortedArrayLength)) {
                int indexOfMin = linearSearchMin(unsortedDivision);
                sortedDivision[minDivisionIndex] = unsortedDivision[indexOfMin];
                //System.out.println("sortedDivision[".concat(String.valueOf(minDivisionIndex)).concat("] = ").concat(String.valueOf(sortedDivision[minDivisionIndex])));
                minDivisionIndex++;
                unsortedDivision = removeSortedDivision(unsortedDivision, indexOfMin);
                int indexOfMax = linearSearchMax(unsortedDivision);
                sortedDivision[maxDivisionIndex] = unsortedDivision[indexOfMax];
                //System.out.println("sortedDivision[".concat(String.valueOf(maxDivisionIndex)).concat("] = ").concat(String.valueOf(sortedDivision[maxDivisionIndex])));
                maxDivisionIndex--;
                unsortedDivision = removeSortedDivision(unsortedDivision, indexOfMax);
            }
            if (sortedArrayLength % 2 != 0) {
                sortedDivision[halfSortedArrayLength] = unsortedDivision[0];
            }
        }
        return (Item<T>[])sortedDivision;
    }
    public Item<T>[] populateUnsortedSubarray(Item<?>[] unsorted, int index, int numberOfDivisions) {
        Item<?>[] unsortedSubarray = new Item[numberOfDivisions];
        int unsortedSubarrayIndex = 0;
        for (int i = index; i < numberOfDivisions+index; i++) {
            unsortedSubarray[unsortedSubarrayIndex] = unsorted[i];
            unsortedSubarrayIndex++;
        }
        return (Item<T>[])unsortedSubarray;
    }
    public Item<T>[][] getSortedSubarrays(Item<?>[] unsorted, int numberOfDivisions, int divisor) {
        int unsortedLength = unsorted.length;
        Item<?>[][] sortedSubarrays = new Item[divisor][numberOfDivisions];
        int sortedSubarraysIndex = 0;
        for (int i = 0; i < unsortedLength; i+=numberOfDivisions) {
            Item<?>[] unsortedSubarray = populateUnsortedSubarray(unsorted, i, numberOfDivisions);
            /*System.out.print("unsortedSubarray[".concat(String.valueOf(sortedSubarraysIndex)).concat("] = ["));
            for (int k = 0; k < unsortedSubarray.length; k++) {
                System.out.print(String.valueOf(unsortedSubarray[k]).concat(","));
            }
            System.out.print("]\n");*/
            Item<?>[] sortedSubarray = multisortFrame(unsortedSubarray, numberOfDivisions);
            /*System.out.print("sortedSubarray[".concat(String.valueOf(sortedSubarraysIndex)).concat("] = ["));
            for (int j = 0; j < sortedSubarray.length; j++) {
                System.out.print(String.valueOf(sortedSubarray[j]).concat(","));
            }
            System.out.print("]\n");*/
            sortedSubarrays[sortedSubarraysIndex] = sortedSubarray;
            sortedSubarraysIndex++;
        }
        return (Item<T>[][])sortedSubarrays;
    }
    public Item<T>[][] getSortOrder(Item<?>[][] sortedSubarrays, int numberOfDivisions, int divisor) {
        Item<?>[][] sortedOrderedSubarrays = new Item[numberOfDivisions][divisor];
        int sortLevelIndex = 0;
        while (sortLevelIndex < numberOfDivisions) {
            Item<?>[] unsortedSortLevel = new Item[divisor];
            for (int i = 0; i < unsortedSortLevel.length; i++) {
                unsortedSortLevel[i] = sortedSubarrays[i][sortLevelIndex];
            }
            /*System.out.print("unsortedSortLevel[".concat(String.valueOf(sortLevelIndex)).concat("] = ["));
            for (int k = 0; k < unsortedSortLevel.length; k++) {
                System.out.print(String.valueOf(unsortedSortLevel[k]).concat(","));
            }
            System.out.print("]\n");*/
            Item<?>[] sortedSortLevel = multisortFrame(unsortedSortLevel, unsortedSortLevel.length);
            /*System.out.print("sortedSortLevel[".concat(String.valueOf(sortLevelIndex)).concat("] = ["));
            for (int m = 0; m < sortedSortLevel.length; m++) {
                System.out.print(String.valueOf(sortedSortLevel[m]).concat(","));
            }
            System.out.print("]\n");*/   
            sortedOrderedSubarrays[sortLevelIndex] = sortedSortLevel;
            sortLevelIndex++;
        }
        return (Item<T>[][])sortedOrderedSubarrays;
    }
    public Item<T>[] subsort(Item<?>[] firstSortOrderLevel, Item<?>[] secondSortOrderLevel) {
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
            //System.out.println("subsortedIndex = ".concat(String.valueOf(subsortedIndex)));
            while ((firstSortOrderIndex < firstSortOrderLevel.length) && (secondSortOrderIndex < secondSortOrderLevel.length)) {
                //System.out.println("firstSortOrderLevel[".concat(String.valueOf(firstSortOrderIndex)).concat("] = ").concat(String.valueOf(((Item<T>)firstSortOrderLevel[firstSortOrderIndex]).toInt())).concat(", secondSortOrderLevel[").concat(String.valueOf(secondSortOrderIndex)).concat("] = ").concat(String.valueOf(((Item<T>)secondSortOrderLevel[secondSortOrderIndex]).toInt())));
                if (((Item<T>)firstSortOrderLevel[firstSortOrderIndex]).toInt() < ((Item<T>)secondSortOrderLevel[secondSortOrderIndex]).toInt()) {
                    subsorted[subsortedIndex] = (Item<T>)firstSortOrderLevel[firstSortOrderIndex];
                    firstSortOrderIndex++;
                    subsortedIndex++;
                } else if (((Item<T>)firstSortOrderLevel[firstSortOrderIndex]).toInt() <= ((Item<T>)secondSortOrderLevel[secondSortOrderIndex]).toInt()) {
                    subsorted[subsortedIndex] = (Item<T>)firstSortOrderLevel[firstSortOrderIndex];
                    firstSortOrderIndex++;
                    subsorted[subsortedIndex+1] = (Item<T>)secondSortOrderLevel[secondSortOrderIndex];
                    secondSortOrderIndex++;
                    subsortedIndex+=2;
                } else {
                    subsorted[subsortedIndex] = (Item<T>)secondSortOrderLevel[secondSortOrderIndex];
                    secondSortOrderIndex++;
                    subsortedIndex++;
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
        /*System.out.print("subsorted = [");
        for (int i = 0; i < subsorted.length; i++) {
            System.out.print(String.valueOf(((Item<T>[])subsorted)[i]).concat(","));
        }
        System.out.print("]\n");*/
        return (Item<T>[])subsorted;
    }
    public Item<T>[] sortTruncate(Item<?>[][] sortOrder, int numberOfDivisions, int divisor) {
        int sortedLength = numberOfDivisions * divisor;
        Item<?>[] sorted = new Item[0];
        for (int i = 0; i < sortOrder.length; i++) {
            sorted = subsort(sorted, (Item<T>[])sortOrder[i]);
        }
        /*System.out.print("allSorted = [");
        for (int j = 0; j < sorted.length; j++) {
            System.out.print(String.valueOf(sorted[j]).concat(","));
        }
        System.out.print("]\n");*/
        return (Item<T>[])sorted;
    }
    public void sort(boolean createSortOrder) {
        Item<?>[] unsortedItems = getItems();
        int primeDivisions = calculatePrimeDivisions(unsortedItems);
        int divisor = unsortedItems.length/primeDivisions;
        Item<?>[][] sortedSubarrays = getSortedSubarrays(unsortedItems, primeDivisions, divisor);
        Item<?>[] allSorted = null;
        if (createSortOrder) {
            Item<?>[][] sortOrder = getSortOrder(sortedSubarrays, primeDivisions, divisor);
            allSorted = sortTruncate(sortOrder, primeDivisions, divisor);
        } else {
            allSorted = sortTruncate(sortedSubarrays, primeDivisions, divisor);
        }
        setItems(allSorted);
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
