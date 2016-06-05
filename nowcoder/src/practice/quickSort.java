package practice;


public class quickSort {
    public static void main(String args[]){
        int[] arr = {1,4,2,5};
        qsort(arr, 0, arr.length-1);
        for (int i : arr) {
            System.out.println(i);
        }
    }
    private static void qsort(int[] arr, int low, int high){
        if (low < high){
            int pivot=partition(arr, low, high);        //将数组分为两部分
            qsort(arr, low, pivot-1);                   //递归排序左子数组
            qsort(arr, pivot+1, high);                  //递归排序右子数组
        }
    }
    public static int partition(int arr[],int start,int end){
        int pivot = arr[start];
        while(start<end){
            while(start<end && arr[end]>=pivot) end--;
            arr[start] = arr[end];
            while(start<end && arr[start]<=pivot) start++;
            arr[end] = arr[start];
            
        }
         arr[start]=pivot;
        return start;
    }
}
