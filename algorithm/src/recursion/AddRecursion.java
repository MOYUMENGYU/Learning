package recursion;

/**
 * 1.一个问题的解可以分为几个子问题的解的和
 * 子问题就是数据规模更小的问题，
 * 2.子问题除了数据规模不同，求解思路完全一样
 * 3.存在递归终止条件
 * 最关键：写递归公式，找到终止条件
 */
public class AddRecursion {
    public static int add(int n){
        if(n==1){
            return 1;
        }
        return add(n-1)+1;
    }

    public static  int f(int n){
        if(n==1){
            return 1;
        }
        if(n==2){
            return 2;
        }
        return f(n-1)+f(n-2);
    }
    public static void main(String[] args) {
        int sum=add(4);
        System.out.println(sum);
        int x=f(7);
        System.out.println(x);
    }
}
