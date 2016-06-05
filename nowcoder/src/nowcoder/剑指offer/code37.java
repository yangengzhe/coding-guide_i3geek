package nowcoder.剑指offer;


/**
 * 数组中的逆序对（归并排序） ★★★★ 
 * 
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。
 * 
 * 思路：1. 普通解法O(n^2) 
 * 2. 不逐个比，遇到比该数小的，直接取该数+1，遇到相等的 直接等于该数 时间复杂度O(n^2)
 * 3. 归并排序 O(nlogn)
 * @date 2016年6月3日 下午4:32:05
 * @author yangengzhe
 *
 */
public class code37 {
    
    //O(n^2)
    public int InversePairs(int [] array) {
        if(array.length < 2 || array==null) return 0;
        int count[] =new int[array.length];
        for(int i=array.length-2;i>=0;i--){
            int j=i+1;
            int temp = 0;
            while(j<array.length){
                if(array[i]>array[j] && temp<array[j]){
                    count[i] += count[j]+1;
                    temp = array[j];
                }
                if(array[i] == array[j])
                    count[i] +=count[j];
                j++;
            }
        }
        int result = 0;
        for(int i=0;i<count.length;i++){
            result+=count[i];
        }
        return result;
    }
    
    public static void main(String args[]){
        code37 c = new code37();
//        int array[] = {1,2,3,4,7,6,5};
        int array[] = {1,2,1,2,1};
        System.out.println(c.InversePairs(array));
    }
}
