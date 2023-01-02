package expandBinaryTree;
public class ExpandBinaryTree {
    public TreeNode expandBinaryTree(TreeNode root) {
        process(root);
        return root;
    }
    public void process(TreeNode root){
        if(root!=null){
            if(root.left!=null){
                TreeNode t=new TreeNode(-1);
                TreeNode left=root.left;
                root.left=t;
                t.left=left;
                process(left);
            }
            if(root.right!=null){
                TreeNode t=new TreeNode(-1);
                TreeNode right=root.right;
                root.right=t;
                t.right=right;
                process(right);
            }
        }
    }
}
