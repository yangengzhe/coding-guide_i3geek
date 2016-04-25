package nowcoder.剑指offer;


/**
 * 重建二叉树 ★★
 * 
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 * 
 * 思路：二叉树前中后序，知道任意两个，可求第三个。
 * 1. 前序 第一个元素 是当前根节点。（确定根节点）
 * 2. 中序，找到前序的第一个元素（根节点），左侧都是左子树，右侧都是右子树（找到左右子树的中序）
 * 3. 在中序找到左子树后，根据个数相同的原则，在前序中 从前往后可以找出左子树和右子树的前序序列。（找到左右子树的前序）
 * 
 * @date 2016年4月25日 下午3:43:41
 * @author yangengzhe
 *
 */
 class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }
public class code6 {
    public TreeNode findRoot(int[] pre,int s_p,int e_p,int[] in,int s_i,int e_i){
        if(s_p>e_p || s_i>e_i) return null;
        TreeNode tree = new TreeNode(pre[s_p]);
        int i=s_i,count=0;
        for(;i<=e_i;i++){
            if(pre[s_p] == in[i]) break;
            count++;
        }
        tree.left = findRoot(pre, s_p+1,s_p+1+count-1,in,s_i,s_i+count-1);
        tree.right = findRoot(pre, s_p+1+count, e_p, in, s_i+count+1, e_i);
        return tree;
    }
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        return findRoot(pre, 0, pre.length-1, in, 0, in.length-1);
    }
}
