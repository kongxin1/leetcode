public class Rob {
    public static void main(String[] args) {
        Rob r=new Rob();
        r.rob(new int[]{1,3,1});
    }
    public int rob(int[] nums) {
        if(nums.length==1){
            return nums[0];
        }
        if(nums.length==2){
            return nums[0]>nums[1]?nums[0]:nums[1];
        }
        int res=nums[0]>nums[1]?nums[0]:nums[1];
        for(int i=2;i<nums.length;i++){
            if(res<nums[i]+nums[i-2]){
                res=nums[i]+nums[i-2];
            }
            if(i-3>=0&&nums[i]+nums[i-3]>res){
                res=nums[i]+nums[i-3];
            }
            nums[i]=res;
        }
        return res;
    }
}
