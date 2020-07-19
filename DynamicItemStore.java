public class DynamicItemStore<T> extends AbstractItemStore<T> implements IInsertable<T>, IIterable<T>, IOneDimensionStorable<T> {
    public DynamicItemStore() {
        super();
        super.setItems(new Item[]{});
    }
    private int getIndex(Item<?> item) {
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
    public int getIndex(Object object) {
        return getIndex(new Item(object));
    }
    private Item<T> getCurrentItem() {
        return (Item<T>)getItems()[getCurrentIndex()];
    }
    protected void setItem(Item<?> newItem) {
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
    public void add(Object toBeAdded) {
        setItem(new Item(toBeAdded));
    }
    private void replaceItem(int index, Item<?> newItem) {
        Item<?>[] items = getItems();
        if (index < items.length) {
            items[index] = newItem;
            super.setItems(items);
        }
    }
    public void replace(int index, Object toBeReplaced) {
        replaceItem(index, new Item(toBeReplaced)); 
    }
    private void insertItem(int index, Item<?> newItem) {
        Item<?>[] newItems = null;
        Item<?>[] items = getItems();
        int itemsLength = items.length;
        if (index > -1) {
            if (index >= itemsLength) {
                super.setCurrentIndex(itemsLength);
                setItem(newItem);
            } else {
                newItems = new Item[itemsLength+1];
                if (index == 0) {
                    newItems[index] = newItem;
                    for (int i = index+1; i < newItems.length; i++) {
                        newItems[i] = items[i-1];
                    }
                } else { //index > 0 && index < itemsLength
                    for (int j = 0; j < index; j++) {
                        newItems[j] = items[j];
                    }
                    newItems[index] = newItem;
                    for (int k = index; k < items.length; k++) {
                        newItems[k+1] = items[k];
                    }
                }
                super.setItems(newItems);
            }
        }
    }
    public void insert(int index, Object toBeInserted) {
        insertItem(index, new Item(toBeInserted));
    }
}
