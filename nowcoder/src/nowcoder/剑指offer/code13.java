package nowcoder.剑指offer;


/**
 * 二进制中1的个数
 * 
 * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 * 
 * 思路：常规思路 与运算取最后一位后右移。但是负数会死循环。左移按位与的数字，使原数不变。
 *      优化思路 一个整数减去1，再和原整数做与运算，会把该整数最右边一个1变成0
 * 
 * @date 2016年5月1日 下午2:40:48
 * @author yangengzhe
 *
 */
public class code13 {
    //常规算法，容易死循环（负数时候 因为负数右移 补位1）
    public int  NumberOf12(int n) {
        int a=0;
        
        while(n!=0){
            if((n&1) == 1) a++;
            n=n>>1;
        }
        return a;
    }
    
    //正数范围内可用 因为右移相当于除2，但是不能替换 这个效率低
    public int  NumberOf13(int n) {
        int a=0;
        while(n!=0){
            if(n%2==1)  a++;
            n=n/2;
        }
        return a;
    }
    
    //常规，移动“与”的数字 32位int形。注意 待位移比较的数字应为无符号整型，java中由于不支持无符号 所以用long
    public int  NumberOf1_1(int n) {
        long a=1;
        int count=0;
        for(int i=0;i<32;i++){
            if((n&a) == a) count++;
            a=a<<1;
        }
        return count;
    }
    //一个整数减去1，再和原整数做与运算，会把该整数最右边一个1变成0
    public int  NumberOf1_2(int n) {
        int count=0;
        while(n!=0){
            n=(n&(n-1));
            count++;
        }
        return count;
    }
}
