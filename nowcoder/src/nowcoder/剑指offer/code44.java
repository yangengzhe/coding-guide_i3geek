package nowcoder.剑指offer;

import java.util.ArrayList;

/**
 * 和为S的两个数字 ★★★
 * 
 * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。 
 * 
 * 思路：前后一个指针，若和小于目标 则前指针右移；若和大于目标 则后指针左移
 * 
 * @date 2016年6月12日 下午7:37:12
 * @author yangengzhe
 *
 */
public class code44 {
    public ArrayList<Integer> FindNumbersWithSum(int [] array,int sum) {
        int small =0,big = array.length-1;
        ArrayList<Integer> result = new ArrayList<Integer>();
        while(small<big){
            if(array[small]+array[big] > sum){
                big--;
            }else if(array[small]+array[big] < sum){
                small++;
            }else{
                result.add(array[small]);
                result.add(array[big]);
                return result;
           }
        }
        return result;
    }
    
    public static void main(String args[]){
        code44 c = new code44();
        int[] array = {1,2,4,7,11,15};
        ArrayList<Integer> r =c.FindNumbersWithSum(array, 15);
        System.out.println(r.get(0) +" "+r.get(1));
    }
}
