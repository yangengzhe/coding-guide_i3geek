package nowcoder.剑指offer;


/**
 * 链表中倒数第k个结点 ★★★
 * 
 * 输入一个链表，输出该链表中倒数第k个结点。
 * 
 * 思路：两个指针，前后指针，间隔k个元素，当前面的指针到达末尾则后面的指针就是返回值。
 * 
 * @date 2016年5月4日 下午3:34:18
 * @author yangengzhe
 *
 */
//class ListNode {
//    int val;
//    ListNode next = null;
//
//    ListNode(int val) {
//        this.val = val;
//    }
//}
    
public class code16 {
    public ListNode FindKthToTail(ListNode head,int k) {
        ListNode foot = head;
        for(int i=0;i<k;i++)
        {
            if(head==null) return null;
            head = head.next;
        }
        while(head!=null){
            head = head.next;
            foot = foot.next;
        }
        return foot;
    }
}
