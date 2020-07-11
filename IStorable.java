interface IStorable<T> {
    public int getIndex(Item<?> item);
    public Item<T> getCurrentItem();
    public Item<T> getItem(int index);
    public void setItem(Item<?> newItem);
}
