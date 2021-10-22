package array;

import java.util.Arrays;

public class Algorithm {
    /**
     * 冒泡排序O(N^2)
     * @param array
     */
    public void bubble(int[] array) {
        if (array == null) {
            return;
        }
        //整体次数,数组长度-1
        for (int i = array.length - 1; i > 0; i--) {
            //每一次的排序次数:依次递减
            for (int j = 0; j < i; j++) {
                //交换
                if (array[j] > array[j + 1]) {
                    swap(array,j,j+1);
                }
            }

        }
    }

    /**
     * 选择排序O(N^2)
     */
    public void select(int[] array){
        if(array==null){
            return;
        }
        //整体次数，先找到最小，即第一个数
        for(int i=0;i<array.length-1;i++){
            int minIndex=i;
            for(int j=i+1;j<array.length;j++){
                minIndex=array[minIndex]>array[j]?j:minIndex;
            }
            swap(array,i,minIndex);
        }
    }
    /**
     * 插入排序：换，换不动了停，插入也不能一步到位，只能一个一个往前比较，符合则插入，一步一步往前插入最好O(N):与数据状况有关系 最坏O(N^2)
     * 一律按最差的算O(N^2)
     */
    public void insertIndex(int[] array){
        //第一次就需要两个数进行比较，后面的数与前一个比较，倒回来比较,次数为数组元素减一
        //考察该位置，当前这个数，往前比较是否插入
        for(int i=1;i<array.length;i++){
            //前面的数
            for(int j=i-1;j>=0;j--){
                if(array[j]>array[j+1]){
                    swap(array,j,j+1);
                }
            }
        }

    }
    /**
     * 归并排序：时间复杂度：O(N*logN),空间复杂度：O(N)
     *
     */
    public void merge(int[] arr){
        if(arr==null){
            return;
        }
    }
    public void sortProccess(int[] arr,int l,int r){
        if(l==r){
            return ;
        }
        int mid=(r+l)/2;
        sortProccess(arr,l,mid);
        sortProccess(arr,mid+1,r);
        merge(arr,l,mid,r);
    }
    public void merge(int[] arr,int l,int mid,int r){
        int[] help=new int[r-l+1];
        int i=0;
        int p1=l;
        int p2=mid+1;
        while(p1<=mid&&p2<=r){
            help[i++]=arr[p1]<arr[p2]?arr[p1++]:arr[p2++];
        }
        while(p1<=mid){
            help[i++]=arr[p1++];
        }
        while(p2<=r){
            help[i++]=arr[p2++];
        }
        for(i=0;i<help.length;i++){
            arr[l+i]=help[i];
        }
    }






    /**
     * 交换数组元素
     */
    public void swap(int[]array,int i,int j){
        int temp=array[i];
        array[i]=array[j];
        array[j]=temp;
    }

    /**
     * 对数器：
     * 1、随机样本
     * 2、绝对正确的方法，好些，不用考虑是否复杂度
     */
    /**
     *
     * 样本
     * @param size：样本大小范围
     * @param value：样本值范围
     * @return
     */
    public int[] randomArray(int size,int value){
        /**
         * Math.random():[0,1]double类型
         * 生长[0,size]整数
         * 生成0-value的数：必须（value+1）*Math.random()
         */
        int[] array=new int[(int)((size+1)*Math.random())];
        for(int i=0;i<array.length;i++){
            array[i]=(int)((value+1)*Math.random())-(int)(value*Math.random());
        }
        return array;
    }

    /**
     * 正确的方法
     * @param array
     */
    public void rightMathod(int[]array){
        Arrays.sort(array);
    }
    public int[] copyArray(int[]array){
        if(array==null){
            return null;
        }
        int[]res=new int[array.length];
        for(int i=0;i<res.length;i++){
            res[i]=array[i];
        }
        return res;
    }

    /**
     * 判断是否相等
     */
    public boolean isEqual(int[] arr1,int[]arr2){
        if((arr1==null&&arr2!=null)||(arr1!=null&&arr2==null)){
            return false;
        }
        if(arr1==null&&arr2==null){
            return true;
        }
        if(arr1.length!=arr2.length){
            return false;
        }
        for(int i=0;i<arr1.length;i++){
            if(arr1[i]!=arr2[i]){
                return false;
            }
        }
        return true;
    }
    public void printArray(int[] array){
        System.out.println(Arrays.toString(array));
    }


    public static void main(String[] args) {
        Algorithm alg=new Algorithm();
        int[] array=new int[]{6,4,8,10,3,5,7,9};
//        alg.bubble(array);
//        alg.select(array);
        alg.insertIndex(array);
        System.out.println(Arrays.toString(array));
        int testTime=500000;
        int size=10;
        int value=100;
        boolean succeed=true;
        for(int i=0;i<testTime;i++){
            //样本数组
            int[] arr1= alg.randomArray(size,value);
            int[] arr2=alg.copyArray(arr1);
            int[] arr3=alg.copyArray(arr1);
//            alg.bubble(arr1);
            alg.select(arr1);
            alg.rightMathod(arr2);
            if(!alg.isEqual(arr1,arr2)){
                succeed=false;
                alg.printArray(arr3);
                break;
            }
        }
        System.out.println(succeed?"nice":"fuck");
        int[] arr=alg.randomArray(size,value);
        alg.select(arr);
        alg.printArray(arr);
    }
}
