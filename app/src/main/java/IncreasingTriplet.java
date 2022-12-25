public class IncreasingTriplet {
    public static void main(String[] args) {
        IncreasingTriplet i=new IncreasingTriplet();
        i.increasingTriplet(new int[]{20,100,10,12,5,13});
    }
    public boolean increasingTriplet(int[] nums) {
        if(nums.length<3){
            return false;
        }
        boolean[] flag=new boolean[nums.length];
        for(int i=1;i<nums.length;i++){
            for(int j=i-1;j>=0;j--){
                if(nums[i]>nums[j]){
                    if(flag[j]) {
                        return true;
                    }else{
                        flag[i]=true;
                    }
                }else if(nums[i]==nums[j]){
                    break;
                }
            }
        }
        return false;
    }
}
