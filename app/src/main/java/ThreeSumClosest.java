import java.util.Arrays;

public class ThreeSumClosest {
    public static void main(String arg[]){
        ThreeSumClosest t=new ThreeSumClosest();
        int[] nums=new int[]{0,-1,1,0};
        int target=1;
        System.out.print(t.threeSumClosest(nums,target));
    }
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int min=100000000;
        for(int i=0;i< nums.length-2;i++){
            int j=i+1,k=nums.length-1;
            int sum=0;
            while(j<k){
                sum=nums[i]+nums[j]+nums[k];
                if(Math.abs(sum-target)<Math.abs(min-target)){
                    min=sum;
                }
                if(sum>target){
                    k--;
                }else if(sum<target){
                    j++;
                }else{
                    return target;
                }
            }
        }
        return min;
    }
}
