public class MyLittleList {
    private Item first;
    private Item end;
    public void add(Item data){
        Item temp = new Item();
        end.setLink(temp);
        end = temp;
    }
    public void paste(Item data,int index){
        Item temp = new Item();
        temp = first.getLink();
        for (int i = 0; i < index; i++) {
            temp = temp.getLink();
        }
        data.setLink(temp.getLink());
        temp.setLink(data);
    }
    public void delete(int index){
        Item temp = new Item();
        temp = first.getLink();
        for (int i = 0; i < index; i++) {
            temp = temp.getLink();
        }
        temp.setLink(temp.getLink().getLink());
    }
}
