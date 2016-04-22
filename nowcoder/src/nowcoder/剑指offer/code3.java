package nowcoder.剑指offer;


public class code3 {

    public static void main(String[] args) {
        code3 c = new code3();
//        System.out.println(c.Find(array, target));
    }

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
