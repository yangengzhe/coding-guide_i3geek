package nowcoder.剑指offer;


/**
 * 二叉树的深度 ★★
 * 
 * 输入一棵二叉树，求该树的深度。从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
 * 
 * 思路：递归的思想。倒序看，一个节点的深度 等于其左右子树的 最深的+1，若没有左右子树 则深度就是1
 * 
 * @date 2016年6月5日 下午4:25:58
 * @author yangengzhe
 *
 */
public class code40 {
    public int TreeDepth(TreeNode pRoot)
    {
        if(pRoot == null)
            return 0;
        int right = TreeDepth(pRoot.right);
        int left = TreeDepth(pRoot.left);
        return right>left?right+1:left+1;
    }
}
