public class DynamicItemStore<T> extends AbstractItemStore<T> implements IStorable<T> {
    public DynamicItemStore() {
        super();
        super.setItems(new Item[]{});
    }
    public int getIndex(Item<?> item) {
        int index = -1;
        Item<?>[] items = getItems();
        for (int i = 0; i < items.length; i++) {
            if (items[i].equals(item)) {
                index = i;
                break;
            }
        }
        return index;
    }
    public Item<T> getCurrentItem() {
        return (Item<T>)getItems()[getCurrentIndex()];
    }
    public void setItem(Item<?> newItem) {
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
