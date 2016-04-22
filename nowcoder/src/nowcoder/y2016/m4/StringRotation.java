package nowcoder.y2016.m4;

/**
 * 对于一个字符串，和字符串中的某一位置，请设计一个算法，将包括i位置在内的左侧部分移动到右边，将右侧部分移动到左边。
给定字符串A和它的长度n以及特定位置p，请返回旋转后的结果。
 * @date 2016年4月18日 下午5:29:07
 * @author yangengzhe
 *
 */
public class StringRotation {
    public static void main(String args[]){
        if(rotateString("ABCDEFGH",8,4).equals("FGHABCDE"))
            System.out.println("success");
        System.out.println(rotateString("ABCDEFGH",8,4));
    }
    
    static String rotateString(String A, int n, int p) {
        byte[] a = A.getBytes();
        byte[] b = new byte[n];
        p=p+1;
        for(int i=0;i<n;i++){
            int m = i+p > (n-1) ? (i+p-n):i+p;
            b[i] = a[m];
        }
        return new String(b);
    }
}
