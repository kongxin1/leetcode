public class LengthOfLIS {
    public static void main(String[] args) {
        LengthOfLIS l =new LengthOfLIS();
        l.lengthOfLIS(new int[]{10,9,2,5,3,7,101,18});
    }
    public int lengthOfLIS(int[] nums) {
        int[] cnt=new int[nums.length];
        cnt[0]=1;
        int max=1;
        for(int i=1;i<nums.length;i++){
            cnt[i]=1;
            for(int j=i-1;j>=0;j--){
                if(nums[j]<nums[i]&&cnt[i]<cnt[j]+1){
                    cnt[i]=cnt[j]+1;
                }
            }
            if(max<cnt[i]){
                max=cnt[i];
            }
        }
        return max;
    }
}
