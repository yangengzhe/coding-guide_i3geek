package nowcoder.剑指offer;

import java.util.Arrays;

/**
 * 把数组排成最小的数 ★★★
 * 
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 * 
 * 思路：利用int比较的话 会超出越界。所有用String来进行比较
 * @date 2016年5月31日 下午2:35:40
 * @author yangengzhe
 *
 */
public class code34 {
    //不正确
//    public String[] parseString(int[] numbers){
//        String[] result = new String[numbers.length];
//        int max_length = 0;
//        for(int i=0;i<numbers.length;i++){
//            result[i] = String.valueOf(numbers[i]);
//            max_length = max_length > result[i].length()?max_length:result[i].length();
//        }
//        for(int i=0;i<numbers.length;i++){
//            while(result[i].length()<max_length){
//                result[i] = result[i]+':';
//            }
//            
//        }
//        Arrays.sort(result);
//        return result;
//    }
//    public String PrintMinNumber(int [] numbers) {
//        String[] strs = parseString(numbers);
//        StringBuilder result = new StringBuilder();
//        for(int i=0;i<strs.length;i++){
//            result.append(strs[i]);
//        }
//        String re = result.toString();
//        return re.replace(":", "");
//    }
    
    public String PrintMinNumber(int [] numbers) {
        if(numbers.length == 0 || numbers == null) return "";
        Arrays.sort(numbers);
        String result = String.valueOf(numbers[0]);
        for(int i=1;i<numbers.length;i++){
            if(String.valueOf(result+numbers[i]).compareTo(String.valueOf(numbers[i]+result)) <0)
                result = result+numbers[i];
            else
                result = numbers[i]+result;
        }
        return result;
    }
    
    public static void main(String args[]){
        code34 c = new code34();
        int[] array ={3334,3,3333332};
//        int[] array ={3,5,1,4,2};
//        int[] array = {34,3};
        System.out.println(c.PrintMinNumber(array));
    }
}
