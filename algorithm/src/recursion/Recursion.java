package recursion;

public class Recursion {
    /**
     *
     * @param arr:寻找数组中的最大值
     * @param l：左边界
     * @param r：有边界
     * @return
     */
    public int getMax(int[] arr,int l,int r){
        if(r==l){
            return arr[l];
        }
        //主要
        int mid=(l+r)/2;
        int maxLeft=getMax(arr,l,mid);
        int maxRight=getMax(arr,mid+1,r);
        return Math.max(maxLeft,maxRight);
    }

    public static void main(String[] args) {
        Recursion recursion=new Recursion();
        int[] arr={4,7,8,10,4,9};
        System.out.println(recursion.getMax(arr,0,arr.length-1));
    }
}
