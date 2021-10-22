package listTwo;

public class DoubleSinglyList <T>{
    DoubleNode<T> head;
    DoubleNode<T> rear;
    public DoubleSinglyList(){
        this.head=new DoubleNode<>(null,null,new DoubleNode<>(null,null,null));
        this.rear=new DoubleNode<>(null,new DoubleNode<>(null,null,null),null);
        head.next=rear;
        rear.prev=head;
    }
    public DoubleSinglyList(T[] value){
        this();
        for(int i=0;i<value.length;i++){
            DoubleNode<T> p=new DoubleNode<T>(value[i],rear.prev,rear);
            rear.prev.next=p;
            rear.prev=p;
        }
    }
    public DoubleSinglyList(DoubleSinglyList doubleSinglyList){
        this();
        DoubleNode<T> front=this.head;
        DoubleNode<T> suc=front.next;
        DoubleNode<T> doubleNode=doubleSinglyList.head.next;
        for(;doubleNode.next!=null;doubleNode=doubleNode.next){
            DoubleNode<T> node=new DoubleNode<>(doubleNode.data,front,suc);
            front.next=node;
            suc.prev=node;
            front=node;
            suc=front.next;
        }
    }
    public boolean isEmpty(){
        return head.next==null;
    }
    public String toString(){
        DoubleNode<T> p=new DoubleNode<>();
        String str="(";
       for(p=this.head.next;p!=null&&p.next!=null;p=p.next){
           str+=p.data.toString()+(p.next.next!=null?",":"");
       }
        return str+")";
    }
    public T get(int x){
        DoubleNode<T> p=this.head;
        for(int i=0;i<x&&p.next!=null;i++){
            p=p.next;
        }
        return x>=0&&p.next!=null?p.next.data:null;//此处的p.next为超过索引，尾节点
    }
    public DoubleNode<T> insert(T d){
        DoubleNode<T> p=this.head;
        while(p.next!=null){
            p=p.next;
        }
        DoubleNode<T> doubleNode=new DoubleNode<T>(d,p.prev,rear);
        p.prev.next=doubleNode;
        rear.prev=doubleNode;
        return p;
    }
    public DoubleNode<T> insert(T d,int i){
        DoubleNode<T> p=this.head;
        for(int j=0;j<=i&&p.next!=null;j++){
            p=p.next;
        }
        DoubleNode<T> doubleNode=new DoubleNode<>(d,p.prev,p);
        p.prev.next=doubleNode;
        p.prev=doubleNode;
        return doubleNode;
    }
    public DoubleNode remove(int i){
        DoubleNode<T> p=this.head;
        for(int j=0;j<=i&&p.next!=null;j++){
            p=p.next;
        }
        if(p.next!=null){
            DoubleNode<T> front=p.prev;
            front.next=p.next;
            p.next.prev=front;
            return p;
        }else{
            return null;
        }
    }
    public static void main(String[] args) {
        String[] value={"长春","理工","大学"};
        DoubleSinglyList<String> doubleSinglyList=new DoubleSinglyList<>(value);
        System.out.println(doubleSinglyList.toString());
        DoubleSinglyList<String> dou=new DoubleSinglyList<>(doubleSinglyList);
        System.out.println(dou);

    }
}
