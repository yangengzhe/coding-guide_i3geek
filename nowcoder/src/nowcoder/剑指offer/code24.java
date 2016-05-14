package nowcoder.剑指offer;


/**
 * 二叉搜索树的后序遍历序列 ★★★
 * 
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 * 
 * 思路：后续遍历 最后一个是顶点。二叉查找树 顶点左侧小于顶点，右侧大于顶点。
 * 第一步：先找到根节点。最右侧的数
 * 第二步：确定左右子树，遍历 第一个大于根节点之前的 都是左子树，剩余都是右子树
 * 第三部：验证右子树，
 * 第四部：循环遍历 左右子树 
 * 
 * @date 2016年5月12日 下午1:25:17
 * @author yangengzhe
 *
 */
public class code24 {
    public boolean fun(int[] sequence,int start,int end){
        if(start >= end) return true;
        int head = sequence[end];
        int mid=start;
        while(sequence[mid]<head)
        {
            mid++;
        }
        for(int i=mid;i<end;i++)
            if(sequence[i]<sequence[end]) return false;
        return fun(sequence, start, mid-1) && fun(sequence, mid, end-1);
    }
    
    public boolean VerifySquenceOfBST(int [] sequence) {
        if(sequence.length==0 || sequence == null) return false;
        return fun(sequence, 0, sequence.length-1);
    }
}
