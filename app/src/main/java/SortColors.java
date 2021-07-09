public class SortColors {
	public static void main(String argc[]){
		SortColors s=new SortColors();
		s.sortColors(new int[]{2,0,2,1,1,0});
	}
    public void sortColors(int[] nums) {
    	int[] a=new int[3];
    	for(int i=0;i<nums.length;i++){
    		a[nums[i]]++;
    	}
    	int i=0;
    	for(int j=0;j<=2;j++){
	    	while(a[j]!=0){
	    		nums[i++]=j;
	    		a[j]--;
	    	}
    	}
    
    }
}
