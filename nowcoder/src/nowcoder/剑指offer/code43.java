package nowcoder.剑指offer;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * 和为S的连续正数序列 ★★★
 * 
 * 小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,他马上就写出了正确答案是100。但是他并不满足于此,他在想究竟有多少种连续的正数序列的和为100(至少包括两个数)。没多久,他就得到另一组连续正数和为100的序列:18,19,20,21,22。现在把问题交给你,你能不能也很快的找出所有和为S的连续正数序列? Good Luck! 
 * 
 * 思路：前面两个指针，若和比已知数大，则右移前指针；若和比已知数小，则右移后指针
 * @date 2016年6月11日 下午3:41:32
 * @author yangengzhe
 *
 */
public class code43 {
    public ArrayList<ArrayList<Integer> > FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer> > result = new ArrayList<ArrayList<Integer> >();
        int _sum = 3,small = 1,big = 2;
        while(small<big){
            if(_sum<sum){
                big++;
                _sum+=big;
            }else if(_sum>sum){
                _sum-=small;
                small++;
            }else{
                ArrayList<Integer> list = new ArrayList<Integer>();
                for(int i=small;i<=big;i++)
                    list.add(i);
                result.add(list);
                big++;
                _sum+=big;
            }
        }
        return result;
    }
    
    public static void main(String args[]){
        code43 c = new code43();
        ArrayList<ArrayList<Integer> > a = c.FindContinuousSequence(15);
        for(int i=0;i<a.size();i++){
            ArrayList<Integer> b=a.get(i);
            for(int j = 0;j<b.size();j++){
                System.out.print(b.get(j));
                System.out.print(' ');
            }
            System.out.println();
        }
    }
}
