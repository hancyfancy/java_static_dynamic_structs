import java.lang.reflect.Method;

public class DynamicMap<K,V> implements ISortable<K>, ITwoDimensionIterable<K,V>, ITwoDimensionStorable<K,V> {
    private DynamicUniqueStore<?> keys;
    private DynamicStore<?> values;
    public DynamicMap() {
        this.setKeys(new DynamicUniqueStore<K>());
        this.setValues(new DynamicStore<V>());
    }
    private DynamicUniqueStore<K> getKeys() {
        return (DynamicUniqueStore<K>)this.keys;
    }
    private void setKeys(DynamicUniqueStore<?> newKeys) {
        this.keys = newKeys;
    }
    private DynamicStore<V> getValues() {
        return (DynamicStore<V>)this.values;
    }
    private void setValues(DynamicStore<?> newValues) {
        this.values = newValues;
    }
    public int getLength() {
        return getKeys().getLength();
    }
    public int getKeyIndex(Object key) {
        return getKeys().getIndex(key);
    }
    public int getValueIndex(Object val) {
        return getValues().getIndex(val);
    }
    public K getKeyAtPosition(int index) {
        if ((index > -1) && (index < getLength())) {
            return getKeys().get(index);
        } else {
            Class thisClass = this.getClass();
            Method thisMethod = thisClass.getEnclosingMethod();
            throw new Error(thisClass.getName().concat(".").concat(thisMethod.getName()).concat(": Index must be non negative and less than length of Dynamic Map."));
        }
    }
    public V getValueAtPosition(int index) {
        if ((index > -1) && (index < getLength())) {
            return getValues().get(index);
        } else {
            Class thisClass = this.getClass();
            Method thisMethod = thisClass.getEnclosingMethod();
            throw new Error(thisClass.getName().concat(".").concat(thisMethod.getName()).concat(": Index must be non negative and less than length of Dynamic Map."));
        }
    }
    public K getKey(Object val)
    {
        K key = null;
        int indexOfVal = getValueIndex(val);
        if (getValues().getLength() > indexOfVal)
        {
            key = getKeyAtPosition(indexOfVal);
        }
        return key;
    }
    public V getValue(Object key)
    {
        V val = null;
        int indexOfKey = getKeyIndex(key);
        if (getKeys().getLength() > indexOfKey)
        {
            val = getValueAtPosition(indexOfKey);
        }
        return val;
    }
    public void add(Object key, Object value) {
        getKeys().add(key);
        int indexOfKey = getKeyIndex(key);
        if (getKeys().getLength() > indexOfKey)
        {
            try
            {
                getValues().replace(indexOfKey, value);
            }
            catch (Exception ex)
            {
                getValues().add(value);
            }
        }
    }
    public void sort() {
        DynamicUniqueStore<?> originalKeys = new DynamicUniqueStore<K>();
        DynamicUniqueStore<?> keys = getKeys();
        for (int i = 0; i < getLength(); i++) {
            originalKeys.add(keys.get(i));
        }
        keys.sort();
        int[] sortedIndices = new int[getLength()];
        for (int i = 0; i < getLength(); i++) {
            sortedIndices[i] = originalKeys.getIndex(keys.get(i));
        }
        DynamicStore<?> sortedValues = new DynamicStore<V>();
        DynamicStore<?> values = getValues();
        for (int j = 0; j < sortedIndices.length; j++) {
            sortedValues.add(values.get(sortedIndices[j]));
        }
        this.setKeys(keys);
        this.setValues(sortedValues);
    }
    public String toString() {
        String output = "";
        for (int i = 0; i < getLength(); i++) {
            output = output.concat("Index ").concat(String.valueOf(i)).concat(": Key -> ").concat(String.valueOf(getKeyAtPosition(i))).concat(", Value -> ").concat(String.valueOf(getValueAtPosition(i))).concat("\n");
        }
        return output;
    }
}