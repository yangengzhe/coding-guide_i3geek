package nowcoder.剑指offer;


/**
 * 树的子结构 ★★★
 * 
 * 输入两颗二叉树A，B，判断B是不是A的子结构。
 * 
 * 思路：递归遍历，第一个函数 递归找到根节点，若当前不符合则去树的左结点和右结点找。第二个函数 找到结点后 递归判断当前结点是否符合要求。
 * 
 * @date 2016年5月8日 下午8:05:27
 * @author yangengzhe
 *
 */
public class code19 {
    public boolean EqualSubtree(TreeNode root1,TreeNode root2){
        if(root2 == null) return true;
        if(root1 == null) return false;
        if(root1.val != root2.val)
            return false;
        if(EqualSubtree(root1.left, root2.left) && EqualSubtree(root1.right, root2.right))
            return true;
        else
            return false;
    }
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        boolean result = false;
        if(root1 == null || root2== null) return result;
        if(root1.val == root2.val)
            result = EqualSubtree(root1,root2);
        if(!result && root1.left!=null)
            result = HasSubtree(root1.left, root2);
        if(!result && root1.right!=null)
            result = HasSubtree(root1.right, root2);
        return result;
    }
}
