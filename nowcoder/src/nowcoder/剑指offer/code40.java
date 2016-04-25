package nowcoder.剑指offer;

import java.util.ArrayList;

/**
 * 数组中只出现一次的数字 ★★★★
 * 
 * 一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。时间复杂度和空间复杂度O（n）
 * 
 * 思路：1、java中利用队列进行两次标记，就可以筛选。
 * 方法2、异或的性质，两个相同数异或后为0. 数组全部异或后，结果必定两个不同的数的异或。肯定不为0.则肯定至少一位是1.根据为1的那位，进行分组，（肯定不同的两个数 那位不同 才能异或为1）
 * 
 * @date 2016年4月23日 下午8:30:03
 * @author yangengzhe
 *
 */
public class code40 {
    public static void main(String args[]) {
        int array[]={2,4,3,6,3,2,5,5};
        int num1[] = {0},num2[]={0};
        code40 c = new code40();
        c.FindNumsAppearOnce(array, num1, num2);
    }
  //num1,num2分别为长度为1的数组。传出参数
  //将num1[0],num2[0]设置为返回结果
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        int temp =0;num1[0]=0;num2[0]=0;
        if(array.length<2) return;
        for(int i=0;i<array.length;i++)
            temp =  (temp^array[i]);
        int count =0;
        while(true){
            if((temp&1) == 1) break;
            temp =temp>>1;
            count++;
        }
        for(int i=0;i<array.length;i++){
            if(((array[i]>>count)&1)==1)
                num1[0] =num1[0]^array[i];
            else
                num2[0] =num2[0]^array[i];
        }
    }
    
    public void FindNumsAppearOnce2(int [] array,int num1[] , int num2[]) {
        num1[0]=0;
        num2[0]=0;
        if(array.length<2) return;
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int i=0;i<array.length;i++){
            if(list.contains(array[i]))
                list.remove(Integer.valueOf(array[i]));
            else
                list.add(array[i]);
        }
        num1[0] =list.get(0);
        num2[0] =list.get(1);
    }
}
