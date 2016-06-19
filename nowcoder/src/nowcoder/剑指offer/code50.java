package nowcoder.剑指offer;


/**
 * 不用加减乘除做加法 ★★★
 * 
 * 写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
 * 
 * 思路：分为三步
 * 第一步：不进位加法。异或运算。
 * 第二步：计算进位。按位与 左移1位。
 * 第三步：相加求和。重复上两步 直到进位为0时
 * @date 2016年6月17日 下午1:20:38
 * @author yangengzhe
 *
 */
public class code50 {
    public int Add(int num1,int num2) {
        int jinwei = 1;
        int sum=0;
        while(jinwei != 0) {
            jinwei = (num1 & num2)<<1;
            sum = num1 ^ num2;
            
            num1 = sum;
            num2 = jinwei;
        }
        return sum;
    }
    
    public static void main(String args[]){
        code50 c = new code50();
       System.out.println(c.Add(1, 2));
    }
}
