package stack;

public class SeqStack<T> implements Stack<T>{
    private SeqList<T> list;
    public SeqStack(int length){
        this.list=new SeqList<>(length);
    }
    public SeqStack(){
        this(64);
    }
    @Override
    public boolean isEmpty() {
        return this.list.isEmpty();
    }

    @Override
    public void push(T x) {
        this.list.insert(x);
    }

    @Override
    public T peek() {
        return this.list.get(list.size()-1);
    }

    @Override
    public T pop() {
        return list.remove(list.size()-1);
    }
    public String toString(){
        return this.list.toString();
    }
    public String toPreviousString(){
        return this.list.toPreviousString();
    }
}
