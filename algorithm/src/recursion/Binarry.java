package recursion;

import java.util.Arrays;

public class Binarry {
    public int binarry(int[] array,int x){
        int low=0;
        int height=array.length-1;
        int mid=0;
        while(low<=height){
            mid=(height+low)/2;
            if(array[mid]==x){
                return mid;
            }else if(array[mid]<x){
                low=mid+1;
            }else if(array[mid]>x){
                height=mid-1;
            }
        }
        return -1;
    }
    public int rercusionBinarray(int[] array,int low,int height,int value){
        if(low>height){
            return -1;
        }
        int mid=(height+low)/2;
        if(array[mid]==value){
            return mid;
        }else if(array[mid]<value){
            rercusionBinarray(array,mid+1,height,value);
        }else if(array[mid]>value){
            rercusionBinarray(array,low,mid-1,value);
        }
        return -1;
    }

    public static void main(String[] args) {
        Binarry binarry=new Binarry();
//        int[] array={5,2,7,89,22};
        int[] array={3,5,8,9};
        int x=3;
//        int result=binarry.binarry(array,x);
        int result=binarry.rercusionBinarray(array,0,array.length-1,x);
        System.out.println(result);


    }
}
