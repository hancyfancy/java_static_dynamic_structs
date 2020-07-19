public class StaticItemStore<T> extends AbstractItemStore<T> implements IIterable<T>, IOneDimensionStorable<T> {
    private int length;
    public StaticItemStore(int length) {
        super();        
        if (this.isLengthValid(length)) {
            this.setLength(length);
            super.setItems(new Item[length]);
        }
    }
    private int getIndex(Item<?> item) {
        int index = -1;
        Item<?>[] items = getItems();
        for (int i = 0; i < getLength(); i++) {
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
    @Override
    public int getLength() {
        return this.length;
    }
    private void setLength(int newLength) {
        if (newLength != getLength()) {
            this.length = newLength;
        }
    }
    private boolean isLengthValid(int newLength) {
        return (newLength > 0);
    }
    private Item<T> getCurrentItem() {
        return (Item<T>)getItems()[getCurrentIndex()];
    }
    private void setItem(Item<?> newItem) {
        Item<?>[] newItems = null;
        int currentIndex = getCurrentIndex();
        int length = getLength();
        if (currentIndex < length) {
            Item<?>[] items = getItems();
            newItems = new Item[items.length];
            for (int i = 0; i < length; i++) {
                Item<?> currentItem = items[i];
                if (currentItem != null) {
                    newItems[i] = currentItem;
                }
            }
            newItems[currentIndex] = newItem;
        }
        super.setItems(newItems);
        int nextIndex = currentIndex + 1;
        if (nextIndex < length) {
            super.setCurrentIndex(nextIndex);
        }
    }
    public void add(Object toBeAdded) {
        setItem(new Item(toBeAdded));
    }
    private void replaceItem(int index, Item<?> newItem) {
        if (index < getLength()) {
            Item<?>[] items = getItems();
            items[index] = newItem;
            super.setItems(items);
        }
    }
    public void replace(int index, Object toBeReplaced) {
        replaceItem(index, new Item(toBeReplaced)); 
    }
}
