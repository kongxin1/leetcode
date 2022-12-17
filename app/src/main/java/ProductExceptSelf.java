public class ProductExceptSelf {
    public static void main(String[] args) {
        ProductExceptSelf p=new ProductExceptSelf();
        p.productExceptSelf(new int[]{-1,1,0,-3,3});
    }
    public int[] productExceptSelf(int[] nums) {
        int ans1[]=new int[nums.length];
        int ans2[]=new int[nums.length];
        ans1[0]=nums[0];
        for(int i=1;i<nums.length;i++){
            ans1[i]=nums[i]*ans1[i-1];
        }
        ans2[nums.length-1]=nums[nums.length-1];
        for(int i=nums.length-2;i>=0;i--){
            ans2[i]=nums[i]*ans2[i+1];
        }
        int[] res=new int[nums.length];
        res[0]=ans2[1];
        res[nums.length-1]=ans1[nums.length-2];
        for(int i=1;i<nums.length-1;i++){
            res[i]=ans1[i-1]*ans2[i+1];
        }
        return res;
    }
}
