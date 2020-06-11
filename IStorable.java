interface IStorable<T> {
    public int getIndex(Item<?> item);
    public Item<T> getCurrentItem();
    public void setItem(Item<?> newItem);
}
