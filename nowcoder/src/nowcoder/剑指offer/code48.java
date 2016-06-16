package nowcoder.剑指offer;


/**
 * 孩子们的游戏(圆圈中最后剩下的数)  ★★★★★
 * 
 * 每年六一儿童节,NowCoder都会准备一些小礼物去看望孤儿院的小朋友,今年亦是如此。HF作为NowCoder的资深元老,自然也准备了一些小游戏。其中,有个游戏是这样的:首先,让小朋友们围成一个大圈。然后,他随机指定一个数m,让编号为0的小朋友开始报数。每次喊到m的那个小朋友要出列唱首歌,然后可以在礼品箱中任意的挑选礼物,并且不再回到圈中,从他的下一个小朋友开始,继续0...m-1报数....这样下去....直到剩下最后一个小朋友,可以不用表演,并且拿到NowCoder名贵的“名侦探柯南”典藏版(名额有限哦!!^_^)。请你试着想下,哪个小朋友会得到这份礼品呢？
 * 
 * 思路：约瑟夫环
 * 1. 模拟环，利用链表或其他结构模拟。时间复杂度O(mn) 空间复杂度O(n)
 * 2. 找规律
 *  f(n,m) = 0               n=1
 *         = [f(n-1,m)+m]%n  n>1
 * @date 2016年6月15日 下午5:41:08
 * @author yangengzhe
 *
 */
public class code48 {
    //思路2
    public int LastRemaining_Solution2(int n,int m){
        if(n<1 ||m<1)
            return -1;
        int last = 0;
        for(int i=2;i<=n;i++){
            last = (last+m)%i;
        }
        return last;
    }
    
    //思路1
    class Node{
        int val;
        Node next;
        Node(int val){
            this.val = val;
        }
    }
    public int LastRemaining_Solution(int n, int m) {
        if(n == 0) return -1;
        Node head = new Node(0);
        Node t_head = head;
        for(int i=1;i<n;i++){
            Node temp = new Node(i);
            t_head.next = temp;
            t_head = t_head.next;
        }
        t_head.next = head;
        while(t_head.next!=t_head){
            for(int i=0;i<m-1;i++)
                t_head = t_head.next;
            t_head.next = t_head.next.next;
        }
        return t_head.val;
    }
    
    public static void main(String args[]){
        code48 c = new code48();
        System.out.println(c.LastRemaining_Solution(5, 3));
    }
}
