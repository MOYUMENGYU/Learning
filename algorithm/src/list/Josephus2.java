package list;

public class Josephus2 {
    public Josephus2(int n,int start,int  distance){
        if(n<=0||start<0||start>n||distance<=0||distance>=n){
        }
        StringList<String> list=new StringList<>();
        for(int i=n-1;i>=0;i--){
            list.insert(0,(char)('A')+i+"");
        }
        System.out.println(list.toString());
        Node<String> front=list.head;//头指针
        for(int i=0;i<start;i++){
            if(front!=null){
                front=front.next;
            }
        }
        while(n>1){
            for(int i=1;i<distance;i++){
                front=front.next;
                if(front==null){    //实现循环
                    front=list.head.next;
                }
            }
            if(front.next==null){
                front=list.head;
            }
            System.out.println("删除"+front.next.data.toString()+",");
            front.next=front.next.next;//删除front的后续节点，包括头删除，中间删除，尾删除
            n--;
            System.out.println(list.toString());
        }
        System.out.println(list.get(0).toString());
    }
}
