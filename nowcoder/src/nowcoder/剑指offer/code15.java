package nowcoder.剑指offer;


/**
 * 调整数组顺序使奇数位于偶数前面 ★★
 * 
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，所有的偶数位于位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 * 
 * 思路：重点在顺序不发生变化。两个指针，从头开始，第一个指针找偶数，第二个指针在后面找奇数，找到后移动位置（不能交换），直到结束。
 * 方法二：类似冒泡排序思想，遇到前偶后奇就交换
 * 方法三：常规方法，创建一个数组，遍历两遍
 * @date 2016年5月3日 下午4:23:48
 * @author yangengzhe
 *
 */
public class code15 {
    //1234567 1324567 1352467
    public void reOrderArray(int [] array) {
        int i=0,j=0;
        while(j<array.length){
            while(i<array.length && (array[i]&0x1) == 1)
                i++;
            j=i+1;
            while(j<array.length && (array[j]&0x1) == 0)
                j++;
            if(j<array.length){
                int temp = array[j];
                for(int m=j;m>i;m--)
                    array[m] = array[m-1];
                array[i] = temp;
            }
        }
    }
    //类似冒泡
    void reOrderArray2(int [] array) {
        for (int i = 0; i < array.length;i++)
        {
            for (int j = array.length - 1; j>i;j--)
            {
                if (array[j] % 2 == 1 && array[j - 1]%2 == 0) //前偶后奇交换
                {
                    int temp = array[j];
                    array[j] = array[j-1];
                    array[j-1] = temp;
                }
            }
        }
    }
    
    public static void main(String args[]){
        code15 c = new code15();
        int[] a = new int[]{1,2,3,4,5,6,7};
        c.reOrderArray(a);
        for(int i=0;i<a.length;i++)
        System.out.println(a[i]);
    }
}
