public class LongestOnes {
    public static void main(String[] args) {
        LongestOnes l=new LongestOnes();
        System.out.print(l.longestOnes(new int[]{0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1},3));
    }
    public int longestOnes(int[] nums, int k) {
        if(nums.length==k){
            return k;
        }
        int s=0,e;
        int t=0,max;
        for(e=0;t<k&&e<nums.length;e++){
            if(nums[e]==0){
                t++;
            }
        }
        max=e-s;
        while(e<nums.length){
            if(nums[e]==1){
                e++;
            }else{
                while(s<nums.length&&nums[s]==1){
                    s++;
                }
                s++;e++;
            }
            if(e<=nums.length){
                max=Integer.max(max,e-s);
            }
        }
        return max;
    }
}
