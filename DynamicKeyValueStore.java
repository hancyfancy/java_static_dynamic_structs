public class DynamicKeyValueStore<K,V> implements IIterable<K>, ISortable<K>, ITwoDimensionStorable<K> {
    private DynamicItemStore<?> keys;
    private DynamicItemStore<?> values;
    public DynamicKeyValueStore() {
        this.setKeys(new DynamicItemStore<K>());
        this.setValues(new DynamicItemStore<V>());
    }
    private DynamicItemStore<K> getKeys() {
        return (DynamicItemStore<K>)this.keys;
    }
    private void setKeys(DynamicItemStore<?> newKeys) {
        this.keys = newKeys;
    }
    private DynamicItemStore<V> getValues() {
        return (DynamicItemStore<V>)this.values;
    }
    private void setValues(DynamicItemStore<?> newValues) {
        this.values = newValues;
    }
    private int getIndex(Item<?> key) {
        return getKeys().getIndex(key);
    }
    public int getIndex(Object object) {
        return getIndex(new Item(object));
    }
    private Item<V> getValue(int index) {
        return getValues().getItem(index);
    }
    private Item<V> getValue(Item<?> key) {
        Item<?> value = null;
        DynamicItemStore<?> keys = getKeys();
        Item<?>[] keyItems = keys.getItems();
        int indexOfKey = keys.getIndex(key);
        if (keyItems.length > indexOfKey) {
            DynamicItemStore<?> values = getValues();
            Item<?>[] valueItems = values.getItems();
            value = valueItems[indexOfKey];
        }
        return (Item<V>)value;
    }
    public Object get(Object key, boolean byKey) {
        Object value = null;
        if (!byKey) {
            if (key.getClass().getName().equals("java.lang.Integer")) {
                int index = (int)key;
                if ((index > -1) && (index < getLength())) {
                    value = getValue(index).toObject();
                }
            }
        } else {
            value = getValue(new Item(key)).toObject();
        }
        return value;
    }
    public int getLength() {
        return getKeys().getLength();
    }
    private void set(Item<?> key, Item<?> value) {
        DynamicItemStore<?> keys = getKeys();
        DynamicItemStore<?> values = getValues();
        keys.setItem(key);
        values.setItem(value);
        this.setKeys(keys);
        this.setValues(values);
    }
    public void add(Object key, Object value) {
        set(new Item(key), new Item(value));
    }
    private void sort(boolean createSortOrder) {
        DynamicItemStore<?> originalKeys = new DynamicItemStore<K>();
        DynamicItemStore<?> keys = getKeys();
        for (int i = 0; i < keys.getItems().length; i++) {
            originalKeys.setItem(new Item(keys.getItem(i)));
        }
        keys.sort(createSortOrder);
        int[] sortedIndices = new int[keys.getItems().length];
        for (int i = 0; i < keys.getItems().length; i++) {
            sortedIndices[i] = originalKeys.getIndex(keys.getItem(i));
        }
        DynamicItemStore<?> sortedValues = new DynamicItemStore<V>();
        DynamicItemStore<?> values = getValues();
        for (int j = 0; j < sortedIndices.length; j++) {
            sortedValues.setItem(values.getItem(sortedIndices[j]));
        }
        this.setKeys(keys);
        this.setValues(sortedValues);
    }
    public void sort() {
        sort(false);
    }
    public String toString() {
        String output = "";
        Item<?>[] keyItems = getKeys().getItems();
        Item<?>[] valueItems = getValues().getItems();
        for (int i = 0; i < keyItems.length; i++) {
            output = output.concat("Index ").concat(String.valueOf(i)).concat(": Key -> ").concat(String.valueOf(keyItems[i])).concat(", Value -> ").concat(String.valueOf(valueItems[i])).concat("\n");
        }
        return output;
    }
}
