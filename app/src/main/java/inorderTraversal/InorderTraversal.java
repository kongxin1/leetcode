package inorderTraversal;

import java.util.ArrayList;
import java.util.List;

/**
 * 94. 二叉树的中序遍历
 * 给你二叉树的根节点 root ，返回它节点值的 中序 遍历。
 * 执行结果：通过
 * 显示详情 0 ms, 在所有 Java 提交中击败了100.00%的用户
 * 内存消耗：36.7 MB, 在所有 Java 提交中击败了45.66%的用户
 * 提供了递归遍历版本和非递归遍历版本
 */
public class InorderTraversal {
    public static void main(String[] args)throws Exception {
        InorderTraversal code=new InorderTraversal();
        TreeNode right=new TreeNode(2,new TreeNode(3),null);
        TreeNode root=new TreeNode(1,null,right);
        System.out.println(code.inorderTraversal(root));
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res=new ArrayList<>();
        traverByNotRecursion(root,res);
        return res;
    }
    //递归遍历
    private void traverByRecursion(TreeNode root, List<Integer> list) {
        if(root==null) {
            return;
        }
        this.traverByRecursion(root.left,list);
        list.add(root.val);
        this.traverByRecursion(root.right,list);
    }
    //非递归遍历
    private void traverByNotRecursion(TreeNode root, List<Integer> list) {
        if(root==null){
            return ;
        }
        //使用stack模拟计算机栈
        List<TreeNode> stack=new ArrayList<>();
        while(!stack.isEmpty()||root!=null){
            if(root!=null){
                stack.add(root);
                root=root.left;
            }else{
                root=stack.remove(stack.size()-1);
                list.add(root.val);
                root=root.right;
            }
        }
    }
}
