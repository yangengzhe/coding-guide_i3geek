package nowcoder.剑指offer;

import nowcoder.剑指offer.util.ListNode;

/**
 * 合并两个排序的链表 ★★★
 * 
 * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 * 
 * 思路：递归，比较
 * 
 * @date 2016年5月5日 上午10:49:23
 * @author yangengzhe
 */
public class code18 {

    // 135 246
    public ListNode Merge(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        else if (list2 == null) return list1;
        ListNode mergeHead = null;
        if (list1.val < list2.val) {
            mergeHead = list1;
            mergeHead.next = Merge(list1.next, list2);
        } else {
            mergeHead = list2;
            mergeHead.next = Merge(list1, list2.next);
        }
        return mergeHead;

    }
}
