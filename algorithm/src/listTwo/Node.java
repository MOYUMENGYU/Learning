package listTwo;

public class Node<T> {
    public T data;//存储数据
    public Node next;//地址域,头节点没有数据，但有指针，头节点为第零个数，因为next是存有数据的
    public Node(T data,Node<T> next){
        this.data=data;//数据
        this.next=next;//地址，下一个节点
    }
    public Node(){//空的链表,哨兵head==null,head为空时，head中的next也为空，没有指向
        this(null,null);
    }
    public String toString(){
        return this.data.toString();
    }
}
