package nowcoder.剑指offer;

/**
 * 数值的整数次方 ★★
 * 
 * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 * 
 * 思路：比较简单，主要是考虑边界问题。如果exponent小于0呢？如果exponent和base都是0呢？
 * 方法二：n^32次方 可以认为是n^16次方的平方，因此利用递归 避免多次的循环
 * 
 * @date 2016年5月3日 下午3:48:57
 * @author yangengzhe
 *
 */
public class code14 {
    //递归方法
    public double Power(double base, int exponent) {
        if(exponent==0) return 1;
        if(base == 0) return 0;
        if(exponent==1) return base;
        if(exponent == -1) return 1/base;
        double result = Power(base, exponent>>1);
        result = result*result;
        if((exponent&1)==1)
            result = result*base;
        return result;
    }
    //普通方法
    public double Power2(double base, int exponent) {
        if(base == 0 && exponent==0) return 1;
        boolean sign = exponent>0?true:false;
        exponent = Math.abs(exponent);
        double result = 1;
        while(exponent>0){
            exponent--;
            result = result*base;
        }
        if(sign)
            return result;
        else
            return 1.0/result;
    }
}
