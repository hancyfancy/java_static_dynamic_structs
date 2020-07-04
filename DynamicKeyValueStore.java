public class DynamicKeyValueStore<K,V> {
    private DynamicItemStore<?> keys;
    private DynamicItemStore<?> values;
    public DynamicKeyValueStore() {
        this.setKeys(new DynamicItemStore<K>());
        this.setValues(new DynamicItemStore<V>());
    }
    public DynamicItemStore<K> getKeys() {
        return (DynamicItemStore<K>)this.keys;
    }
    private void setKeys(DynamicItemStore<?> newKeys) {
        this.keys = newKeys;
    }
    public DynamicItemStore<V> getValues() {
        return (DynamicItemStore<V>)this.values;
    }
    private void setValues(DynamicItemStore<?> newValues) {
        this.values = newValues;
    }
    public int index(Item<?> key) {
        return getKeys().getIndex(key);
    }
    public Item<V> get(int index) {
        return getValues().getItem(index);
    }
    public Item<V> get(Item<?> key) {
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
    public void set(Item<?> key, Item<?> value) {
        DynamicItemStore<?> keys = getKeys();
        DynamicItemStore<?> values = getValues();
        keys.setItem(key);
        values.setItem(value);
        this.setKeys(keys);
        this.setValues(values);
    }
    public void sort(boolean createSortOrder) {
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
