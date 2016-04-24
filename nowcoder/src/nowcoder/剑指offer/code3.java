package nowcoder.剑指offer;


/**
 * 二维数组中的查找 ★★★
 * 
 * 在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。 
 * 
 * @date 2016年4月22日 下午2:16:24
 * @author yangengzhe
 *
 */
public class code3 {

    public static void main(String[] args) {
        int[][] array={{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
        code3 c = new code3();
        System.out.println(c.Find(array, 1));
    }

    /**
     * 
     * @param array 待查找的二维数组
     * @param target 查找的数字
     * @return
     * @author ygz 下午2:19:15
     */
    public boolean Find(int [][] array,int target) {
        int row = 0;
        int column = array[0].length-1;
        while(row<array.length && column>=0){
            if(array[row][column] == target)
                return true;
            else if(array[row][column]>target)
                column--;
            else if(array[row][column]<target)
                row++;
        }
        return false;
    }
}
