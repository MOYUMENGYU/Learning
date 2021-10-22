package listTwo;

public class SortedCirDoubleList<T extends Comparable<? super T>> extends CirDoubleSinglyList {
    private boolean asc;
    public SortedCirDoubleList(){
        super();
        this.asc=true;
    }
    public SortedCirDoubleList(T[] value){
        super();
        this.asc=true;
        for(int i=0;i<value.length;i++){
            insert(value[i]);
        }
    }
    public SortedCirDoubleList(SortedCirDoubleList<T> doubleList){
        super();
        this.asc=true;
        CirDoubleSinglyList<T> cirDoubleSinglyList=new CirDoubleSinglyList<>(doubleList);
        DoubleNode<T> node=cirDoubleSinglyList.head.next;
        while(node!=cirDoubleSinglyList.head){
            insert(node.data);
            node=node.next;
        }
    }
    public SortedCirDoubleList(CirDoubleSinglyList<T> cirDoubleSinglyList,boolean asc){
        super();
        this.asc=asc;
        CirDoubleSinglyList<T> cir=new CirDoubleSinglyList<>(cirDoubleSinglyList);
        DoubleNode<T> cirNode=cir.head.next;
        while(cirNode.next!=cir.head){
            insert(cirNode.data);
            cirNode=cirNode.next;
        }
    }

    public DoubleNode<T> insert(T x){
        if(x==null){
            return null;
        }
        DoubleNode<T> front=this.head;
        DoubleNode<T> p=front.next;
        while(p.next!=head&&(this.asc?x.compareTo(p.data)>=0:x.compareTo(p.data)<=0)){
            front=p;
            p=front.next;
        }
        DoubleNode<T> doubleNode=new DoubleNode<>(x,front,p);
        front.next=doubleNode;
        p.prev=doubleNode;
        return doubleNode;
    }
    public static void main(String[] args) {
        Integer[] value={3,2,5,6,6};
        CirDoubleSinglyList<Integer> cirDoubleSinglyList=new CirDoubleSinglyList<>(value);
        SortedCirDoubleList<Integer> sortedCirDoubleList=new SortedCirDoubleList<>(cirDoubleSinglyList,false);
        System.out.println(sortedCirDoubleList);
        SortedCirDoubleList<Integer> s=new SortedCirDoubleList<Integer>(sortedCirDoubleList);
        System.out.println(s);
    }
}
