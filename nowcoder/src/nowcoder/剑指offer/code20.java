package nowcoder.剑指offer;


/**
 * 二叉树的镜像 ★★★
 * 
 * 操作给定的二叉树，将其变换为源二叉树的镜像。
 * 
 *          8
           /  \
          6   10
         / \  / \
        5  7 9 11
        镜像二叉树
            8
           /  \
          10   6
         / \  / \
        11 9 7  5
        
  
   思路：递归调换左右子节点
   
 * @date 2016年5月9日 下午8:34:34
 * @author yangengzhe
 *
 */
public class code20 {
    public void Mirror(TreeNode root) {
        if(root ==null) return;
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        Mirror(root.left);
        Mirror(root.right);
    }
}
