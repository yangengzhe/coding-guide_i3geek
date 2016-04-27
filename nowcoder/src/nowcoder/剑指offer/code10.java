package nowcoder.剑指offer;


/**
 * 跳台阶 ★★★
 * 
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 * 
 * 思路：动态规划。1级台阶 1种；2级台阶 2种；3级台阶 方案一，跳一级，后面有2级台阶的种数 方案二，跳两级，后面有1级台阶的种数；n级台阶 方案一+方案二 ：f(n-2)+f(n-1)
 * （对于第n个台阶来说，只能从n-1或者n-2的台阶跳上来，所以F(n) = F(n-1) + F(n-2) ）
 * 其实就是斐波那契数列
 * 
 * @date 2016年4月27日 下午6:44:23
 * @author yangengzhe
 *
 */
public class code10 {
    //叠加遍历
    public int JumpFloor(int target) {
        if(target<3) return target;
        int a=1,b=2,c=3;
        while(target>2){
            c = a+b;
            a=b;
            b=c;
            target--;
        }
        return c;
    }
}
