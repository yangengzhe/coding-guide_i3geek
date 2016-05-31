package nowcoder.剑指offer;

import java.util.ArrayList;
import java.util.TreeSet;

/**
 * 最小的K个数 ★★★★
 * 
 * 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 * 
 * 思路：1. 简单排序，之后比较 时间复杂度很大 nlgn
 * 2.划分思想 (n)，类似快排，需要改变原数组。快排的优化
 * http://blog.csdn.net/shakespeare001/article/details/51280814
 * 3. 冒泡不完整的排序 (kn) 改变了数组
 * ★4.最大堆（海量数据的处理），创建一个用来存储最小k个元素的容器，每次读取一个数据 比较存储。若用堆实现 读取是O(1)但是插入 删除是O(logk) 所以时间复杂度O(nlogk)
 *  由于最大堆比较难实现，可以用TreeSet 也就是TreeMap实现的 底层用的红黑树
 * 
 * @date 2016年5月25日 下午6:26:55
 * @author yangengzhe
 *
 */
public class code31 {
    public static int partition(int arr[],int start,int end){
        int temp = arr[start];
        while(start<end){
            while(start<end && temp<=arr[end]) end--;
                arr[start] = arr[end];
            while(start<end && temp>=arr[start]) start++;
                arr[end] =arr[start];
        }
        arr[start] = temp;
        return start;
    }
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if(input.length < k || k == 0) return result;
        int start = 0;
        int end = input.length-1;
        int index = partition(input,start,end);
        while(index!= k-1){
            if(index>k-1){
                end = index-1;
                index = partition(input, start, end);
            }else{
                start = index+1;
                index = partition(input, start, end);
            }
        }
        for(int i=0;i<k;i++)
            result.add(input[i]);
        return result;
    }
    
    public static ArrayList<Integer> GetLeastNumbers_Solution3(int [] input, int k) {
        if(input == null)
            return null;
        ArrayList<Integer> list = new ArrayList<Integer>(k);
        if(k > input.length)
            return list;
        TreeSet<Integer> tree = new TreeSet<Integer>();
        for(int i = 0 ; i < input.length; i++){
            tree.add(input[i]);
        }
        int i = 0;
        for(Integer elem : tree){
            if(i >= k)
                break;
            list.add(elem);
            i++;
        }
        return list;
    }
}
