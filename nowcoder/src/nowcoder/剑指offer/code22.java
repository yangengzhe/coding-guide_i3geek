package nowcoder.剑指offer;

import java.util.Stack;

/**
 * 包含min函数的栈 ★★★★
 * 
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈最小元素的min函数。
 * 
 * 思路：定义两个栈，一个栈是普通使用，一个是最小栈，记录当时的最小元素
 * 
 * @date 2016年5月9日 下午8:41:43
 * @author yangengzhe
 *
 */
public class code22 {
    
    Stack<Integer> stack = new Stack<Integer>();
    Stack<Integer> min = new Stack<Integer>();
    
    public void push(int node) {
        stack.push(node);
        if(min.empty())
            min.push(node);
        else
            min.push(min.peek()>node?node:min.peek());
    }
    
    public void pop() {
        stack.pop();
        min.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int min() {
        return min.peek();
    }
}
