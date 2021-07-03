import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
    public static void main(String arg[]){
        FourSum f=new FourSum();
        int[] nums=new int[]{1,0,-1,0,-2,2};
        int target=0;
        f.fourSum(nums,target).stream().forEach(System.out::print);
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res=new ArrayList<>();
        if(nums.length<=3){
            return res;
        }
        Arrays.sort(nums);
        for(int i=0;i<nums.length-3;i++){
            if(i!=0&&nums[i-1]==nums[i]){
                continue;
            }
            if((long)nums[i]+nums[i+1]+nums[i+2]+nums[i+3]>target){
                return res;
            }
            for(int j=i+1;j<nums.length-2;j++){

                if(j-1!=i&&nums[j-1]==nums[j]){
                    continue;
                }
                int k=j+1,l=nums.length-1;
                while(k<l) {
                    long sum = (long) nums[i] + nums[j] + nums[k] + nums[l];
                    if (sum == target) {
                        List<Integer> t = new ArrayList<>(4);
                        t.add(nums[i]);
                        t.add(nums[j]);
                        t.add(nums[k]);
                        t.add(nums[l]);
                        res.add(t);
                        k++;l--;
                        while(k<l&&nums[l]==nums[l+1]) {
                            l--;
                        }
                        while(k<l&&nums[k]==nums[k-1]) {
                            k++;
                        }
                    } else if (sum > target) {
                        l--;
                        while(k<l&&nums[l]==nums[l+1]) {
                            l--;
                        }
                    }else{
                        k++;
                        while(k<l&&nums[k]==nums[k-1]) {
                            k++;
                        }
                    }
                }
            }
        }
        return res;
    }
}
