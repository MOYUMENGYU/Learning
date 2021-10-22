package listTwo;

import java.util.ArrayList;
import java.util.Objects;

public class SinglyList<T> {
    public Node<T> head;//头节点，哨兵，不会改变
    public SinglyList(){
        this.head=new Node<T>();//创建头节点，data,next都为空
    }
    public SinglyList(T[] values){
        this();//this和super引用，必须在第一行
        Node<T> rear=this.head;//因为哨兵头节点不改变，增加一个辅助头节点，可以改变，代替头节点
        for(int i=0;i<values.length;i++){
            if(values[i]!=null){
                rear.next=new Node<T>(values[i],null);//第一次rear.next=head.next,rear.next:使哨兵，头节点不改变,null：未插入
                rear=rear.next;//重新赋值，rear真正的作用的地方，移动
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
                if(p!=null){//防止越界，x超出最大索引
                     p=p.next;//不断重新赋值，直到循环结束，链表特点，要查找一个元素必须从头开始
                }
            }
            //当循环结束时p已经定位到了指定索引的节点
            if(p!=null){
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
            if(p!=null){
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
        for(int i=0;i<x&&p!=null;i++){
            p=p.next;
        }
        return (x>=0&&p!=null)?p.data:null;
    }
    public void set(int i,T x) throws Exception {
        if(i>=0){
            Node<T> p=this.head.next;
            for(int j=0;j<i;j++){//j<i：因为p一开始就指向了索引为零的节点，如果x为零则不执行循环，不再需要额外判断x=0
                if(p!=null){
                     p=p.next;//移动
                }
            }
            if(p!=null){ //
                p.data=x;
            }
        }
    }
    public void setTwo(int i,T x){
        if(i>=0){
            Node<T> p=this.head;//不是索引0的节点了
            for(int j=0;j<=i;j++){//从索引零开始
                if(p!=null){
                    p=p.next;
                }
            }
            if(p!=null){
                p.data=x;
            }
        }
    }
    public int size(){
        Node<T> p=this.head.next;
        int m=0;//从哨兵开始
        for(;p!=null;){//直到最后为空
            m++;
            p=p.next;
        }
        return m;
    }
    public int sizeTwo(){
        Node<T> p=this.head;
        int m=0;
        for(;p.next!=null;){//最后一个节点p.next=null
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
        if(x.equals("")){
            return null;
        }
        if(i>=0){
            Node<T> front=this.head;//front为前一个，可为头节点
            //寻找插入的前一个节点
            for(int j=0;j<i;j++){//this.head和j<i:定位到插入位置的前一个
                if(front.next!=null){
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
            for(;front.next!=null;){//定位到最后一个,即尾插入的前一个
                front=front.next;
            }
            System.out.println(front);
            front.next=new Node<T>(x,null);
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
            for(int j=0;j<i&&front!=null;j++){//前一个节点,
                if(front.next!=null){//处理当front为最后一个时的情况
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
        for(int j=0;j<i&&front.next!=null;j++){
            front=front.next;
        }
        if(i>=0&&front.next!=null){
            T x=(T)front.next.data;
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
        for(;p!=null;){//从头到尾
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
        for(;front!=null;){//循环移动到最后
            if(front.next!=null){//最后一个节点，处理当front指向最后一个时，front.next为空
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
//    public SinglyList(SinglyList<T> list){
//        this.head=list.head;
//    }
    //深拷贝
    public SinglyList(SinglyList<T> list){
        this();
        Node<T> p=this.head;
        Node<T> item=list.head.next;
        for(;item!=null;){
            p.next=new Node<>(item.data,null);
            item=item.next;
            p=p.next;
        }
    }
    //集合并,在this后续list的所有节点,浅拷贝：当data改掉之后，连接后的链表会改变,删除不会
    public void concat(SinglyList<T> list) throws Exception {
        Node<T> p=this.head;
        for(;p.next!=null;){//this.head和p.next移动到最后面
           p=p.next;//移动
        }
        p.next=list.head.next;
    }
    public void addAll(SinglyList<T> list){
        SinglyList<T> newList=new SinglyList<>(list);
//        concat(newList);
    }
    public SinglyList<T> union(SinglyList<T> list) throws Exception {
        SinglyList<T> newList=new SinglyList<>(this);//深拷贝list
        SinglyList<T> newThis=new SinglyList<>(list);//深拷贝list
        newList.concat(newThis);
        return newThis;//返回一个全新的链表
    }
    public void reverseOne(){
        SinglyList<T> singlyList=new SinglyList<T>();
        Node reverseNode=singlyList.head;
        for(int i=this.size()-1;i>=0;i--){
            reverseNode.next=new Node<T>(this.get(i),null);
            reverseNode=reverseNode.next;
        }
        this.head=singlyList.head;
    }
    public void reverse(){
        Node<T> p=this.head.next;//指向第一个节点
        Node<T> front=null;
        Node<T> succ=null;//用于保存，因为变换过程中会丢失
        for(;p!=null;){
            succ=p.next;//先保存
            p.next=front;//逆序
            front=p;//移动
            p=succ;//移动
        }
        this.head.next=front;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if(o instanceof SinglyList<?>){
            SinglyList<?> that = (SinglyList<?>) o;
            Node<?> p=this.head.next;
            Node<?> op=((SinglyList<?>) o).head.next;
            if(this.size()==((SinglyList<?>) o).size()){
                while(p!=null&&p.data==op.data){
                    p=p.next;
                    op=op.next;
                }
            }else{
                return false;
            }
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(head);
    }

    public static void main(String[] args) {
        Integer[] value={3,7,2,7,9};
        SinglyList<Integer> s1=new SinglyList<>(value);
        System.out.println(s1.toString());
        SinglyList<Integer> s2=new SinglyList<>(s1);
        System.out.println(s2.toString());
    }
}
