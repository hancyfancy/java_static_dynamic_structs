interface ITwoDimensionStorable<K,V> {
    K getKeyAtPosition(int index);
    V getValueAtPosition(int index);
    K getKey(Object val);
    V getValue(Object key);
    void add(Object key, Object value);
}
