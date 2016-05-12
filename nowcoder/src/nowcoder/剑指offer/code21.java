package nowcoder.剑指offer;

import java.util.ArrayList;

public class code21 {
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> result = new ArrayList<Integer>();
         int x1=0,y1=0,x2=matrix[0].length-1,y2=matrix.length-1;
         while (x1<x2 && y1<y2) {
             for(int i=x1;i<x2;i++)
                 result.add(matrix[y1][i]);
             for(int i=y1;i<y2;i++)
                 result.add(matrix[i][x2]);
             for(int i=x2;i>x1;i--)
                 result.add(matrix[y2][i]);
             for(int i=y2;i>y1;i--)
                 result.add(matrix[i][x1]);
             x1++;
             y1++;
             x2--;
             y2--;
         }
         
          while(x1==x2 && y1<y2){
             result.add(matrix[y1][x1]);
             y1++;
         }
         while(y1==y2 && x1<x2){
             result.add(matrix[y1][x1]);
             x1++;
         }
         
         if(x1==x2 && y1==y2)
             result.add(matrix[y1][x1]);
         return result;
     }
    
    public static void  main(String args[]) {
        code21 c = new code21();
        int [][] n = {{1}};
        ArrayList<Integer> re =c.printMatrix(n);
        for (Integer integer : re) {
            System.out.println(integer);
        }
        
    }
}
