public class FindPeakElement {
    public static void main(String[] args) {
        FindPeakElement f=new FindPeakElement();
        f.findPeakElement(new int[]{1,6,5,4,3,2,1});
    }
    public int findPeakElement(int[] nums) {
        int mid,s=0,e=nums.length-1;
        while(s<e) {
            mid=(s+e)/2;
            if(isMost(nums,mid)){
                return mid;
            }
            if(nums[mid]<nums[mid+1]){
                s=mid+1;
            }else {
                e=mid-1;
            }
        }
        return e;
    }
    public boolean isMost(int[] nums,int mid){
        if((mid-1<0||nums[mid]>nums[mid-1])&&(mid+1>=nums.length||nums[mid]>nums[mid+1])){
            return true;
        }else{
            return false;
        }
    }
}
