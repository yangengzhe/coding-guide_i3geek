package nowcoder.剑指offer;


/**
 * 把字符串转换成整数 ★★
 * 
 * 将一个字符串转换成一个整数，要求不能使用字符串转换整数的库函数。
 * 
 * 思路： 考虑程序的健全性。正负号，非数字等问题
 * 
 * @date 2016年6月21日 下午7:03:28
 * @author yangengzhe
 *
 */
public class code51 {
    public int StrToInt(String str)
    {
        if (str.equals("") || str.length() == 0)
            return 0;
        char[] a = str.toCharArray();
        int fuhao = 0;
        if (a[0] == '-')
            fuhao = 1;
        int sum = 0;
        for (int i = fuhao; i < a.length; i++)
        {
            if (a[i] == '+')
                continue;
            if (a[i] < 48 || a[i] > 57)
                return 0;
            sum = sum * 10 + a[i] - 48;
        }
        return fuhao == 0 ? sum : sum * -1;
    }
}
