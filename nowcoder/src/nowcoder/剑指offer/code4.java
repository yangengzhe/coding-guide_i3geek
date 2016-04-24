package nowcoder.剑指offer;


/**
 * 替换空格 ★
 * 
 * 请实现一个函数，将一个字符串中的空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 * 
 * 思路：1. 遍历数组 查找空格个数。 2. 一个空格替换成3个字符，算出新数组长度。 3. 两个指针 一个尾部 一个字符串尾，逐渐复制后移对象，遇到空格就替换成%20，时间复杂度O（n）
 * @date 2016年4月23日 下午4:19:45
 * @author yangengzhe
 *
 */
public class code4 {
    public static void main(String args[]){
        code4 c = new code4();
        System.out.println(c.replaceSpace("new a"));
    }
    public String replaceSpace(String str) {
        byte[] s = new String(str).getBytes();
        int spaceCount=0;
        for(int i=0;i<s.length;i++){
            if(s[i] == ' ') spaceCount++;
        }
        byte result[] = new byte[s.length+spaceCount*2];
        for(int i=0,j=0;i<s.length;i++,j++){
           result[j] = s[i];
           if(result[j] == ' '){
               result[j++] = '%';
               result[j++] = '2';
               result[j] = '0';
           }
        }
        return new String(result);
    }
}
