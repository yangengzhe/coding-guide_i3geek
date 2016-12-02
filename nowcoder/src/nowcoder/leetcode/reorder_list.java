package nowcoder.leetcode;

import java.util.Stack;

import nowcoder.leetcode.common.ListNode;

public class reorder_list {
    public void reorderList2(ListNode head) {
        if(head == null) return;
        Stack<ListNode> stack = new Stack<ListNode>();
        ListNode temp = head;
        while(temp!=null){
            stack.push(temp);
            temp = temp.next;
        }
        while(head!=stack.peek()){
            ListNode last = stack.pop();
            last.next = head.next;
            head.next = last;
            head = head.next.next;
            if(last.next == last){
                last.next = null;
                return;
            }
        }
        head.next = null;
    }
    public void reorderList(ListNode head) {
        if(head == null) return;
        ListNode slow= head,fast = head;
        //寻找中点
        while(fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        //原地翻转后半部分链表
        ListNode temp = slow,last = null;
        slow = slow.next;
        while(slow!=null){
            ListNode next = slow.next;
            slow.next = last;
            last = slow;
            if(next == null)
                temp.next = slow;
            slow = next;
        }
        //链表合并
        slow = temp.next;
        temp.next = null;
        while(slow!=null){
            ListNode next = slow.next;
            slow.next = head.next;
            head.next = slow;
            head = head.next.next;
            slow = next;
        }
    }

    
    
    public static void main(String args[]){
        ListNode head = new ListNode(1);
        ListNode iterator = head;
        iterator.next = new ListNode(2);
        iterator = iterator.next;
        iterator.next = new ListNode(3);
        iterator = iterator.next;
        iterator.next = new ListNode(4);
        iterator = iterator.next;
        iterator.next = new ListNode(5);
        
        reorder_list test = new reorder_list();
        test.reorderList(head);
        while(head!=null){
            System.out.println(head.val);
            head = head.next;
        }
        
    }
    
}
