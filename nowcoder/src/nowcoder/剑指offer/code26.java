package nowcoder.剑指offer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

/**
 * 二叉树中和为某一值的路径 ★★★★
 * 
 * 输入一颗二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 * 
 * 思路：类似深度优先，但是不能用栈，因为无法记录结点。
 * 利用递归前序循环遍历，其中用栈存储路过的结点即可
 * 
 * @date 2016年5月14日 下午8:18:59
 * @author yangengzhe
 *
 */
public class code26 {
    public void fun(TreeNode node,Stack<Integer> stack,int sum,int target ,ArrayList<ArrayList<Integer>> result){
        if(node == null) return;
        sum = sum+node.val;
        stack.push(node.val);
        if(node.left == null && node.right == null){
            if(sum == target){
                //输出队列
                Iterator<Integer> it = stack.iterator();
                ArrayList<Integer> list = new ArrayList<Integer>();
                while(it.hasNext()){
                    list.add(it.next());
                }
                result.add(list);
            }
        }
        else{
            fun(node.left, stack, sum, target,result);
            fun(node.right, stack, sum, target,result);
        }
        stack.pop();
        return;
    }
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
        Stack<Integer> stack = new Stack<Integer>();
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        fun(root, stack, 0, target, result);
        return result;
    }
    
    public static void main(String args[]){
        code26 c = new code26();
        TreeNode root = new TreeNode(10);
        TreeNode node = new TreeNode(5);
        node.left = new TreeNode(4);
        node.right = new TreeNode(7);
        root.left = node;
        root.right = new TreeNode(12);
        c.FindPath(root, 22);
    }
}
