package removeDuplicates;

public class RemoveDuplicates {
	public static void main(String argv[]){
		RemoveDuplicates m=new RemoveDuplicates();
		m.removeDuplicates(new int[]{1,1,2});
	}
    public int removeDuplicates(int[] nums) {
    	int s=0;
    	for(int i=1;i<nums.length;i++){
    		if(nums[s]!=nums[i]){
    			nums[++s]=nums[i];
    		}
    	}
    	s++;
    	return s;
    }
}
