public class Item<T> {
    private T content;
    public Item(T newContent) {
        this.setContent(newContent);
    }
    public T getContent() {
        return this.content;
    }
    private void setContent(T newContent) {
        if (newContent != getContent()) {
            this.content = newContent;
        }
    }
    public boolean equals(Object compareContent) {
        String thisContent = String.valueOf(getContent());
        String contentToCompare = String.valueOf((T)compareContent);
        return thisContent.equals(contentToCompare);
    }
    public int toInt() {
        return Integer.valueOf(toString());
    }
    public String toString() {
        return String.valueOf(getContent());
    }
    public Object toObject() {
        return (Object)getContent();
    }
}
