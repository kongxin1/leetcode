package deepestLeavesSum;

import java.util.LinkedList;
import java.util.Queue;

public class DeepestLeavesSum {
    public int deepestLeavesSum(TreeNode root) {
        Queue<TreeNode> q=new LinkedList<>();
        if(root==null){
            return 0;
        }
        int sum=0;
        q.add(root);
        int length=1;
        while(!q.isEmpty()){
            sum=0;
            for(int i=0;i<length;i++){
                TreeNode t=q.poll();
                sum+=t.val;
                if(t.left!=null){
                    q.add(t.left);
                }
                if(t.right!=null){
                    q.add(t.right);
                }
            }
            length=q.size();
        }
        return sum;
    }
}
