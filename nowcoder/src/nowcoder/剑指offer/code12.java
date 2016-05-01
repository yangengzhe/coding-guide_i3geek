package nowcoder.剑指offer;

import java.util.Vector;

/**
 * 矩形覆盖 ★★★
 * 
 * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 * 
 * 思路：第n个小矩形时，放法只有两种，竖着是就是f(n-1)；或者横着放 横着时 下方必须也是一个小矩形，所以有f(n-2)种，这样就是菲波那切数列了
 * @date 2016年5月1日 下午2:17:48
 * @author yangengzhe
 *
 */
public class code12 {
    //递归方法
    Vector<Integer> vector = new Vector<Integer>();
    public int fun(int a){
        if(vector.size()>a) return vector.get(a);
        int result = fun(a-1)+fun(a-2);
        vector.add(a,result);
        return result;
    }
    public int RectCover2(int target) {
        vector.add(0,1);
        vector.add(1,1);
        vector.add(2,2);
        return fun(target);
    }
    
    //非递归方法
    public int RectCover(int target) {
        if(target<2) return 1;
        int a=1,b=1,c=2;
        while(target>=2){
            c=a+b;
            a=b;
            b=c;
            target--;
        }
        return c;
    }
    
}
