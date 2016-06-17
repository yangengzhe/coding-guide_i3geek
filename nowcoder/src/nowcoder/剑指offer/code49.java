package nowcoder.剑指offer;


/**
 * 求1+2+3+...+n ★★
 * 
 * 求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）
 * 
 * 思路：利用逻辑与的短路特性实现递归终止。
 * 
 * @date 2016年6月17日 下午1:10:23
 * @author yangengzhe
 *
 */
public class code49 {
    int Sum_Solution(int n) {
        int sum = n;
        boolean ans = (n>0)&&((sum+=Sum_Solution(n-1))>0);
        return sum;
    }
}
