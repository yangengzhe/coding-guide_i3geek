package nowcoder.剑指offer;


/**
 * 旋转数组的最小数字 ★★★★
 * 
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个非递减序列的一个旋转，输出旋转数组的最小元素。例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 * 
 * 思路：方法一：遍历数组O（n）。方法二：二分查找。中间元素分别和头元素、尾元素比较，决定第二次的查找范围。
 * @date 2016年4月27日 下午4:00:43
 * @author yangengzhe
 *
 */
public class code8 {
    public int fun(int[] array,int start,int end){
        if(array.length == 0) return 0;
        if(start == end || array[start]<array[end])return array[start];
        if(start == end-1) return array[end];
        int mid = (start+end)/2;
        if(array[start]<array[mid]){
            return fun(array,mid,end);
        }
        else if(array[start]>array[mid] ){
            return fun(array, start, mid);
        }
        else{
                int a = fun(array, start, mid-1);
                int b = fun(array,mid+1,end);
                return a>b?b:a;
        }
    }
    public int minNumberInRotateArray(int [] array) {
        return fun(array,0,array.length-1);
    }
    
    
    public int minNumberInRotateArray2(int [] array) {
        if(array==null || array.length==0) return 0;
        if(array[0]<array[array.length-1]){
            return array[0];
        }
        if(array.length<2) return array[0];
        int result=0;
        for(int i=array.length-1;i>0;i--){
            if(array[i]<array[i-1]){
                result = array[i];
                break;
            }
        }
        return result;
    }
}
