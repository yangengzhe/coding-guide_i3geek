package nowcoder.剑指offer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * 字符串的排列 ★★★★★
 * 
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。 结果请按字母顺序输出。 
 * 输入描述：
 * 输入一个字符串,长度不超过9(可能有字符重复),字符只包括大小写字母。
 * 
 * 思路：递归思想（字符串分成 第一个字符 和 后面的字符 两部分）
 *      第一步：求出所有可能出现在第一个位置的字符，即把后面的字符都和第一个交换
 *      第二步：求后面所有字符的排列顺序组合
 *      第三步：恢复原序列，递归调用
 * 排序：TreeSet利用TreeMap实现 通过红黑树，字典序
 * 
 * @date 2016年5月22日 下午7:07:02
 * @author yangengzhe
 *
 */
public class code28 {
    private TreeSet<String> result = new TreeSet<String>();
    public void fun(char[] strs,int begin){
        if(begin == strs.length){
            result.add(new String(strs));
        }else{
            for(int i=begin;i!=strs.length;i++){
                char temp = strs[i];
                strs[i] = strs[begin];
                strs[begin] = temp;
                
                fun(strs, begin+1);
                
                temp = strs[i];
                strs[i] = strs[begin];
                strs[begin] = temp;
            }
        }
        
    }
    public ArrayList<String> Permutation(String str) {
        ArrayList<String> arrange = new ArrayList<String>();
        if(str == null || str.isEmpty()) return arrange;
        char[] strs = str.toCharArray();
        fun(strs,0);
        Iterator<String> it = result.iterator();
        while(it.hasNext()){
            arrange.add(it.next());
        }
        return arrange;
    }
}
