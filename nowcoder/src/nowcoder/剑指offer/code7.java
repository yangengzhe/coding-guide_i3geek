package nowcoder.剑指offer;

import java.util.Stack;

/**
 * 用两个栈实现队列 ★★★
 * 
 * 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 * 
 * 思路：一个栈是FILO，两个栈 通过逆序两次，实现队列FIFO
 * @date 2016年4月25日 下午6:00:46
 * @author yangengzhe
 *
 */
public class code7 {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();
    
    public void push(int node) {
        while(!stack2.empty())
            stack1.push(stack2.pop());
        stack1.push(node);
    }
    
    public int pop() {
        while(!stack1.empty())
            stack2.push(stack1.pop());
        return stack2.pop();
    }
}
