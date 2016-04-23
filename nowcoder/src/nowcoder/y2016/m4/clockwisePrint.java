package nowcoder.y2016.m4;

import nowcoder.一站通offer.test2;

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
        int m=3;
        int[] result = c.clockwisePrint(a, n,m);
        for(int i = 0;i<result.length;i++)
            System.out.print(result[i]+",");
    }
    
    
    public int[] clockwisePrint(int[][] mat, int n, int m) {
        // write code here
        int i1=0,j1=0,i2=n-1,j2=m-1;
        int[] result = new int[n*m];
        int count=0;
       while(true){
           if(i1>i2 && j1>j2 || i2<0 || j2<0)
               break;
           
           for(int o=j1;o<j2;o++)
               result[count++] = mat[i1][o];
           for(int o=i1;o<i2;o++)
               result[count++] = mat[o][j2];
           if(i2!=i1)
           for(int o=j2;o>j1;o--){
               result[count++] = mat[i2][o];}
           if(j2!=j1)
           for(int o=i2;o>i1;o--)
               result[count++] = mat[o][j1];
           
           if(i2==i1 || j2==j1)
               result[count++] = mat[i1][j1];
           i1++;
           j1++;
           i2--;
           j2--;
       }
        return result;
    }
}
