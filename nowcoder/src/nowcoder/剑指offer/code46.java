package nowcoder.剑指offer;


/**
 * 翻转单词顺序列 ★★★
 * 
 * 牛客最近来了一个新员工Fish，每天早晨总是会拿着一本英文杂志，写些句子在本子上。同事Cat对Fish写的内容颇感兴趣，有一天他向Fish借来翻看，但却读不懂它的意思。例如，“student. a am I”。后来才意识到，这家伙原来把句子单词的顺序翻转了，正确的句子应该是“I am a student.”。Cat对一一的翻转这些单词顺序可不在行，你能帮助他么？
 * 
 * 思路：写一个反转函数，反转两次。第一次反转全句，第二次反转单词
 * 
 * @date 2016年6月13日 下午7:35:27
 * @author yangengzhe
 *
 */
public class code46 {
    public void fun(char[] str,int start,int end){
        if(end <start) return;
        for(int i=start ;i<=(start+end)/2;i++ ){
            char temp = str[i];
            str[i] = str[end + start -i];
            str[end + start -i] = temp;
        }
    }
    public String ReverseSentence(String str) {
        char[] strs = str.toCharArray();
        fun(strs, 0, str.length()-1);
        int start = 0;
        for(int i=0;i<str.length();i++){
            if(strs[i] == ' '){
                fun(strs, start, i-1);
                start = i+1;
            }
        }
        fun(strs, start, str.length()-1);
        return new String(strs);
    }
    
    public static void main(String args[]){
        code46 c = new code46();
        String str = "  ";
        System.out.println(c.ReverseSentence(str));
    }
}
