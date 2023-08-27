/**
 * 功能描述
 *
 * @author: 孔新
 * @date: 2023年08月27日 12:15
 */
public class FindMaxAverage {
    public static void main(String[] args) {
        FindMaxAverage FindMaxAverage=new FindMaxAverage();
        System.out.println(FindMaxAverage.findMaxAverage(new int[]{1,12,-5,-6,50,3},4));
    }
    public double findMaxAverage(int[] nums, int k) {
        int max=0;
        for(int i=0;i<k;i++){
            max+=nums[i];
        }
        int t=max;
        for(int i=k;i< nums.length;i++){
            t=t-nums[i-k]+nums[i];
            if(max<t){
                max=t;
            }
        }
        return max*1.0/k;
    }
}
