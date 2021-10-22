package recursion;

import java.util.Arrays;

public class MergeSort {
    public void merge(int[] array,int low,int mid,int height){
        int[] auxiliary=new int[height-low+1];
        int i=low;
        int j=mid+1;
        int k=0;
        while(i<=mid&&j<=height){
            if(array[i]<=array[j]){
                auxiliary[k++]=array[i];
            }else{
                auxiliary[k++]=array[j++];
            }
        }
        for(int x=low,y=0;x<=height;x++){
            array[x]=auxiliary[y++];
        }
    }
    public void mergeSort(int[] array,int low,int height){
        if(low<height){
            int mid=(height+low)/2;
            mergeSort(array,low,mid);
            mergeSort(array,mid+1,height);
            merge(array,low,mid,height);
        }
    }
    public static void main(String[] args) {
        Merge merge=new Merge();
        int[] array={3,2,9,5,78,36};
        merge.mergeSort(array,0,array.length-1);
        System.out.println(Arrays.toString(array));
    }
}
