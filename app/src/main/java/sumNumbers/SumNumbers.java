package sumNumbers;

public class SumNumbers {
    public static void main(String[] args){

    }
    public int sumNumbers(TreeNode root) {
        if(root==null){
            return 0;
        }
        return recur(0,root,0);
    }
    public int recur(int sum,TreeNode root,int mid){
        if(root.left==null&&root.right==null){
            return mid*10+ root.val;
        }else{
            int s1=0,s2=0;
            if(root.left!=null){
                s1=recur(sum,root.left,mid*10+root.val);
            }
            if(root.right!=null){
                s2=recur(sum,root.right,mid*10+root.val);
            }
            return s1+s2;
        }
    }
}
