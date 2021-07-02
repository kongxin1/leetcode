public class CanJump {
    public static void main(String argv[]){
        CanJump c=new CanJump();
        int[] nums=new int[]{};
        System.out.println(c.canJump(nums));
    }

    public boolean canJump(int[] nums) {
        if(nums.length==1){
            return true;
        }
        int max=0;
        for(int i=0;i<nums.length;i++){
            if(max<i){
                return false;
            }
            if(max<i+nums[i]){
                max=i+nums[i];
                if(max>= nums.length-1){
                    return true;
                }
            }

        }
        return false;
    }
}
