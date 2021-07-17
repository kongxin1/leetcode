public class MaxSubArray {
    public int maxSubArray(int[] nums) {
        int sum=nums[0],pre=nums[0];
        for(int i=1;i<nums.length;i++){
            if(pre+nums[i]>nums[i]){
                pre+=nums[i];
            }else{
                pre=nums[i];
            }
            if(sum<pre){
                sum=pre;
            }
        }
        return sum;
    }
}
