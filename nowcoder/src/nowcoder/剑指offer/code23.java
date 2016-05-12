package nowcoder.剑指offer;

import java.util.ArrayList;

/**
 * 从上往下打印二叉树 ★
 * 
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 * 
 * 思路：深度优先用栈，广度优先用队列
 * @date 2016年5月11日 下午8:18:35
 * @author yangengzhe
 *
 */
public class code23 {
    public class Solution {
        public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
            ArrayList<Integer> result = new ArrayList<Integer>();
            ArrayList<TreeNode> list = new ArrayList<TreeNode>();
            if(root == null) return result;
            list.add(root);
            while(!list.isEmpty()){
                TreeNode temp =list.remove(0);
                result.add(temp.val);
                if(temp.left!=null)
                    list.add(temp.left);
                if(temp.right!=null)
                    list.add(temp.right);
            }
            return result;
        }
    }
}
