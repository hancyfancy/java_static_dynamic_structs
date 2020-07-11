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
    private boolean isNumericString(String stringToBeChecked) {
        boolean isNumeric = true;
        if (stringToBeChecked != null && stringToBeChecked.length() > 0) {
            for (char c : stringToBeChecked.toCharArray()) {
                if (!Character.isDigit(c)) {
                    isNumeric = false;
                }
            }
        } else {
            isNumeric = false;
        }
        return isNumeric;
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
            for (int j = 0; j < primeNumbersSplitLength; j++) {
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
            if (unsortedItemsLength % currentPrime == 0) {
                requiredPrime = currentPrime;
                break;
            }
        }
        return (requiredPrime == -1 ? 1 : requiredPrime);
    }
    private String minString(String firstString, String secondString) {
        String minString = null;
        int counter = 0;
        int maxLength = -1;
        if (firstString.length() >= secondString.length()) {
            maxLength = firstString.length();
        } else if (secondString.length() > firstString.length()) {
            maxLength = secondString.length();
        }
        for (int i = 0; i < maxLength; i++) {
            if (((int)firstString.charAt(i)) < ((int)secondString.charAt(i))) {
                if (this.isNumericString(firstString) && this.isNumericString(secondString)) {
                    if (firstString.length() > secondString.length()) {
                        minString = secondString;
                    } else {
                        minString = firstString;
                    }
                } else {
                    minString = firstString;
                }
                break;
            } else if (((int)secondString.charAt(i)) < ((int)firstString.charAt(i))) {
                if (this.isNumericString(firstString) && this.isNumericString(secondString)) {
                    if (secondString.length() > firstString.length()) {
                        minString = firstString;
                    } else {
                        minString = secondString;
                    }
                } else {
                    minString = secondString;
                }
                break;
            }
            counter++;
        }
        if (counter == maxLength-1) {
            minString = firstString;
        }
        return minString;
    }
    private String maxString(String firstString, String secondString) {
        String maxString = null;
        int counter = 0;
        int maxLength = -1;
        if (firstString.length() >= secondString.length()) {
            maxLength = firstString.length();
        } else if (secondString.length() > firstString.length()) {
            maxLength = secondString.length();
        }
        for (int i = 0; i < maxLength; i++) {
            if (((int)firstString.charAt(i)) > ((int)secondString.charAt(i))) {
                if (this.isNumericString(firstString) && this.isNumericString(secondString)) {
                    if (firstString.length() < secondString.length()) {
                        maxString = secondString;
                    } else {
                        maxString = firstString;
                    }
                } else {
                    maxString = firstString;
                }
                break;
            } else if (((int)secondString.charAt(i)) > ((int)firstString.charAt(i))) {
                if (this.isNumericString(firstString) && this.isNumericString(secondString)) {
                    if (secondString.length() > firstString.length()) {
                        maxString = firstString;
                    } else {
                        maxString = secondString;
                    }
                } else {
                    maxString = secondString;
                }
                break;
            }
            counter++;
        }
        if (counter == maxLength-1) {
            maxString = firstString;
        }
        return maxString;
    }
    private int linearSearchMin(Item<?>[] array) {
        String min = "";
        for (int j = 0; j < array[0].toString().length(); j++) {
            min += 'z';
        }
        int minIndex = -1;
        for (int i = 0; i < array.length; i++) {
            String current = ((Item<T>)array[i]).toString();
            if (minString(current, min).equals(current)) {
                min = current;
                minIndex = i;
            }
        }
        return minIndex;
    }
    private int linearSearchMax(Item<?>[] array) {
        String max = "";
        for (int j = 0; j < array[0].toString().length(); j++) {
            max += '0';
        }
        int maxIndex = -1;
        for (int j = 0; j < array.length; j++) {
            String current = ((Item<T>)array[j]).toString();
            if (maxString(current, max).equals(current)) {
                max = current;
                maxIndex = j;
            }
        }
        return maxIndex;
    }
    private Item<T>[] removeSortedDivision(Item<?>[] unsortedDivision, int index) {
        int newUnsortedDivisionLength = unsortedDivision.length - 1;
        Item<?>[] newUnsortedDivision = new Item[newUnsortedDivisionLength];
        for (int i = 0; i < index; i++) {
            newUnsortedDivision[i] = unsortedDivision[i];
        }
        for (int i = index+1; i <= newUnsortedDivisionLength; i++) {
            newUnsortedDivision[i-1] = unsortedDivision[i];
        }
        return (Item<T>[])newUnsortedDivision;     
    }
    private Item<T>[] multisortFrame(Item<?>[] unsortedDivision, int numberOfDivisions) {
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
            if (minString(firstItem.toString(),secondItem.toString()).equals(firstItem.toString())) {
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
                minDivisionIndex++;
                unsortedDivision = removeSortedDivision(unsortedDivision, indexOfMin);
                int indexOfMax = linearSearchMax(unsortedDivision);
                sortedDivision[maxDivisionIndex] = unsortedDivision[indexOfMax];
                maxDivisionIndex--;
                unsortedDivision = removeSortedDivision(unsortedDivision, indexOfMax);
            }
            if (sortedArrayLength % 2 != 0) {
                sortedDivision[halfSortedArrayLength] = unsortedDivision[0];
            }
        }
        return (Item<T>[])sortedDivision;
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
            Item<?>[] sortedSubarray = multisortFrame(unsortedSubarray, numberOfDivisions);
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
            Item<?>[] sortedSortLevel = multisortFrame(unsortedSortLevel, unsortedSortLevel.length);
            sortedOrderedSubarrays[sortLevelIndex] = sortedSortLevel;
            sortLevelIndex++;
        }
        return (Item<T>[][])sortedOrderedSubarrays;
    }
    private Item<T>[] subsort(Item<?>[] firstSortOrderLevel, Item<?>[] secondSortOrderLevel) {
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
                if (minString(((Item<T>)firstSortOrderLevel[firstSortOrderIndex]).toString(),((Item<T>)secondSortOrderLevel[secondSortOrderIndex]).toString()).equals(((Item<T>)firstSortOrderLevel[firstSortOrderIndex]).toString())) {
                    subsorted[subsortedIndex] = (Item<T>)firstSortOrderLevel[firstSortOrderIndex];
                    firstSortOrderIndex++;
                    subsortedIndex++;
                } else if (maxString(((Item<T>)firstSortOrderLevel[firstSortOrderIndex]).toString(),((Item<T>)secondSortOrderLevel[secondSortOrderIndex]).toString()).equals(((Item<T>)firstSortOrderLevel[firstSortOrderIndex]).toString())) {
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
        int sortedLength = numberOfDivisions * divisor;
        Item<?>[] sorted = new Item[0];
        for (int i = 0; i < sortOrder.length; i++) {
            sorted = subsort(sorted, (Item<T>[])sortOrder[i]);
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
