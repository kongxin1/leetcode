import java.util.Arrays;
import java.util.Scanner;

public class SearchRange {
    public static void main(String[] args)throws Exception {
        SearchRange code=new SearchRange();
        Scanner sc = new Scanner(System.in);
        while(true) {
            String l = sc.nextLine();
            String a[]=l.split(",");
            int i[]= Arrays.stream(a).mapToInt(x->Integer.valueOf(x)).toArray();
            String s = sc.nextLine();
            System.out.println(code.searchRange(i,Integer.valueOf(s)));
        }
    }
    public int[] searchRange(int[] nums, int target) {
        int s=0,e=nums.length;
        if(nums.length==0){
            return new int[]{-1,-1};
        }
        int m=-1;
        while(s<e){
            m=(s+e)/2;
            if(nums[m]>=target){
                e=m;
            }
            else{
                s=m+1;
            }
        }
        m=s;
        if(m>=nums.length||nums[m]!=target){
            return  new int[]{-1,-1};
        }else{
            for(int i=m;i<nums.length;i++){
                if(nums[i]!=target){
                    return new int[]{m,i-1};
                }
                if(i==nums.length-1){
                    return new int[]{m,i};
                }
            }
        }
        return  new int[]{-1,-1};
    }
}
