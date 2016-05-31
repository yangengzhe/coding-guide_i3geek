package nowcoder.剑指offer;

/**
 * 整数中1出现的次数（从1到n整数中1出现的次数） ★★★
 * 
 * 思路：1.逐个遍历 时间复杂度O(n^2)
 * 2. 转换成字符串的逐个遍历
 * 3. 数字规律：http://www.cnblogs.com/nailperry/p/4752987.html
 * 当计算右数第  i  位包含的 X 的个数时：
 * 1） 取第  i  位左边（高位）的数字，乘以  10 i−1 ，得到基础值  a 。
 * 2） 取第  i  位数字，计算修正值：
 *      如果大于 X，则结果为  a+ 10 i−1 。
 *      如果小于 X，则结果为  a 。
 *      如果等 X，则取第  i  位右边（低位）数字，设为  b ，最后结果为  a+b+1 。
 * 相应的代码非常简单，效率也非常高，时间复杂度只有  O( log 10 n) 。
 * @date 2016年5月31日 上午9:25:47
 * @author yangengzhe
 */
public class code33 {
    //笨方法
    public int NumberOf1Between1AndN_Solution2(int n) {
        int count=0;
        while(n>0){
            String str=String.valueOf(n);
            char [] chars=str.toCharArray();
            for(int i=0;i<chars.length;i++){
                if(chars[i]=='1')
                    count++;
            }
            n--;
        }
        return count;
    }
    
    public int NumberOf1Between1AndN_Solution(int n) {
        return NumberOfXBetween1AndN_Solution(n, 1);
    }
    //计算1到n中 x数出现的次数
    public int NumberOfXBetween1AndN_Solution(int n, int x) {
        if (n < 0 || x < 1 || x > 9) return 0;
        int high, low, curr, tmp, i = 1;
        high = n;
        int total = 0;
        while (high != 0) {
            high = n / (int) Math.pow(10, i);// 获取第i位的高位
            tmp = n % (int) Math.pow(10, i);
            curr = tmp / (int) Math.pow(10, i - 1);// 获取第i位
            low = tmp % (int) Math.pow(10, i - 1);// 获取第i位的低位
            if (curr == x) {
                total += high * (int) Math.pow(10, i - 1) + low + 1;
            } else if (curr < x) {
                total += high * (int) Math.pow(10, i - 1);
            } else {
                total += (high + 1) * (int) Math.pow(10, i - 1);
            }
            i++;
        }
        return total;
    }
}
