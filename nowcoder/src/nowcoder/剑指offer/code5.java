package nowcoder.剑指offer;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 从尾到头打印链表 ★
 * 
 * 输入一个链表，从尾到头打印链表每个节点的值。 
 * 
 * 思路：1、栈。2、递归
 * 
 * @date 2016年4月23日 下午4:40:01
 * @author yangengzhe
 *
 */

    class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

public class code5 {
    //递归
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> resulut = new ArrayList<Integer>();
        if(listNode!=null)
            fun(resulut, listNode);
        return resulut;
    }
    public void fun(ArrayList<Integer> resulut ,ListNode listNode){
        if(listNode.next !=null)
            fun(resulut,listNode.next);
        resulut.add(listNode.val);
    }
    
    //栈
    public ArrayList<Integer> printListFromTailToHead2(ListNode listNode) {
        ArrayList<Integer> resulut = new ArrayList<Integer>();
        Stack<ListNode> stack = new Stack<ListNode>();
        if(listNode == null)
            return resulut;
        while(listNode!=null){
            stack.push(listNode);
            listNode = listNode.next;
        }
        while(!stack.isEmpty())
            resulut.add(stack.pop().val);
        return resulut;
    }
}
