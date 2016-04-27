package nowcoder.剑指offer;


/**
 * 斐波那契数列 ★★
 * 
 * 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项。
 * 
 * 思路：方法一：递归 效率低，空间利用大，时间长。方案二：叠加遍历O(n)
 * @date 2016年4月27日 下午6:29:07
 * @author yangengzhe
 *
 */
public class code9 {
    //叠加遍历
    public int Fibonacci(int n) {
        if(n<2) return n;
        int a=0,b=1,c=1;
        while(n>1){
            c = a+b;
            a=b;
            b=c;
            n--;
        }
        return c;
    }
  //递归
    public int Fibonacci2(int n) {
        if(n<2) return n;
        else return Fibonacci(n-1)+Fibonacci(n-2);
    }
}
