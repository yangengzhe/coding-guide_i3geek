package nowcoder.剑指offer;

import java.util.ArrayList;

/**
 * 丑数 ★★★
 * 
 * 把只包含因子2、3和5的数称作丑数（Ugly Number）。例如6、8都是丑数，但14不是，因为它包含因子7。 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 * 
 * 思路：1. 逐个判断
 * 2.用空间换时间，利用数组存储已经求好的丑数，只需要乘2、3或5即可
 * 
 * @date 2016年6月1日 下午4:57:02
 * @author yangengzhe
 *
 */
public class code35 {
    //判断是不是丑数
    public boolean isUgly(int number){
        while(number%2 == 0)
            number = number/2;
        while(number%3==0)
            number = number/3;
        while(number%5==0)
            number = number/5;
        if(number == 1) return true;
        else return false;
    }
    //空间换时间
    public int GetUglyNumber_Solution(int index) {
        if(index<1) return 0;
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(1);
        int count = 1;
        int pos_2=0,pos_3=0,pos_5=0;
        while(count < index){
            int ugly_2 = list.get(pos_2)*2;
            int ugly_3 = list.get(pos_3)*3;
            int ugly_5 = list.get(pos_5)*5;
            int cur_ugly = ugly_2>ugly_3?ugly_3:ugly_2;
            cur_ugly = cur_ugly>ugly_5?ugly_5:cur_ugly;
            
            list.add(cur_ugly);
            count++;
            
            while(list.get(pos_2)*2 <= cur_ugly)
                pos_2++;
            while(list.get(pos_3)*3 <= cur_ugly)
                pos_3++;
            while(list.get(pos_5)*5 <= cur_ugly)
                pos_5++;
        }
        return list.get(index-1);
    }
}
