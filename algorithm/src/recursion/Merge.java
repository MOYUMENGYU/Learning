package recursion;

import java.util.Arrays;

public class Merge {
    public void merge(int[] array,int low,int mid,int height){
        //辅助数据
        int[] auxiliary=new int[height-low+1];
        //指针
        int i=low;//指向前一部分的要比较的值
        int j=mid+1;//指向后一部分的比较的值
        int k=0;//要填入辅助数组的位置的值的指针
        //比较，因为不知道什么时候那个子序列结束，所以要使用which,条件为两个子序列都还有元素
        while(i<=mid&&j<=height){
            if(array[i]<=array[j]){
                auxiliary[k++]=array[i++];
            }else if(array[i]>array[j]){
                auxiliary[k++]=array[j++];
            }
        }
        //如果前一部分没有存放完,则直接将后续的值存入辅助数组
        while(i<=mid){
            auxiliary[k++]=array[i++];
        }
        //如果后一部分的没有存放玩，则将没存入的存入
        while(j<=height){
            auxiliary[k++]=array[j++];
        }
        //将辅助数组复制到原数组，原数组从low开始，终止于height,辅助数组从0开始
        for(int x=low,y=0;x<=height;x++){
            array[x]=auxiliary[y++];
        }
    }
    public void mergeSort(int[] array,int low,int height){
        //递归结束条件
        if(low<height){
            //将数组分为两部分
            int mid=(low+height)/2;
            //前一部分子序列
            mergeSort(array,low,mid);
            //后一部分子序列
            mergeSort(array,mid+1,height);
            //合并排好序的两个子序列
            merge(array,low,mid,height);
        }
    }

    public static void main(String[] args) {
        Merge merge=new Merge();
        int[] array={3,1,56,2,6,9};
        merge.mergeSort(array,0,array.length-1);
        System.out.println(Arrays.toString(array));
    }
}
