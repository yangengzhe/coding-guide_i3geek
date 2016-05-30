package nowcoder.剑指offer;


/**
 * 连续子数组的最大和 ★★★
 * 
 * 思路：1.常规遍历 O(n^2)
 * 2.规律（动态规划）：正数只管加，遇到负数时候 最大和会变小，所以考虑是否要舍弃之前的和。
 *          因此，用临时变量保存当前和，遇到正数：和只会越来越大，所以遇到正数只管加；
 *          遇到负数：先比较记录原先的最大和，再加，加完后需要额外判断 加完的负数是否比本身还小，若小则舍弃，保留自身。
 * 
 * @date 2016年5月30日 下午1:45:13
 * @author yangengzhe
 *
 */
public class code32 {
    public int FindGreatestSumOfSubArray(int[] array) {
        if(array.length <1) return 0;
        if(array.length == 1) return array[0];
        int sum = Integer.MIN_VALUE;
        int temp = array[0];
        for(int i=1;i<array.length;i++){
            if(array[i]<0)
                sum = sum>temp?sum:temp;
            temp = temp+array[i] >array[i]?temp+array[i]:array[i];
        }
        sum = sum>temp?sum:temp;
        return sum;
    }
    
    public static void main(String args[]){
//        int[] array = {6,-3,-2,7,-15,1,2,2};
//        int[] array = {-2,-8,-1,-5,-9};
//        int[] array = {1,-2,3,10,-4,7,2,-5};
        int[] array = {2,8,1,5,9};
        code32 c =new code32();
        System.out.println(c.FindGreatestSumOfSubArray(array));
    }
}
