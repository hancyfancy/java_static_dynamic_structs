interface IOneDimensionStorable<T> {
    public Object get(int index);
    public void add(Object toBeAdded);
    public void replace(int index, Object toBeReplaced);
}
