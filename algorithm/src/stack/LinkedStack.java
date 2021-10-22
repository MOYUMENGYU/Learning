package stack;

import listTwo.SinglyList;

public class LinkedStack<T> implements Stack<T> {
    private SinglyList<T> singlyList;

    public LinkedStack() {
        this.singlyList = new SinglyList<>();
    }

    @Override
    public boolean isEmpty() {
        return this.singlyList.isEmpty();
    }

    @Override
    public void push(T x) {
        this.singlyList.insert(0, x);

    }

    @Override
    public T peek() {
        return this.singlyList.get(0);
    }

    @Override
    public T pop() {
        return this.singlyList.remove(0);
    }

    public String toString() {
        return this.singlyList.toString();
    }
}
