package list;

public class StringList <T>{
    public Node<T> head; //头指针，哨兵，用来判空，设边界
    public StringList(){
        this.head=new Node<>();//一个空的链表
    }
    public StringList(T[] value){
        this();//空链表
        Node<T> rear=this.head;
        for(int i=0;i<value.length;i++){
            if(value[i]!=null){
                //第一次的时候rear.next与head.next是一样的，
                rear.next=new Node<T>(value[i],null);
                //rear被重新赋值，继往下移动
                rear=rear.next;//指向新的尾节点
            }
        }
    }
    public boolean isEmpty(){
        //头指针创建后不再改变
        return this.head.next==null;
    }
    public T get(int i){
        Node<T> p=this.head.next;
        for(int j=0;j<i;j++){
            if(p!=null){
                //索引j与i的问题，比实际少一，j和i不能相等
                p=p.next;
            }
        }
        //i>=：第0个元素
        return (i>=0&&p!=null)?p.data:null;
    }
    public void set(int i,T x){
        Node<T> p=this.head.next;
        if(p!=null){
            for(int j=0;j<i;j++){
                p=p.next;
            }
            p.data=x;
        }
    }
    public int size(){
        int m=0;
        Node<T> p=this.head.next;
        for(;p!=null;){
            m++;
            p=p.next;
        }
        return m;
    }
    public String toString(){
        String str=this.getClass().getName()+"(";
        for(Node<T> p=this.head.next;p!=null;p=p.next){
              str+=p.data.toString()+(p.next!=null?",":"");
        }
            return str+")";
    }
    public Node<T> insert(int i,T x){
        if(x==null){
           return null;
        }
        Node<T> front=this.head;
        for(int j=0;j<i;j++){
            if(front!=null){
                 front=front.next;
            }
        }
        front.next=new Node<T>(x,front.next);
        return front.next;
    }
    public Node<T> insert(T x){
        return insert(Integer.MAX_VALUE,x);
    }
    public T remove(int i){
        Node<T> front=this.head;
        for(int j=0;j<i;j++){
            if(front.next!=null){
                front=front.next;
            }
        }
        if(i>=0&&front.next!=null){
            T x=front.next.data;
            front.next=front.next.next;
            return x;
        }
        return null;
    }
    public void clear(){
        this.head.next=null;
    }
    public Node<T> search(T key){
        if(key==null){
            return null;
        }
        Node<T> p=this.head.next;
        for(;p!=null;){
            if(p.data==key){
                return p;
            }
            p=p.next;
        }
        return null;
    }
    public T remove(T key){
        if(key==null){
            return null;
        }
        Node<T> front=this.head;
        Node<T> p;
        for(;front.next!=null;) {
            if(front.next.data==key){
                p=front.next;
                front.next=front.next.next;
                return p.data;
            }
            front=front.next;
        }
        return null;
    }

    public static void main(String[] args) {
        String[] value={"这是","一个","悲伤","的故事"};
        StringList<String> list=new StringList<>(value);
        System.out.println(list.toString());
        list.set(0,"替换");
        System.out.println(list.toString());
        String s=list.remove("替换");
        String string="超过";
        list.insert(string);
        System.out.println(list.toString());

    }
}
