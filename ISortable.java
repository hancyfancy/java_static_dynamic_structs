interface ISortable<T> {
    public boolean isPrimeNumber(int num);
    public int[] generatePrimeNumbers(int n);
    public int calculatePrimeDivisions(Item<?>[] unsortedItems);
    public int linearSearchMin(Item<?>[] array);
    public int linearSearchMax(Item<?>[] array);
    public Item<T>[] removeSortedDivision(Item<?>[] unsortedDivision, int index);
    public Item<T>[] multisortFrame(Item<?>[] unsortedDivision, int numberOfDivisions);
    public Item<T>[] populateUnsortedSubarray(Item<?>[] unsorted, int index, int numberOfDivisions);
    public Item<T>[][] getSortedSubarrays(Item<?>[] unsorted, int numberOfDivisions, int divisor);
    public Item<T>[][] getSortOrder(Item<?>[][] sortedSubarrays, int numberOfDivisions, int divisor);
    public Item<T>[] subsort(Item<?>[] firstSortOrderLevel, Item<?>[] secondSortOrderLevel);
    public Item<T>[] sortTruncate(Item<?>[][] sortOrder, int numberOfDivisions, int divisor);
    public void multisort(boolean createSortOrder);
}
