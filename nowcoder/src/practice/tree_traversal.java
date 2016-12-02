package practice;

import java.util.Stack;

class Node{
    int val;
    Node left,right;
    
    public Node(int val){
        this.val = val;
    }
}
/**
 * @date 2016年10月16日 下午6:25:46
 * @author yangengzhe
 * 二叉树的前中后遍历 递归非递归、深度、结点个数
 * http://blog.csdn.net/hackbuteer1/article/details/6583988
 *
 */
public class tree_traversal {
    public static Node init(){
        Node head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
        head.left.left = new Node(4);
        head.right.left = new Node(5);
        head.right.right = new Node(6);
        return head;
    }
    //递归 前序
    public static void preFun(Node head){
        if(head!=null){
            System.out.println(head.val);
            preFun(head.left);
            preFun(head.right);
        }
    }
    //非递归 前序 栈
    public static void preFun2(Node head){
        Stack<Node> stack = new Stack<Node>();
        stack.push(head);
        while(!stack.empty()){
            Node temp = stack.pop();
            System.out.println(temp.val);
            if(temp.right!=null)//注意 此处顺序颠倒！
                stack.push(temp.right);
            if(temp.left!=null)
                stack.push(temp.left);
        }
    }
    //非递归 前序 栈 △
    public static void preFun3(Node head){
        Stack<Node> stack = new Stack<Node>();
        Node temp = head;
        while(head !=null || !stack.empty()){
             while(temp!=null){
                 System.out.println(temp.val);
                 stack.push(temp);
                 temp = temp.left;
             }
             if(!stack.empty()){
                 temp = stack.pop();
                 temp = temp.right;
             }
        }
    }
    //递归 中序
    public static void inFun(Node head){
        if(head!=null){
            inFun(head.left);
            System.out.println(head.val);
            inFun(head.right);
        }
    }
    //非递归 中序 栈
    public static void inFun2(Node head){
        Stack<Node> stack = new Stack<Node>();
        Node temp = head;
        while(head !=null || !stack.empty()){
             while(temp!=null){
                 stack.push(temp);
                 temp = temp.left;
             }
             if(!stack.empty()){
                 temp = stack.pop();
                 System.out.println(temp.val);
                 temp = temp.right;
             }
        }
    }
    
    //递归 后序
    public static void postFun(Node head){
        if(head!=null){
            postFun(head.left);
            postFun(head.right);
            System.out.println(head.val);
        }
    }
    //非递归 后序 栈
    public static void postFun2(Node head){
        
    }
    //树的深度
    public static int depth(Node head){
        if(head == null) return 0;
        int d1,d2;
        d1 = 1+depth(head.left);
        d2 = 1+depth(head.right);
        return d1>d2?d1:d2;
    }
    //结点个数
    public static int count(Node head){
        if(head == null)
            return 0;
        return 1+count(head.left)+count(head.right);
    }
    //测试
    public static void main(String args[]){
//        preFun3(init()); 
        System.out.println(count(init()));
    }
    
}
