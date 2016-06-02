package nowcoder.剑指offer;

import java.lang.reflect.Method;


/**
 * 第一个只出现一次的字符位置 ★
 * 
 * 在一个字符串(1<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符的位置。若为空串，返回-1。位置索引从0开始
 * 
 * 思路：利用数组节省时间的开销
 * 
 * @date 2016年6月1日 下午5:53:52
 * @author yangengzhe
 *
 */
public class code36 {
    public int FirstNotRepeatingChar(String str) {
        int result = -1;
        if(str == null || str=="") return result;
        char[] array = str.toCharArray();
        int[] count = new int[255];
        for(int i=0;i<array.length;i++){
            count[array[i]]++;
        }
        for(int i=0;i<array.length;i++){
            if(count[array[i]] == 1)
                return i;
        }
        return result;
    }
    public static void main(String args[]){
        try {
            Class c= Class.forName("nowcoder.剑指offer.code36");
            Object o =c.newInstance();
            Method m =c.getMethod("FirstNotRepeatingChar", String.class);
            int a =(int) m.invoke(o, "asd");
            System.out.println(a);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
