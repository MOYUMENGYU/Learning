package listTwo;

public class CircularSinglyList<T> {
    public Node<T> head;//头节点，哨兵，不会改变
    public CircularSinglyList(){
        this.head=new Node<T>();//创建头节点，data,next都为空
        head.next=this.head;//与单链表的区别
    }
    public CircularSinglyList(T[] values){
        this();//this和super引用，必须在第一行
        Node<T> rear=this.head;//因为哨兵头节点不改变，增加一个辅助头节点，可以改变，代替头节点
        for(int i=0;i<values.length;i++){
            if(values[i]!=null){
                rear.next=new Node<T>(values[i],this.head);//第一次rear.next=head.next,rear.next:使哨兵，头节点不改变,null：未插入
                rear=rear.next;//重新赋值，rear真正的作用的地方，移动
                rear.next=this.head;
            }
        }
    }
    //判空
    public boolean isEmpty(){
        return this.head.next==null;//第零个元素;this.head.next,head为哨兵
    }

    public T get(int x){
        if(x>=0){//判断x是否非法
            //指针，用于链表上移动，最开始指向this.head.next,索引为零的第一个元素
            Node<T> p=this.head.next;//此时已经在第一个元素了，索引为零
            if(x==0){
                return p.data;
            }
            for(int i=0;i<x;i++){//为什么i<=x;当执行循环时，p.next会指向下一个,不必到达到索引指的位置
                if(p!=this.head){//防止越界，x超出最大索引
                     p=p.next;//不断重新赋值，直到循环结束，链表特点，要查找一个元素必须从头开始
                }
            }
            //当循环结束时p已经定位到了指定索引的节点
            if(p!=this.head){
                return p.data;
            }else{
                return null;
            }
        }else{
            return null;
        }
    }
    //获取值，重写
    public T getTwo(int x){
        if(x>=0){
            Node<T> p=this.head;
            for(int i=0;i<=x;i++){
                p=p.next;//第一次为索引为0的节点，
            }
            if(p!=this.head){
                return p.data;
            }else{
                return null;
            }
        }else{
            return null;
        }
    }
    public T getThree(int x){
        Node<T> p=this.head.next;
        for(int i=0;i<x&&p!=this.head;i++){
            p=p.next;
        }
        return (x>=0&&p!=this.head)?p.data:null;
    }
    public void set(int i,T x){
        if(i>=0){
            Node<T> p=this.head.next;
            for(int j=0;j<i;j++){//j<i：因为p一开始就指向了索引为零的节点，如果x为零则不执行循环，不再需要额外判断x=0
                if(p!=this.head){
                     p=p.next;//移动
                }
            }
            if(p!=this.head){ //
                p.data=x;
            }
        }
    }
    public void setTwo(int i,T x){
        if(i>=0){
            Node<T> p=this.head;//不是索引0的节点了
            for(int j=0;j<=i;j++){//从索引零开始
                if(p!=this.head){
                    p=p.next;
                }
            }
            if(p!=this.head){
                p.data=x;
            }
        }
    }
    public int size(){
        Node<T> p=this.head.next;
        int m=0;//从哨兵开始
        for(;p!=this.head;){//直到最后为空
            m++;
            p=p.next;
        }
        return m;
    }
    public int sizeTwo(){
        Node<T> p=this.head;
        int m=0;
        for(;p.next!=this.head;){//最后一个节点p.next=null
            m++;
            p=p.next;
        }
        return m;
    }
    public String toString(){
        String str=this.getClass().getName()+"(";
        for(Node<T> p=this.head.next;p!=this.head;p=p.next){
            str+=p.data.toString()+(p.next!=this.head?",":"");
        }
        return str+")";
    }
    public Node<T> insert(int i,T x){
        if(x.equals("")){
            return null;
        }
        if(i>=0){
            Node<T> front=this.head;//front为前一个，可为头节点
            //寻找插入的前一个节点
            for(int j=0;j<i;j++){//this.head和j<i:定位到插入位置的前一个
                if(front.next!=this.head){
                    front=front.next;//移动
                }
            }
            //创建节点是已经要指向下一个节点的功能
            front.next=new Node<T>(x,front.next);//括号中的front.next为原来的，左边的为要插入的节点，要更新的地方
            return front.next;
        }else{
            return null;
        }
    }
    public Node<T> insert(T x){
        return insert(Integer.MAX_VALUE,x);
    }
    public Node<T> insertTwo(T x){
        if(x!=null){
            Node<T> front=this.head;
            for(;front.next!=this.head;){//定位到最后一个,即尾插入的前一个
                front=front.next;
            }
            System.out.println(front);
            front.next=new Node<T>(x,this.head);
            return front.next;
        }else{
            return null;
        }
    }
    public T remove(int i){
        if(i>=0){
            Node<T> front=this.head;
            if(i==0){
                T x= (T) front.next.data;
                front.next=front.next.next;
                return x;
            }
            for(int j=0;j<i&&front!=this.head;j++){//前一个节点,
                if(front.next!=this.head){//处理当front为最后一个时的情况
                     front=front.next;
                }else{
                    return null;
                }
            }
            T y=(T)front.next.data;
            front.next=front.next.next;
            return y;
        }else{
            return null;
        }
    }

    public T removeTwo(int i){
        Node<T> front=this.head;
        for(int j=0;j<i&&front.next!=this.head;j++){
            front=front.next;
        }
        if(i>=0&&front.next!=this.head){
            T x=(T)front.next.data;
            front.next=front.next.next;
            return x;
        }
        return null;
    }
    public void clear(){
        this.head.next=this.head;
    }
    public Node<T> search(T key){
        if(key==null){
            return null;
        }
        Node<T> p=this.head.next;
        for(;p!=this.head;){//从头到尾
            if(p.data==key){
                return p;
            }
            p=p.next;//移动
        }
        return null;
    }
    public T remove(T key){
        if(key==null){
            return null;
        }
        Node<T> front=this.head;//前一个指针
        for(;front!=this.head;){//循环移动到最后
            if(front.next!=this.head){//最后一个节点，处理当front指向最后一个时，front.next为空
                if(front.next.data==key){
                    T x=(T)front.next.data;//需要返回值，取值
                    front.next=front.next.next;//覆盖，删除
                    return x;
                }
                front=front.next;//移动
            }else{
                return null;
            }
        }
        return null;
    }
    //浅拷贝,指向的是同一个链表
    public CircularSinglyList(CircularSinglyList<T> list){
        this.head=list.head;
    }
    //深拷贝
    public CircularSinglyList<T> copy(){
        CircularSinglyList<T> newList=new CircularSinglyList<>();//深拷贝，一个新的链表，重新创建一个新的链表
        Node<T> p=this.head.next;//原链表，从第一个元素开始遍历（索引为零）
        Node<T> item=newList.head;//头节点不能动，需要一个指针来指向
        for(;p!=this.head;){//遍历完原链表
            item.next=new Node<>(p.data,this.head);//尾插入
            item=item.next;//复制链表往下移
            p=p.next;//原链表往下移
        }
        return newList;
    }
    //集合并,在this后续list的所有节点,浅拷贝：当data改掉之后，连接后的链表会改变,删除不会
    public void concat(CircularSinglyList<T> list){
        Node<T> p=this.head;
        for(;p.next!=this.head;){//this.head和p.next移动到最后面
           p=p.next;//移动
        }
        p.next=list.head.next;
    }
    public void addAll(CircularSinglyList<T> list){
        CircularSinglyList<T> newList=list.copy();
        concat(newList);
    }

    public CircularSinglyList<T> union(CircularSinglyList<T> list){
        CircularSinglyList<T> newList=list.copy();//深拷贝list
        CircularSinglyList<T> newThis=this.copy();//深拷贝list
        newThis.concat(newThis);
        return newThis;//返回一个全新的链表
    }

    public static void main(String[] args) {
        String[] value={"长春","理工","大学"};
        CircularSinglyList circularSinglyList=new CircularSinglyList(value);
        System.out.println(circularSinglyList);
    }
}
