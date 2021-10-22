package listTwo;

public class DoubleNode<T> {
    public T data;
    public DoubleNode<T> prev;
    public DoubleNode<T> next;
    public DoubleNode(T data,DoubleNode<T> prev,DoubleNode<T> next){
        this.data=data;
        this.prev=prev;
        this.next=next;
    }
    public DoubleNode(){
        this.data=null;
        this.prev=null;
        this.next=null;
    }
}
