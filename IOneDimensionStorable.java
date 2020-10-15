interface IOneDimensionStorable<T> {
    T get(int index);
    void add(Object toBeAdded);
    void replace(int index, Object toBeReplaced);
    void replaceAll(Object toBeReplaced);
}
