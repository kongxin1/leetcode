import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

public class TwoSum {
    public static void main(String[] args){
        TwoSum t=new TwoSum();
        t.twoSum(new int[]{3,2,4},6);
    }
    public int[] twoSum(int[] nums, int target) {
        int res[]=new int[2];
        int t[]=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            t[i]=nums[i];
        }
        Arrays.sort(t);
        for(int i=0;i< nums.length;i++){
            int s=target-nums[i];
            int index=Arrays.binarySearch(t,s);
            if(index>=0){
                res[0]=i;
                for(int j=0;j<nums.length;j++){
                    if(nums[j]==s&&j!=i){
                        res[1]=j;
                        return res;
                    }
                }
            }
        }
        return res;
    }
}
