package nowcoder;

import java.util.HashMap;

import nowcoder.剑指offer.util.RandomListNode;

/**
 * 复杂链表的复制 ★★★★
 * 
 * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点）。
 * 
 * 思路：1.粗暴的方法，遍历多次，先复制链表，在遍历复制每一个的随机指针 时间复杂度O(n2)
 * 2. 空间换时间，利用HashMap 做一个节点的映射关系 占用O(n)空间，时间复杂度O(n)
 * 3. 复制成一个链表，如： a->b 复制成 a->a'->b->b'。之后拆分成两个链表，时间复杂度O(n)
 * 
 * @date 2016年5月16日 下午6:15:22
 * @author yangengzhe
 *
 */
public class code27 {

    //方法三
    public void copy(RandomListNode pHead){
        while(pHead!=null){
            RandomListNode temp = new RandomListNode(pHead.label);
            temp.next = pHead.next;
            pHead.next = temp;
            pHead = temp.next;
        }
    }
    public void copyRandom(RandomListNode pHead){
        while(pHead!=null){
            RandomListNode node = pHead.next;
            if(pHead.random!=null)
                node.random = pHead.random.next;
            else
                node.random = null;
            pHead = node.next;
        }
    }
    public RandomListNode divide(RandomListNode pHead){
        RandomListNode result = pHead.next;
        RandomListNode _result = result;
        while(pHead!=null){
            pHead.next = result.next;
            pHead = pHead.next;
            if(pHead!=null){
                result.next = pHead.next;
                result = result.next;
            }
            else{
                result.next = null;
            }
        }
        return _result;
    }
    public RandomListNode Clone(RandomListNode pHead){
        if(pHead == null) return null;
        copy(pHead);
        copyRandom(pHead);
        return divide(pHead);
    }
  //方法二
    public RandomListNode Clone2(RandomListNode pHead)
    {
        if(pHead == null) return null;
        HashMap<RandomListNode, RandomListNode> map = new HashMap<RandomListNode,RandomListNode>();
        RandomListNode _head = pHead;
        RandomListNode result = new RandomListNode(_head.label);
        RandomListNode _result = result;
        map.put(_head, result);
        _head = _head.next;
        while(_head!=null){
            RandomListNode temp = new RandomListNode(_head.label);
            result.next = temp;
            map.put(_head, temp);
            result = result.next;
            _head = _head.next;
        }
        result = _result;
        _head = pHead;
        while(result!=null){
            result.random = map.get(_head.random);
            result = result.next;
            _head = _head.next;
        }
        return _result;
    }
}
