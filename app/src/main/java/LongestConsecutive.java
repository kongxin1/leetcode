import java.util.*;

public class LongestConsecutive {
    public int longestConsecutive(int[] nums) {
        Map<Integer,Integer> cnt=new HashMap();
        Integer one=1;
        for(int i=0;i<nums.length;i++){
            cnt.put(nums[i], one);
        }
        int max=0;
        for(int i=0;i<nums.length;i++){
            if(cnt.get(nums[i])!=null){
                int t=nums[i]+1, c=1;
                while(cnt.get(t)!=null){
                    c=c+cnt.get(t);
                    cnt.remove(t);
                    t++;
                }
                if(c!=1){
                    cnt.put(nums[i], c);
                }
                if(max<c){
                    max=c;
                }
            }

        }
        return max;
    }
}
