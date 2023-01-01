package rightSideView;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        int length=1;
        List<Integer> res=new ArrayList<>();
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        while(queue.size()!=0){
            while(length>0){
                length--;
                TreeNode t=queue.poll();
                if(t==null){
                    continue;
                }
                if(t.left!=null){
                    queue.add(t.left);
                }
                if(t.right!=null){
                    queue.add(t.right);
                }
                if(length==0){
                    res.add(t.val);
                }
            }
            length=queue.size();
        }
        return res;
    }
}
