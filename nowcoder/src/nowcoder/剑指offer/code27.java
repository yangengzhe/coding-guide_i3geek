package nowcoder.剑指offer;

import java.util.ArrayList;

/**
 * 二叉搜索树与双向链表 ★★★
 * 
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。
 * 
 * 思路 ： 1. 中序遍历，二叉搜索树的中序遍历就是排好序的
 * 
 * @date 2016年5月18日 下午7:17:12
 * @author yangengzhe
 *
 */
public class code27 {
    ArrayList<TreeNode> list = new ArrayList<TreeNode>();
    public void fun(TreeNode node){
        if(node == null) return;
            fun(node.left);
            list.add(node);
            fun(node.right);
    }
    public TreeNode Convert(TreeNode pRootOfTree) {
        if(pRootOfTree == null) return null;
        fun(pRootOfTree);
        TreeNode temp = null;
        for(int i=0;i<list.size();i++){
            list.get(i).left = temp;
            temp = list.get(i);
            if(i+1 == list.size())
                list.get(i).right = null;
            else
                list.get(i).right = list.get(i+1);
        }
        return list.get(0);
    }
}
