package preorderTraversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 144. 二叉树的前序遍历
 * 给你二叉树的根节点 root ，返回它节点值的 前序 遍历。
 * 执行结果：通过
 * 显示详情 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
 * 内存消耗：36.4 MB, 在所有 Java 提交中击败了97.08%的用户
 * 提供了递归遍历版本和非递归遍历版本
 */
public class PreorderTraversal {
    public static void main(String[] args)throws Exception {
        PreorderTraversal code=new PreorderTraversal();
        TreeNode right=new TreeNode(2,new TreeNode(3),null);
        TreeNode root=new TreeNode(1,null,right);
        System.out.println(code.preorderTraversal(root));
    }
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res=new ArrayList<>();
        traverByNotRecursion(root,res);
        return res;
    }
    //递归遍历
    private void traverByRecursion(TreeNode root,List<Integer> list) {
        if(root==null){
            return ;
        }
        list.add(root.val);
        this.traverByRecursion(root.left,list);
        this.traverByRecursion(root.right,list);
    }
    //非递归遍历
    private void traverByNotRecursion(TreeNode root,List<Integer> list) {
        if(root==null){
            return ;
        }
        //使用stack模拟计算机栈
        List<TreeNode> stack=new ArrayList<>();
        stack.add(root);
        do{
            TreeNode node=stack.remove(stack.size()-1);
            list.add(node.val);
            if(node.right!=null){
                stack.add(node.right);
            }
            if(node.left!=null){
                stack.add(node.left);
            }
        }while(stack.size()!=0);
    }
}
