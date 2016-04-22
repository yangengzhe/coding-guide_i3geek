package nowcoder.一站通offer;

import javax.print.attribute.standard.RequestingUserName;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;
    public TreeNode(int val) {
        this.val = val;
    }
}
public class test3 {
    public int max=0;
    public int search(TreeNode root){
        if(root==null) return 0;
        int left = search(root.left);
        int right = search(root.right);
        int length=1;
        if(root.right ==null && root.left == null)
            return 1;
        if(root.left!=null && root.val==root.left.val)
        {
            length = left+1;
        }
            
        if(root.right!=null && root.val==root.right.val){
                length = length > (right+1)?length:(right+1);
        }
        else{
            max= max>left?max:left;
            max = max>right?max:right;
            max = max>length?max:length;
            length = length>1?length:1;
        }
        if(root.right!=null &&root.left!=null &&root.right.val == root.left.val && root.val == root.left.val){
                max = max>(left+right+1)?max:(left+right+1);
        }
        return length;
    }
    
    public int findPath(TreeNode root) {
        int num = search(root);
        max = max>num?max:num;
        return max;
    }
}




//public class LongestPath {
//    int max = 0;
//    public int findPath(TreeNode root) {
//        // write code here
//        if (root == null) return 0;
//        helper(root);
//        return max;
//    }
//     
//    int helper(TreeNode root){
//        int left = 0, right = 0;
//        if (root.left != null){
//            int tmp = helper(root.left);
//            if (root.val == root.left.val)
//                left = tmp;
//        }
//        if (root.right != null){
//            int tmp = helper(root.right);
//            if (root.val == root.right.val)
//                right = tmp;
//        }
//        max = Math.max(left + right + 1, max);
//        return Math.max(left, right) + 1;
//    }
//}