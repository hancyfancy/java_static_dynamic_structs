public class StaticItemStore<T> extends AbstractItemStore<T> implements IStorable<T> {
    private int length;
    public StaticItemStore(int length) {
        super();        
        if (this.isLengthValid(length)) {
            this.setLength(length);
            super.setItems(new Item[length]);
        }
    }
    public int getIndex(Item<?> item) {
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
    public Item<T> getCurrentItem() {
        return (Item<T>)getItems()[getCurrentIndex()];
    }
    public void setItem(Item<?> newItem) {
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
}
