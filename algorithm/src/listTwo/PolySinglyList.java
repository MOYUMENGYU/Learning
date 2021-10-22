package listTwo;

public class PolySinglyList<T extends Comparable<? super T>&Addible<? super T>> extends SortedSinglyList{
    public PolySinglyList(){
        super();
    }
    public PolySinglyList(boolean asc){
        super(asc);
    }
    public PolySinglyList(T[] terms,boolean asc){
        super(terms,asc);
    }
    public PolySinglyList(PolySinglyList<T> list){
        super(list);
    }
    public void addAll(PolySinglyList<T> list){
        Node<T> p=this.head.next;
        Node<T> q=list.head.next;
        while(q!=null){
            while(p!=null){
                int i=p.data.compareTo(q.data);
                if(i==0){
                    p.data.add(q.data);
                    if(p.data.removable()){
                        this.remove(p.data);
                    }
                    break;
                }else if(i!=0&&p.next==null){
                    this.insert(q.data);
                    break;
                }
                p=p.next;
            }
            q=q.next;
        }
    }
}
