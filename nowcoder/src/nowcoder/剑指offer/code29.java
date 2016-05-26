package nowcoder.剑指offer;


/**
 * 数组中出现次数超过一半的数字 ★★★
 * 
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 * 
 * 思路：1.Partition方法
 * 2. 数组方法，遇到相同数加1，不同数减1.当减到0时 替换比较的数。因为出现次数超过一半 所以最后剩下的数就是要找的
 * @date 2016年5月23日 下午1:09:25
 * @author yangengzhe
 *
 */
public class code29 {
    public int MoreThanHalfNum_Solution(int [] array) {
        if(array.length==0) return 0;
        int temp = array[0];
        int time = 0;
        for(int i=0;i<array.length;i++){
            if(temp == array[i]){
                time++;
            }else{
                if(time == 0) temp = array[i];
                time = time==0?0:time-1;
            }
        }
        if(time == 0) return 0;
        return temp;
    }
    public static void main(String args[]){
        code29 c = new code29();
        int a = c.MoreThanHalfNum_Solution(new int[]{3,3,2});
        System.out.println(a);
    }
}
