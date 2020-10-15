public class DynamicUniqueStore<T> extends DynamicStore<T> {
    public DynamicUniqueStore() {
        super();
    }
    protected void setItem(Item<?> newItem) {
        try {
            super.getIndex(newItem);
        } catch (Exception ex) {
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
    }
}
