package nowcoder.剑指offer;

import nowcoder.剑指offer.util.ListNode;

/**
 * 反转链表 ★★
 * 
 * 输入一个链表，反转链表后，输出链表的所有元素。
 * 
 * 思路：1、栈 2、递归 3、改变指针顺序 4、申请新空间 构建新链表
 * 
 * @date 2016年5月5日 上午10:09:49
 * @author yangengzhe
 *
 */
public class code17 {
    //无空间申请，只变化指针
    public ListNode ReverseList(ListNode head) {
        ListNode preNode = null;
        while(head!=null){
            ListNode temp = head.next;
            head.next = preNode;
            preNode = head;
            head = temp;
        }
        return preNode;
    }
    
    //申请新空间，构建新链表
    public ListNode ReverseList2(ListNode head) {
        ListNode result = null;
        while(head!=null){
            ListNode temp = new ListNode(head.val);
            temp.next = result;
            result = temp;
            head = head.next;
        }
        return result;
    }
}
