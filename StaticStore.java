import java.lang.reflect.Method;

public class StaticStore<T> extends ItemStore<T> implements IOneDimensionIterable<T>, IOneDimensionStorable<T> {
    private int length;
    public StaticStore(int length) {
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
        if (index == -1)
        {
            Class thisClass = this.getClass();
            Method thisMethod = thisClass.getEnclosingMethod();
            throw new Error(thisClass.getName().concat(".").concat(thisMethod.getName()).concat(": Specified item does not exist."));
        }
        return index;
    }
    public int getIndex(Object object) {
        return getIndex(new Item(object));
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
    private Item<T> getCurrentItem() {
        return (Item<T>)getItems()[getCurrentIndex()];
    }
    private void setItem(Item<?> newItem) {
        int currentIndex = super.getCurrentIndex();
        Item<?>[] items = super.getItems();
        int length = getLength();
        if (currentIndex < length) {
            if (items[currentIndex] == null) {
                items[currentIndex] = newItem;
            } else {
                Class thisClass = this.getClass();
                Method thisMethod = thisClass.getEnclosingMethod();
                throw new Error(thisClass.getName().concat(".").concat(thisMethod.getName()).concat(": Length of static item store is ".concat(String.valueOf(length)).concat(", cannot add extra items.")));
            }
        }
        super.setItems(items);
        int nextIndex = currentIndex + 1;
        if (nextIndex < length) {
            super.setCurrentIndex(nextIndex);
        }
    }
    public void add(Object toBeAdded) {
        this.setItem(new Item(toBeAdded));
    }
    private void replaceItem(int index, Item<?> newItem) {
        if (index < getLength()) {
            Item<?>[] items = getItems();
            if (items[index] != null) {
                items[index] = newItem;
            } else {
                Class thisClass = this.getClass();
                Method thisMethod = thisClass.getEnclosingMethod();
                throw new Error(thisClass.getName().concat(".").concat(thisMethod.getName()).concat(": Null items cannot be replaced, try adding or inserting instead."));
            }
            super.setItems(items);
        }
    }
    public void replace(int index, Object toBeReplaced) {
        this.replaceItem(index, new Item(toBeReplaced)); 
    }
}
