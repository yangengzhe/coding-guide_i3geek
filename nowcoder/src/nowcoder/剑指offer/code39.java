package nowcoder.剑指offer;


/**
 * 数字在排序数组中出现的次数 ★★
 * 
 * 统计一个数字在排序数组中出现的次数。
 * 
 * 思路：普通的遍历时间复杂度O(n) 用二分查找 时间复杂度O(logN) 分别找到第一次出现和最后一次出现的位置即可
 * 
 * @date 2016年4月23日 下午5:30:57
 * @author yangengzhe
 *
 */
public class code38 {
    public int findFirst(int[] array,int k,int start,int end){
        if(start<0 || start>end) return -1;
        int mid = (start+end)/2;
        
        if(array[mid] < k){
            return findFirst(array, k, mid+1, end);
        }
        else if(array[mid]>k){
            return findFirst(array, k, start, mid-1);
        }
        else if(mid == 0 || array[mid-1] != k){
                return mid;
        }else{
            return findFirst(array, k, start, mid-1);
        }
    }
    public int findLast(int[] array,int k,int start,int end){
        if(start<0 || start>end) return -1;
        int mid = (start+end)/2;
        
        if(array[mid] < k){
            return findLast(array, k, mid+1, end);
        }
        else if(array[mid]>k){
            return findLast(array, k, start, mid-1);
        }
        else if(mid == end || array[mid+1] != k){
                return mid;
        }else{
            return findLast(array, k, mid+1, end);
        }
    }
    public int GetNumberOfK(int [] array , int k) {
        int first = findFirst(array,k,0,array.length-1);
        int last = findLast(array,k,0,array.length-1);
        if(first<0)
            return 0;
        return last-first+1;
    }
}
