package nowcoder.剑指offer;

import java.util.TreeSet;

/**
 * 扑克牌顺子 ★★★★
 * 
 * LL今天心情特别好,因为他去买了一副扑克牌,发现里面居然有2个大王,2个小王(一副牌原本是54张^_^)...他随机从中抽出了5张牌,想测测自己的手气,看看能不能抽到顺子,如果抽到的话,他决定去买体育彩票,嘿嘿！！“红心A,黑桃3,小王,大王,方片5”,“Oh My God!”不是顺子.....LL不高兴了,他想了想,决定大\小 王可以看成任何数字,并且A看作1,J为11,Q为12,K为13。上面的5张牌就可以变成“1,2,3,4,5”(大小王分别看作2和4),“So Lucky!”。LL决定去买体育彩票啦。 现在,要求你使用这幅牌模拟上面的过程,然后告诉我们LL的运气如何。为了方便起见,你可以认为大小王是0。
 * 
 * 思路：两个条件：除了0之外不可以重复；max - min<5
 * 1. 利用treeset 排序好，进行比较
 * 2. 简化，不用排序
 * 
 * @date 2016年6月14日 下午12:45:43
 * @author yangengzhe
 *
 */
public class code47 {
    public boolean isContinuous(int [] numbers) {
        int max = -1,min=14;
        int[] num = new int[15];
        for(int i=0;i<numbers.length;i++){
            if(numbers[i] == 0) {
                num[0]++;
                continue;
            }
            if(max <numbers[i]) max = numbers[i];
            if(min >numbers[i]) min = numbers[i];
            
            if(num[numbers[i]] ==0)
                num[numbers[i]]=1;
            else
                return false;
        }
        if(max - min <5 && max-min+num[0]>=4)
            return true;
        return false;
    }
    //思路1
    public boolean isContinuous2(int [] numbers) {
        TreeSet<Integer> set = new TreeSet<>();
        int count = 0;
        for(int i=0;i<numbers.length;i++){
            if(numbers[i] == 0) count++;
            else    set.add(numbers[i]);
        }
        if(count ==5 || set.size()+count !=5)
            return false;
        if( set.last() -set.first()+count >= 4 && set.last() -set.first() <5)
            return true;
        return false;
    }
    
    public static void main(String args[]){
        int[] numbers = {0,0,1,3,5};
        code47 c = new code47();
        System.out.println(c.isContinuous(numbers));
    }
}
