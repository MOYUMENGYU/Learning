package listTwo;

public class CirDoubleSinglyList<T>{
    DoubleNode<T> head;
    DoubleNode<T> rear;
    public CirDoubleSinglyList(){
        this.head=new DoubleNode<>(null,null,new DoubleNode<>(null,null,null));
        this.rear=new DoubleNode<>(null,new DoubleNode<>(null,null,null),null);
        head.next=rear;
        head.prev=rear;
        rear.prev=head;
        rear.next=head;
    }
    public CirDoubleSinglyList(T[] value){
        this();
        for(int i=0;i<value.length;i++){
            DoubleNode<T> p=new DoubleNode<T>(value[i],rear.prev,rear);
            rear.prev.next=p;
            rear.prev=p;
        }
    }
    public CirDoubleSinglyList(CirDoubleSinglyList cirDoubleSinglyList){
        this();
        DoubleNode<T> front=this.head;
        DoubleNode<T> suc=front.next;
        DoubleNode<T> cir=cirDoubleSinglyList.head.next;
        for(;cir.next!=cirDoubleSinglyList.head;cir=cir.next){
            DoubleNode<T> doubleNode=new DoubleNode<>(cir.data,front,suc);
            front.next=doubleNode;
            suc.prev=doubleNode;
            front=doubleNode;
            suc=doubleNode.next;
        }
    }
    public boolean isEmpty(){
        return head.next==rear;
    }
    public String toString(){
        DoubleNode<T> p=new DoubleNode<>();
        String str="(";
       for(p=this.head.next;p!=head&&p.next!=head;p=p.next){
           str+=p.data+(p.next.next!=head?",":"");
       }
        return str+")";
    }
    public T get(int x){
        DoubleNode<T> p=this.head;
        for(int i=0;i<x&&p.next!=head;i++){
            p=p.next;
        }
        return x>=0&&p.next!=head?p.next.data:null;//此处的p.next为超过索引，尾节点
    }
    public DoubleNode<T> insert(T d){
        DoubleNode<T> p=this.head;
        while(p.next!=head){
            p=p.next;
        }
        DoubleNode<T> doubleNode=new DoubleNode<T>(d,p.prev,rear);
        p.prev.next=doubleNode;
        rear.prev=doubleNode;
        return p;
    }
    public DoubleNode<T> insert(T d,int i){
        DoubleNode<T> p=this.head;
        for(int j=0;j<=i&&p.next!=head;j++){
            p=p.next;
        }
        DoubleNode<T> doubleNode=new DoubleNode<>(d,p.prev,p);
        p.prev.next=doubleNode;
        p.prev=doubleNode;
        return doubleNode;
    }
    public DoubleNode remove(int i){
        DoubleNode<T> p=this.head;
        for(int j=0;j<=i&&p.next!=head;j++){
            p=p.next;
        }
        if(p.next!=head){
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
        CirDoubleSinglyList<String> doubleSinglyList=new CirDoubleSinglyList<>(value);
        System.out.println(doubleSinglyList.toString());
        CirDoubleSinglyList<String> d=new CirDoubleSinglyList<>(doubleSinglyList);
        System.out.println(d);
    }
}
