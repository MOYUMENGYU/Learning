package listTwo;

public class SortedSinglyList<T extends Comparable<? super T>> extends SinglyList<T>{
    protected boolean asc;
    public SortedSinglyList(boolean asc){
        super();
        this.asc=asc;
    }
    public SortedSinglyList(){
        this(true);
    }
    public SortedSinglyList(T[] values,boolean asc){
        super();
        this.asc=asc;
        for(int i=0;i<values.length;i++){
            insert(values[i]);
        }
    }
    public SortedSinglyList(T[] values){
        this(values,true);
    }
    public SortedSinglyList(SortedSinglyList<T> list){
        this();
        this.asc=true;
        SinglyList<T> singlyList=new SinglyList<>(list);
        Node<T> p=singlyList.head.next;
        while(p!=null){
            insert(p.data);
            p=p.next;
        }
    }
    public SortedSinglyList(SinglyList<T> list,boolean asc){
        this();
        SinglyList<T> singlyList=new SinglyList<>(list);
        Node<T> p=singlyList.head.next;
        while(p!=null){
            this.insert(p.data);
            p=p.next;
        }
    }
    public SortedSinglyList(SinglyList<T> list){
       this(list,true);
    }
    public void set(int i,T x) throws Exception {
        throw new Exception("不支持进行修改");
    }
    public void inert(int i,T x) throws Exception {
        throw new Exception("不支持进行修改");
    }
    public Node<T> insert(T x){
        if(x==null){
            return null;
        }
        //以下循环寻找插入位置，插入在等值结点之后
        Node<T> front=this.head;
        Node<T> p=front.next;//front指向p的前驱节点
        while(p!=null&&(this .asc?x.compareTo(p.data)>=0:x.compareTo(p.data)<=0)){//根据升序或者是降序进行移动
            front=p;
            p=p.next;
        }
        front.next=new Node<T>(x,p);//最终都是插入到front的后面即是front.next,后一个指向的是p
        return front.next;
    }
    public Node<T> search(T key){
        if(key.equals("")){
            return null;
        }
        Node<T> p=this.head.next;
        while(p!=null){
            if(p.data.compareTo(key)==0){
                return p;
            }
            p=p.next;
        }
        return super.search(key);
    }
    public T remove(T key){
        Node<T> front=this.head;
        Node<T> p=front.next;
        while(p!=null){
            if(p.data.compareTo(key)==0){
                Node<T> temp=p;
                front.next=p.next;
                return temp.data;
            }
            front=p;
            p=front.next;
        }
        return null;
    }
    public boolean equals(Object obj){
       if(this.asc==((SortedSinglyList<T>)obj).asc){
           super.equals(obj);
       }
       return false;
    }
    public void concat(SinglyList<T> list) throws Exception {
        throw new Exception("无法合并");
    }
    public void addAll(SinglyList<T> list){
        SinglyList<T> singlyList=new SinglyList<>(list);
        Node<T> p= singlyList.head.next;
        while(p!=null){
            insert(p.data);
            p=p.next;
        }
    }
    public SortedSinglyList<T> union(SinglyList<T> list){
        SortedSinglyList<T> sortedSinglyList=new SortedSinglyList<>(this);
        SinglyList<T> singlyList1=new SinglyList<>(list);
        Node<T> p=singlyList1.head.next;
        while(p!=null){
            sortedSinglyList.insert(p.data);
            p=p.next;
        }
        return sortedSinglyList;
    }

    public static void main(String[] args) {
        Integer[] value={2,3,6,3,7};
        SortedSinglyList<Integer> s1=new SortedSinglyList<>(value);
        System.out.println(s1.toString());
        SortedSinglyList<Integer> s2=new SortedSinglyList<>(s1,true);
        System.out.println(s2.toString());
    }
}
