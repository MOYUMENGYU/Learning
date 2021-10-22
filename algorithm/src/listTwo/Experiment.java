package listTwo;

public class Experiment {
    public static SinglyList<Integer> mergeList(SinglyList<Integer> listFirst,SinglyList<Integer> listSecond){
        sort(listFirst);
        Node<Integer> frontFirst =null;
        Node<Integer> frontSecond=null;
        int size=listSecond.size();
        for(int i=0;i<size;i++){
            frontFirst=listFirst.head;
            frontSecond=listSecond.head;
            while(frontFirst.next!=null){
                if(((Integer)frontSecond.next.data).compareTo((Integer) frontFirst.next.data)>=0){
                    Node<Integer> temp=frontSecond.next;
                    frontSecond.next=frontSecond.next.next;
                    temp.next=frontFirst.next;
                    frontFirst.next=temp;
                    break;//插完之不能再往后
                }else if(frontFirst.next.next==null){
                    Node<Integer> temp=frontSecond.next;
                    frontSecond.next=frontSecond.next.next;
                    temp.next=null;
                    frontFirst.next.next=temp;
                    break;//插完之后不能再往后
                }
                frontFirst=frontFirst.next;
            }
        }
        return listFirst;
    }
    public static void sort(SinglyList<Integer> singlyList){
        Node<Integer> front=singlyList.head;
        Node<Integer> p=front.next;
        for(int i=0;i<singlyList.size()-1;i++){
            front=singlyList.head;
            p=front.next;
            while (front.next.next!= null) {//front p 使用判空的情况
                if (((Integer)front.next.data).compareTo((Integer) p.next.data)<0) {
                    Node<Integer> temp=p.next;
                    p.next=p.next.next;//先最外层,后面不再需要的
                    temp.next=front.next;
                    front.next=temp;
                }
                front=front.next;
                p=front.next;//步调要保持一致
            }
        }
    }
    public static void main(String[] args) throws Exception {
        Integer[] value={3,5,19,4,8};
        Integer[] values={5,10,2,7,3};
        SinglyList<Integer> singlyList=new SinglyList<Integer>(value);
        SinglyList<Integer> sing=new SinglyList<Integer>(values);
        Experiment exp=new Experiment();
        exp.mergeList(singlyList,sing);
        exp.sort(singlyList);
        System.out.println(singlyList.toString());
        System.out.println(singlyList.size());
    }
}
