package recursion;

import java.util.Arrays;

public class BinarrySearch {

    public void bubble(int[]array){
        for(int i=0;i<array.length-1;i++){
            for(int j=i-1;j>=0;j--){
                if(array[j]>array[j+1]){
                    int temp=array[j];
                    array[j]=array[j+1];
                    array[j+1]=temp;
                }
            }
        }
    }


    /**
     * 二分法查找(普通）
     *
     * @param array：需要查找的数组（有序）
     * @param x：要查找的值
     */
    public int binarry(int[] array, int x) {
        int low = 0;
        int height = array.length;
        while (low <= height) {//执行条件
             int middle = (low + height) >> 1;//右移 等同于int middle=(low+height)/2，每比较一次，middle需要改变一次
            //进行比较
            if (array[middle] == x) {//关键比较
                return middle;
                //变化，即为下一次寻找初始化
            } else if (array[middle] < x) {//根据比较结果，选择往那部分继续查找
                low = middle + 1;
            } else if (array[middle] > x) {
                height = middle - 1;
            }
        }
            return -1;//查找不到
    }

    /**
     * 递归实现二分查找
     * @param array
     * @param x
     * @param low:调用自身，实现前的初始化
     * @param height:调用自身，实现前的初始化
     * @return
     */
    public int recursionBinarry(int[]array,int x,int low,int height){
        //递归结束条件
        if(low>height){//二分查找的条件：low<=height
            return -1;
        }
        int middle=(low+height)>>1;
        if(array[middle]==x){
            return middle;
        }else if(array[middle]>x){
            recursionBinarry(array,x,low,middle-1);
        }else if(array[middle]<x){
            recursionBinarry(array,x,middle+1,height);
        }
        return -1;
    }

    public static void main(String[] args) {
        BinarrySearch bs=new BinarrySearch();
        int x=13;
        int[] array={34,23,5,4,13,565};
        bs.bubble(array);
        System.out.println(Arrays.toString(array));
//        int result=bs.binarry(array,x);
        int result= bs.recursionBinarry(array,x,0,array.length-1);
        System.out.println("结果:"+result);
    }
}
