package nowcoder.剑指offer;

import java.awt.List;
import java.util.HashMap;
import java.util.Stack;

/**
 * 两个链表的第一个公共结点 ★★
 * 
 * 输入两个链表，找出它们的第一个公共结点。
 * 
 * 思路： 1.笨方法 O(n^2)
 * 2. 利用HashMap遍历两次 O(n)
 * 3. 有公共节点 单链表，肯定是Y字型，利用倒序 查处第一个不同的 利用栈O(n)
 * 4. 先遍历出来两个数组长度，长的 先移动 和短的对齐，之后同时遍历 找到第一个相同的O(n)
 * 
 * @date 2016年6月5日 下午4:04:08
 * @author yangengzhe
 *
 */
public class code38 {
    
    //思路2
    public ListNode FindFirstCommonNode2(ListNode pHead1, ListNode pHead2) {
        HashMap<ListNode,Boolean> map = new HashMap<ListNode,Boolean>();
        while(pHead1!=null){
            map.put(pHead1, true);
            pHead1 = pHead1.next;
        }
        while(pHead2!=null){
            if(map.containsKey(pHead2))
                return pHead2;
            pHead2 = pHead2.next;
        }
        return null;
    }
    
    //思路3
    public ListNode FindFirstCommonNode3(ListNode pHead1, ListNode pHead2) {
        Stack<ListNode> stack1 = new Stack<ListNode>();
        Stack<ListNode> stack2 = new Stack<ListNode>();
        ListNode result = null;
        while(pHead1!=null){
            stack1.push(pHead1);
            pHead1 = pHead1.next;
        }
        while(pHead2!=null){
            stack2.push(pHead2);
            pHead2 = pHead2.next;
        }
        while(!stack1.isEmpty() && !stack2.isEmpty()){
            if(!stack1.peek().equals(stack2.peek()))
                break;
            result = stack1.pop();
            stack2.pop();
        }
        return result;
    }
    
    //思路4
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        int countA = 0,countB = 0;
        
        ListNode result = null;
        ListNode temp = pHead1;
        while(pHead1!=null){
            countA++;
            pHead1 = pHead1.next;
        }
        pHead1 = temp;
        temp = pHead2;
        while(pHead2!=null){
            countB++;
            pHead2 = pHead2.next;
        }
        pHead2 = temp;
        while(countA>countB){
           pHead1 = pHead1.next;
           countA--;
        }
        while(countA<countB){
            pHead2 = pHead2.next;
            countB--;
        }
        while(pHead1!=null){
            if(pHead1 == pHead2)
                return pHead1;
            pHead1 = pHead1.next;
            pHead2 = pHead2.next;
        }
        return result;
    }
}