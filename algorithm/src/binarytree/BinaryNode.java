package binarytree;

public class BinaryNode<T>{
    public T data;
    public BinaryNode<T> left;
    public BinaryNode<T> right;

    public BinaryNode(T data,BinaryNode<T> left,BinaryNode<T> right){
        this.data=data;
        this.left=left;
        this.right=right;
    }
    public BinaryNode(T data){
        this(data,null,null);
    }
    @Override
    public String toString() {
        return "BinaryNode{" +
                "data=" + data +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
    public boolean isLeaf(){
        return this.left==null&&this.right==null?true:false;
    }
}
