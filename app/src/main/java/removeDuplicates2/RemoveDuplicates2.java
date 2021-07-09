package removeDuplicates2;

public class RemoveDuplicates2 {
	public static void main(String argv[]){
		RemoveDuplicates2 m=new RemoveDuplicates2();
		m.removeDuplicates(new int[]{1,1,1,2,2,3});
	}
    public int removeDuplicates(int[] nums) {
    	int s=0;
    	int cnt=1;
    	for(int i=1;i<nums.length;i++){
    		if(nums[s]!=nums[i]){
    			nums[++s]=nums[i];
    			cnt=1;
    		}else{
    			if(cnt==2){
    				continue;
    			}
    			cnt++;
    			nums[++s]=nums[i];
    		}
    	}
    	s++;
    	return s;
    }
}
