package postorderTraversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 145. 二叉树的后序遍历
 * 给你二叉树的根节点 root ，返回它节点值的 后序 遍历。
 * 执行结果：通过
 * 显示详情 1 ms, 在所有 Java 提交中击败了52.76%的用户
 * 内存消耗：36.6 MB, 在所有 Java 提交中击败了70.49%的用户
 * 提供了递归遍历版本和非递归遍历版本
 */
public class PostorderTraversal {
    public static void main(String[] args)throws Exception {
        PostorderTraversal code=new PostorderTraversal();
        TreeNode right=new TreeNode(2,new TreeNode(3),null);
        TreeNode root=new TreeNode(1,null,right);
        System.out.println(code.postorderTraversal(root));
    }
    public List<Integer> postorderTraversal(TreeNode root) {
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
        this.traverByRecursion(root.right,list);
        list.add(root.val);
    }
    //非递归遍历
    private void traverByNotRecursion(TreeNode root, List<Integer> list) {
        if(root==null){
            return ;
        }
        //使用stack模拟计算机栈
        List<TreeNode> stack=new ArrayList<>();
        TreeNode lastNode=null;//记录最后一次访问的节点
        while(!stack.isEmpty()||root!=null){
            while(root!=null){
                stack.add(root);
                root=root.left;
            }
            root=stack.get(stack.size()-1);//取栈顶元素
            if(root.right==null||root.right==lastNode){
                stack.remove(stack.size()-1);
                list.add(root.val);
                lastNode=root;
                root=null;
            }else{
                root=root.right;
            }
        }
    }
}
