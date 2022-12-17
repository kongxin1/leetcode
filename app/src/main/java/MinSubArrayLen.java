public class MinSubArrayLen {
    public static void main(String[] args) {
        MinSubArrayLen m=new MinSubArrayLen();
        m.minSubArrayLen(6,new int[]{10,2,3});
    }
    public int minSubArrayLen(int target, int[] nums) {
        int i=0,j=0;
        int res=Integer.MAX_VALUE,sum=0;
        if(nums.length==1&&target<=nums[0]){
            return 1;
        }
        sum=nums[i];
        while(j<nums.length){
            if(sum>=target){
                if(res>(j-i+1)){
                    res=j-i+1;
                }
                sum-=nums[i];
                i++;
                if(i-1==j){
                    j=i;
                }
            }else{
                j++;
                if(j<nums.length) {
                    sum += nums[j];
                }
            }
        }
        if(res==Integer.MAX_VALUE){
            return 0;
        }
        return res;
    }
}
