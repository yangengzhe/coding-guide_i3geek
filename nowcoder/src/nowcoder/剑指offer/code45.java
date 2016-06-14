package nowcoder.剑指offer;


/**
 * 左旋转字符串 ★★★
 * 
 * 汇编语言中有一种移位指令叫做循环左移（ROL），现在有个简单的任务，就是用字符串模拟这个指令的运算结果。对于一个给定的字符序列S，请你把其循环左移K位后的序列输出。例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，即“XYZdefabc”。是不是很简单？OK，搞定它！
 * 
 * 思路：1. 左右分割，交换顺序
 * 2. 写一个反转函数，反转三次 。 hello word => word hello 单词按空格反转 可以看成是左移5位
 * 
 * @date 2016年6月13日 下午6:52:39
 * @author yangengzhe
 *
 */
public class code45 {
    //反转函数
    public void fun(char[] str,int start,int end){
        if(end <start) return;
        for(int i=start ;i<=(start+end)/2;i++ ){
            char temp = str[i];
            str[i] = str[end + start -i];
            str[end + start -i] = temp;
        }
    }
    public String LeftRotateString(String str,int n) {
        if(str.length() <2) return str;
        n = n%str.length();
        char[] strs = str.toCharArray();
        fun(strs, 0, n-1);
        fun(strs, n, str.length()-1);
        fun(strs, 0, str.length()-1);
        return new String(strs);
    }
    //思路1
    public String LeftRotateString2(String str,int n) {
        if(str.length() <2) return str;
        n = n%str.length();
        String str_left = str.substring(0,n);
        String str_right = str.substring(n);
        return str_right+str_left;
    }
    
    public static void main(String args[]){
        code45 c = new code45();
        System.out.println(c.LeftRotateString("abcXYZdef", 3));
    }
}
