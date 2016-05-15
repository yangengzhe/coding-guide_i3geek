package nowcoder.剑指offer;

import java.util.Stack;

/**
 * 栈的压入、弹出序列 ★★★★
 * 
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。假设压入栈的所有数字均不相等。例如序列1,2,3,4,5是某栈的压入顺序，序列4，5,3,2,1是该压栈序列对应的一个弹出序列，但4,3,5,1,2就不可能是该压栈序列的弹出序列。
 * 
 * 思路：利用辅助栈。
 * 1）当辅助栈的栈顶元素不是出栈数组时，按照入站数组进行入栈 同时后移入栈数组；
 * 2）当栈顶元素是出栈数组时，移除栈顶元素 同时后移出栈数组；
 * 3）如果没有入栈元素了 但是出栈元素还有剩余且不等于栈顶元素，则返回false；
 * 4）最终栈空返回true 否则返回false
 * 
 * @date 2016年5月14日 下午4:41:42
 * @author yangengzhe
 *
 */
public class code25 {
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        if(pushA.length==0||popA.length==0) return false;
        Stack<Integer> stack = new Stack<Integer>();
        int a=0;
        for(int i=0;i<popA.length;i++){
            while(stack.empty() || !stack.peek().equals(popA[i])){
                if(a==pushA.length) break;
                stack.push(pushA[a++]);
            }
            if(stack.peek().equals(popA[i]))
                stack.pop();
            else if(a==pushA.length) return false;
        }
        if(stack.empty()) return true;
        else return false;
    }
    
    //方法二：
    /*思路：先循环将pushA中的元素入栈，遍历的过程中检索popA可以pop的元素
    **如果循环结束后栈还不空，则说明该序列不是pop序列。
    */
    public boolean IsPopOrder2(int [] pushA,int [] popA) {
        if (pushA.length == 0 || popA.length == 0) {
            return false;
        }
      Stack<Integer> stack = new Stack<Integer>();
        int j = 0;
        for (int i = 0; i < popA.length; i++) {
            stack.push(pushA[i]);
            while (j < popA.length && stack.peek() == popA[j]) {
                stack.pop();
                j++;
            }
        }
        return stack.empty();
    }

}
