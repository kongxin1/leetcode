import java.lang.reflect.Array;
import java.util.*;

public class Subsets {
    public static void main(String[] args)throws Exception {
        Subsets code=new Subsets();
        int[] s=new int[]{1,2,3};
        System.out.println(code.subsets(s));
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        res.add(new ArrayList<>());
        if(nums.length==0){
            return res;
        }
        int r=1<< nums.length;
        for(int i=1;i<r;i++){
            res.add(recursion(i,nums));
        }
        return res;
    }
    public List<Integer> recursion(int i,int[] nums){
        int t=i;
        List<Integer> l=new ArrayList<>();
        for(int j=0;j<nums.length;j++){
            if((t&1)==1){
                l.add(nums[j]);
            }
            t=t>>1;
        }
        return l;
    }
}
