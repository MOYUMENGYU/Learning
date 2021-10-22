package binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree<T> {
    public BinaryNode<T> root;

    public BinaryTree() {
        this.root = null;
    }

    public boolean isEmpty() {
        return this.root == null;
    }

    /**
     * @param x：插入的元素 插入x元素作为根节点，原根节点作为x的左孩子节点
     */
    public void insert(T x) {
        if (x != null) {
            this.root = new BinaryNode<>(x, this.root, null);
        }
    }

    /**
     * @param p:指定插入到的节点
     * @param left：指定作为左孩子还是有孩子 ,true:作为左孩子，false:作为右孩子
     * @param x：插入x元素
     * @return 返回插入的节点
     * 指定插入的元素作为父节点的左右孩子，若原先左右孩子以存在，则将原先的左右孩子作为插入节点的左右孩子
     * 原来是左孩子，插入后还是左孩子，右孩子同理
     */
    public BinaryNode<T> insert(BinaryNode<T> p, boolean left, T x) {
        if (p == null || x == null) {
            return null;
        }
        if (left) {
            return p.left = new BinaryNode<>(x, p.left, null);
        } else {
            return p.right = new BinaryNode<>(x, null, p.right);
        }
    }

    /**
     * @param p:指定操作的父节点
     * @param left：true:操作为左节点，false:操作为右节点 因为无法约定左右孩子子树的合并规则，只能删除以一个节点为根的一棵子树
     */
    public void remove(BinaryNode<T> p, boolean left) {
        if (p != null) {
            if (left) {
                p.left = null;
            } else {
                p.right = null;
            }
        }
    }

    /**
     * 删除二叉树的所有节点，删除根节点
     */
    public void clear() {
        this.root = null;
    }

    /**
     * @param p:先根次序遍历以p为节点的子树，递归方法
     *
     */
    public void preorder(BinaryNode<T> p) {
        if (p != null) {
            System.out.print(p.data.toString() + " ");
            preorder(p.left);//按先根次序遍历p的左子树，递归调用，参数为左孩子
            preorder(p.right);//按先根次序遍历p的右子树，递归调用，参数为右孩子
        }
    }

    /**
     * 先根次序遍历二叉树
     */
    public void preorder(){
        preorder(root);
        System.out.println();
    }

    /**
     *
     * @param p:中根次序遍历以p节点为根的子树，递归方法
     */
    public void inorder(BinaryNode<T> p){
        if(p!=null){
            inorder(p.left);
            System.out.print(p.data.toString()+" ");
            inorder(p.right);
        }
    }
    public void inorder(){
        inorder(root);
        System.out.println();
    }

    /**
     *
     * @param p:后根次序遍历以p节点为根节点子树，递归方法
     */
    public void postorder(BinaryNode<T> p){
        if(p!=null){
            postorder(p.left);
            postorder(p.right);
            System.out.print(p.data.toString()+" ");
        }
    }
    public void postorder(){
        postorder(root);
        System.out.println();
    }

    /**
     * 使用队列辅助遍历从头节点开始，从队列中取出元素，输出当前元素的值，并判断左右孩子是否为空
     * 不为空则加进队列，先进先出
     * 队列使用与有明显的先后顺序，也可使用通过判断是否为空的情况来对不确定的数量进行控制
     */
    public void levelorder(){
        Queue<BinaryNode<T>> queue=new LinkedList<>();
       if(this.root!=null){
           queue.offer(this.root);
       }
       BinaryNode<T> p=null;
       while(!queue.isEmpty()){
           p=queue.poll();
           System.out.print(p.data+" ");
           if(p.left!=null){
               queue.offer(p.left);
           }
           if(p.right!=null){
               queue.offer(p.right);
           }
       }
    }
    public int size(BinaryNode<T> p){
        if(p==null){
            return 0;
        }
        return 1+size(p.left)+size(p.right);
    }
    public int size(){
        return size(this.root);
    }
    public String preorderToString(BinaryNode<T> p){
        String str="";
        if(p!=null){
            str=p+"\n";
            String ls=preorderToString(p.left);
            str+=ls;
            String rs=preorderToString(p.right);
            str+=rs;
        }
        return str;
    }
    public String toString(){
        return this.root!=null?preorderToString(root):null;
    }
    public int height(BinaryNode<T> p){
        if(p==null){
            return 0;
        }
        int lh=height(p.left);
        int rh=height(p.right);
        return (lh>=rh)?lh+1:rh+1;
    }
    public int height(){
        return height(this.root);
    }
    public int countLeaf(){
        return countLeaf(this.root);
    }
    public int countLeaf(BinaryNode<T> p){
        if(p==null){
            return 0;
        }
        int lc=countLeaf(p.left);
        int rc=countLeaf(p.right);
        return p.left==null&&p.right==null?0:lc+rc+1;
    }
//    public BinaryNode<T> search(T key){
//        return search(this.root,key);
//    }
//    public BinaryNode<T> search(BinaryNode<T> p,T key){
//        if(p!=null){
//            if(p.data==key){
//                return p;
//            }
//            search(p.left,key);
//            search(p.right,key);
//        }
//        return null;
//    }
    public BinaryNode<T> search(T key){
        Queue<BinaryNode<T>> queue=new LinkedList<>();
        if(this.root!=null){
            queue.offer(this.root);
        }
        BinaryNode<T> p=null;
        while(!queue.isEmpty()){
            p=queue.poll();
            if(p.data==key){
                return p;
            }
            if(p.left!=null){
                queue.offer(p.left);
            }
            if(p.right!=null){
                queue.offer(p.right);
            }
        }
        return null;
    }
    public int level(T key){
        return level(this.root,key,0);
    }
//    public int level(BinaryNode<T> p,T key,int arr){
//        if(p!=null){
//            if(p.data==key){
//                return arr;
//            }
//            level(p.left,key,arr+1);
//            level(p.right,key,arr+1);
//        }
//        return 0;
//    }
    public int level(BinaryNode<T> p,T key,int arr){
        if(p==null){
            return 0;
        }
        if(p.data==key){
            return arr;
        }
        int a=level(p.left,key,arr+1);
        if(a!=0){
            return a;
        }else{
            return level(p.right,key,arr+1);
        }
    }
    public void remove(T key){
        Queue<BinaryNode<T>> queue=new LinkedList<>();
        if(this.root!=null){
            queue.offer(this.root);
        }
        BinaryNode<T> p=null;
        while(!queue.isEmpty()){
            p=queue.poll();
            if(p.data==key){
                p=null;
            }else{
                if(p.left!=null){
                    queue.offer(p.left);
                }
                if(p.right!=null){
                    queue.offer(p.right);
                }
            }
        }
    }
    public static void main(String[] args) {
        BinaryTree<Integer> binaryTree=new BinaryTree<>();
        binaryTree.insert(1);
        binaryTree.insert(2);
        binaryTree.insert(3);
        binaryTree.insert(4);
        binaryTree.insert(binaryTree.search(4), false,5);
        binaryTree.insert(binaryTree.search(5), false,6);
        binaryTree.insert(binaryTree.search(3), false,7);
        System.out.println(binaryTree.toString());
        System.out.println(binaryTree.size());
        System.out.println(binaryTree.height());
        System.out.println(binaryTree.countLeaf());
    }
}