public class DynamicUniqueItemStore<T> extends DynamicItemStore<T> {
    public DynamicUniqueItemStore() {
        super();
    }
    @Override
    protected void setItem(Item<?> newItem) {
        if (getIndex(newItem) == -1) {
            Item<?>[] newItems = null;
            int currentIndex = getCurrentIndex();
            int nextIndex = currentIndex + 1;
            Item<?>[] items = getItems();
            int itemsLength = items.length;
            int nextItemsLength = itemsLength + 1;
            newItems = new Item[nextItemsLength];
            for (int i = 0; i < itemsLength; i++) {
                Item<?> currentItem = items[i];
                if (currentItem != null) {
                    newItems[i] = currentItem;
                }
            }
            newItems[currentIndex] = newItem;
            super.setItems(newItems);
            super.setCurrentIndex(nextIndex);
        }
    }
}
