package nowcoder.剑指offer;


/**
 * 平衡二叉树 ★★★
 * 
 * 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 * 
 * 思路：1， 计算深度，若左右子节点深度之差小于1 则是平衡的
 * 
 * @date 2016年6月7日 下午12:18:00
 * @author yangengzhe
 *
 */
public class code41 {
    public int deepth(TreeNode root){
        if(root == null) return 0;
        int right = deepth(root.right);
        int left = deepth(root.left);
        return right>left?right+1:left+1;
    }
    public boolean IsBalanced_Solution(TreeNode root) {
        if(root ==null)return true;
        int right = deepth(root.right);
        int left = deepth(root.left);
        if(Math.abs(right-left) <2)
            return true;
        else
            return false;
    }

}
