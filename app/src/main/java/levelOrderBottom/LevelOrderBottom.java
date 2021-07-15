package levelOrderBottom;

import java.util.*;

public class LevelOrderBottom {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> q[] = new LinkedList[2];
        q[0]=new LinkedList();
        q[1]=new LinkedList();

        int i = 0;
        q[0].add(root);

        while (!q[i].isEmpty()) {
            List<Integer> t = new ArrayList<>();
            int ni=(i + 1) & 1;
            while(!q[i].isEmpty()){
                TreeNode node=q[i].poll();
                t.add(node.val);
                if(node.left!=null){
                    q[ni].add(node.left);
                }
                if(node.right!=null){
                    q[ni].add(node.right);
                }
            }
            res.add(t);
            i = ni;
        }
        Collections.reverse(res);
        return res;
    }
}
