import java.lang.reflect.Method;

public class DynamicStore<T> extends ItemStore<T> implements IInsertable<T>, IOneDimensionIterable<T>, IOneDimensionStorable<T> {
    public DynamicStore() {
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
    private Item<T> getCurrentItem() {
        return (Item<T>)getItems()[getCurrentIndex()];
    }
    protected void setItem(Item<?> newItem) {
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
    public void add(Object toBeAdded) {
        this.setItem(new Item(toBeAdded));
    }
    private void replaceItem(int index, Item<?> newItem) {
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
    public void replace(int index, Object toBeReplaced) {
        this.replaceItem(index, new Item(toBeReplaced)); 
    }
    private void insertItem(int index, Item<?> newItem) {
        Item<?>[] newItems = null;
        Item<?>[] items = super.getItems();
        int itemsLength = items.length;
        if (index > -1) {
            if (index == itemsLength) {
                super.setCurrentIndex(itemsLength);
                setItem(newItem);
            } else if (index > itemsLength) {
                Class thisClass = this.getClass();
                Method thisMethod = thisClass.getEnclosingMethod();
                throw new Error(thisClass.getName().concat(".").concat(thisMethod.getName()).concat(": Index must be less than or equal to length of Dynamic Store."));
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
        } else {
            Class thisClass = this.getClass();
            Method thisMethod = thisClass.getEnclosingMethod();
            throw new Error(thisClass.getName().concat(".").concat(thisMethod.getName()).concat(": Index must be non negative."));
        }
    }
    public void insert(int index, Object toBeInserted) {
        this.insertItem(index, new Item(toBeInserted));
    }
}
