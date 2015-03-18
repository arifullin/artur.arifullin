public class Item<T> {
    private Item nextItem;
    private T data;

    public void setData(T something){
        data = something;
    }
    public T getData(){
        return data;
    }
    public Item getLink(){
        return nextItem;
    }
    public void setLink(Item next){
        nextItem = next;
    }
}
