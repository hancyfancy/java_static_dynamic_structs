public class AbstractItemStore<T> {
    private int currentIndex;
    private Item<?>[] items;
    public AbstractItemStore() {
        this.setCurrentIndex(0);
    }
    public int getCurrentIndex() {
        return this.currentIndex;
    }
    protected void setCurrentIndex(int newCurrentIndex) {
        if (newCurrentIndex != getCurrentIndex()) {
            this.currentIndex = newCurrentIndex;
        }
    }
    public Item<T>[] getItems() {
        return (Item<T>[])this.items;
    }
    public Item<T> getItem(int index) {
        return (Item<T>)getItems()[index];
    }
    protected void setItems(Item<?>[] newItems) {
        if (newItems != getItems()) {
            this.items = newItems;
        }
    }
    public String toString() {
        String output = "";
        Item<?>[] items = getItems();
        for (int i = 0; i < items.length; i++) {
            output = output.concat("Index ").concat(String.valueOf(i)).concat(": ").concat(String.valueOf(items[i])).concat("\n");
        }
        return output;
    }
}
