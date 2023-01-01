public class FindDuplicate {
    public static void main(String[] args) {
        FindDuplicate p=new FindDuplicate();
        p.findDuplicate(new int[]{1,3,4,2,2});
    }
    public int findDuplicate(int[] nums) {
        int[] t=new int[100001];
        for(int i=0;i<nums.length;i++){
            if(t[nums[i]]!=0){
                return nums[i];
            }else{
                t[nums[i]]=1;
            }
        }
        return -1;
    }
}
