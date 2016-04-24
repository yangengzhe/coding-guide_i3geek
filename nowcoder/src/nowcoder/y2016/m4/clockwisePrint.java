package nowcoder.y2016.m4;

/**
 * 思路：矩阵 左上角和右下角两个点为标准点，不断向内缩小范围，
 * 顺时针打印矩阵
 * 对于一个矩阵，请设计一个算法从左上角(mat[0][0])开始，顺时针打印矩阵元素。
给定int矩阵mat,以及它的维数nxm，请返回一个数组，数组中的元素为矩阵元素的顺时针输出。
 * @date 2016年4月22日 下午4:44:40
 * @author yangengzhe
 *
 */
public class clockwisePrint {
    public static void main(String args[]){
        clockwisePrint c = new clockwisePrint();
        int[][] a = {{57,50,59,18,31,13},{67,86,93,86,4,9},{38,98,83,56,82,90},{66,50,67,11,7,69},{20,58,55,24,66,10},{43,26,65,0,64,28},{62,86,38,19,37,98}};
//        int[][]a = {{1},{2},{3},{4},{5},{6},{7}};
        int n=3;
        int m=2;
        int[] result = c.clockwisePrint(a, n,m);
        for(int i = 0;i<result.length;i++)
            System.out.print(result[i]+",");
    }
    
    
    public int[] clockwisePrint(int[][] mat, int n, int m) {
        // write code here
        int i1=0,j1=0,i2=n-1,j2=m-1;
        int[] result = new int[n*m];
        int count=0;
       while(i1<=i2 && j1<=j2){//左上和右下没有交叉
           if (i1== i2) {//一行
               for (int i = j1; i <= j2; i++ ) 
                   result[count++]=mat[i1][i];
               return result;
           }
           if (j1 == j2) {//一列
               for (int i = i1; i <= i2; i++ ) 
                   result[count++]=mat[i][j2];
               return result;
           }
           for(int o=j1;o<j2;o++)//右移
               result[count++] = mat[i1][o];
           for(int o=i1;o<i2;o++)//下移
               result[count++] = mat[o][j2];
           for(int o=j2;o>j1;o--)//左移
               result[count++] = mat[i2][o];
           for(int o=i2;o>i1;o--)//上移
               result[count++] = mat[o][j1];           
           i1++;
           j1++;
           i2--;
           j2--;
       }
        return result;
    }
}
