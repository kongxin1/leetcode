package canMerge;

import java.util.*;

public class CanMerge {
    public static void main(String argv[]){
//        TreeNode left1=new TreeNode(1);
//        TreeNode root1=new TreeNode(2,left1,null);

        TreeNode left2=new TreeNode(3);
        TreeNode right1=new TreeNode(8);
        TreeNode root2=new TreeNode(5,left2,right1);

        TreeNode left3=new TreeNode(2);
        TreeNode right3=new TreeNode(6);
        TreeNode root3=new TreeNode(3,left3,right3);

//        TreeNode left3=new TreeNode(4);
//        TreeNode root3=new TreeNode(5,left3,null);

        CanMerge c=new CanMerge();
        List<TreeNode> trees=new ArrayList<>();
        trees.add(root2);trees.add(root3);
        c.canMerge(trees);
    }
    public TreeNode canMerge(List<TreeNode> trees) {
        int len=trees.size();
        if(len==1){
            return trees.get(0);
        }
        TreeNode root=getRoot(trees,len);
        if(root==null){
            return root;
        }
        Map<Integer,TreeNode> map=new HashMap();
        for(int i=0;i<len;i++){
            TreeNode node=trees.get(i);
            map.put(node.val,node);
        }
        map.remove(root.val);
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        while(true){
            if(map.size()==0){
                break;
            }
            if(queue.size()==0){
                return null;
            }
            //从队列头取一个节点
            TreeNode node=queue.poll();
            if(node.left!=null){
                Integer val=node.left.val;
                TreeNode t=map.get(val);
                if(t!=null){
                    node.left=t;
                    queue.add(t);
                    map.remove(val);
                }
            }
            if(node.right!=null){
                Integer val=node.right.val;
                TreeNode t=map.get(val);
                if(t!=null){
                    node.right=t;
                    queue.add(t);
                    map.remove(val);
                }
            }
        }
        if(checkIsTree(root)){
            return root;
        }else{
            return null;
        }
    }
    public TreeNode getRoot(List<TreeNode> trees,int len){
        Map<Integer,TreeNode> map=new HashMap();
        for(int i=0;i<len;i++){
            TreeNode node=trees.get(i);
            map.put(node.val,node);
        }
        for(int i=0;i<len;i++){
            TreeNode node=trees.get(i);
            if(node.left!=null){
                int v=node.left.val;
                if(map.get(v)!=null){
                    map.remove(v);
                }
            }
            if(node.right!=null){
                int v=node.right.val;
                if(map.get(v)!=null){
                    map.remove(v);
                }
            }
        }
        if(map.size()!=1){
            return null;
        }else{
            Iterator<TreeNode> i=map.values().iterator();
            return i.next();
        }
    }
    public boolean checkIsTree(TreeNode root){
        int[] left=null,right=null;
        if(root.left!=null) {
            left = travel(root.left, true);
            if(left==null){
                return false;
            }
        }

        if(root.right!=null) {
            right = travel(root.right, false);
            if(right==null){
                return false;
            }
        }

        int val=root.val;

        if((left==null||left[1]<val)&&(right==null||right[0]>val)){
            return true;
        }else{
            return false;
        }
    }
    public int[] travel(TreeNode root,boolean lorr){
        if(root.left==null&&root.right==null){
            return new int[]{root.val,root.val};
        }
        int[] left=null,right=null;
        if(root.left!=null){
            left=travel(root.left,true);
            if(left==null){
                return null;
            }
        }

        if(root.right!=null){
            right=travel(root.right,false);
            if(right==null){
                return null;
            }
        }

        if((left==null||left[1]<root.val)&&(right==null||right[0]>root.val)){
            if(left!=null&&right!=null) {
                return new int[]{left[0], right[1]};
            }else if(left==null){
                return new int[]{root.val, right[1]};
            }else{
                return new int[]{left[0], root.val};
            }
        }else{
            return null;
        }
    }
}

