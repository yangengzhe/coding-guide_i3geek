package nowcoder.剑指offer;

import java.util.Vector;

/**
 * 变态跳台阶 ★★★★★
 * 
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 * 
 * 思路：方法一：动态规划 同上，N级台阶需要： f(n) = f(n-1)+f(n-2)+..+f(n- (n-1) )+f(n-n) 同时注意存储已经算好的数字 ;f(1) =1; f(2) = 2;f(3) = f(0)+f(1)+f(2)   f(0)表示一次跳的方法
 * 方法二：根据推倒可得 f(n) = 2 ^ (n-1)   即：f(n) = 2*f(n-1)
 * 
 * @date 2016年4月27日 下午6:54:21
 * @author yangengzhe
 *
 */
public class code11 {
    Vector<Integer> vectors = new Vector<Integer>();    
  //公式
    public int JumpFloorII(int target) {
        int result = 1;
        while(target-->1)
            result = result*2;
        return result;
    }
  //递归
    public int JumpFloorII2(int target) {
        int sum = 0;
        if(vectors.size()==0) vectors.add(0,1);
        if(vectors.size()>target) return vectors.get(target);
        for(int i=0;i<target;i++)
            sum += JumpFloorII(i);
        vectors.add(target, sum);
        return sum;
    }
    
    public static void main(String args[]){
        code11 c = new code11();
        System.out.println(c.JumpFloorII(3));
        
    }
}
