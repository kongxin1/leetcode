public class MajorityElement {
	public static void main(String argv[]){
		MajorityElement m=new MajorityElement();
		m.majorityElement(new int[]{3,2});
	}
    public int majorityElement(int[] nums) {
    	int cnt=1,e=nums[0];
    	for(int i=1;i<nums.length;i++){
    		if(cnt==0){
    			e=nums[i];
    			cnt=1;
    			continue;
    		}
    		if(nums[i]==e){
    			cnt++;
    		}else{
    			cnt--;
    		}
    	}
    	if(cnt==0){
    		return -1;
    	}
    	cnt=0;
    	for(int i=0;i<nums.length;i++){
    		if(e==nums[i]){
    			cnt++;
    		}
    	}
    	if(cnt>nums.length/2){
    		return e;
    	}else{
    		return -1;
    	}
    }

}
