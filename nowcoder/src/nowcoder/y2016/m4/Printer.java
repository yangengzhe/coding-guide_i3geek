package nowcoder.y2016.m4;


public class Printer {
    public static void main(String args[]) {
        int[][] mat = {{1,2,3},{4,5,6},{7,8,9},{10,11,12}};
        System.out.println(printMatrix(mat,4,3)[0]);//[1,2,3,6,5,4,7,8,9,12,11,10]
    }
    public static int[] printMatrix(int[][] mat, int n, int m) {
        int[] result = new int[n*m];
        for(int i=0;i<n;i++){
            for(int l=0;l<m;l++){
                result[i*m+l] = mat[i][Math.abs(i%2*(m-1)-l)];
            }
        }
        return result;
    }
}
