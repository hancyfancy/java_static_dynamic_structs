interface IOneDimensionStorable<T> {
    public T get(int index);
    public void add(Object toBeAdded);
    public void replace(int index, Object toBeReplaced);
}
