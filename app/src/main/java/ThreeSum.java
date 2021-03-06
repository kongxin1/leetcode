import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * 15. 三数之和
 * 执行结果：通过
 * 显示详情
 * 执行用时：29 ms, 在所有 Java 提交中击败了31.83%的用户
 * 内存消耗：42.3 MB, 在所有 Java 提交中击败了72.18%的用户
 */
public class ThreeSum {
    public static void main(String[] args)throws Exception {
        ThreeSum code=new ThreeSum();
        Scanner sc = new Scanner(System.in);
        while(true) {
            String l = sc.nextLine();
            String[] str=l.split(",");
            int[] a=new int[str.length];
            for(int i=0;i<str.length;i++){
                a[i]=Integer.valueOf(str[i]);
            }
            System.out.println(code.threeSum(a));
        }
    }
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        if(nums.length<=2){
            return res;
        }
        Arrays.sort(nums);
        if(nums[0]>0||nums[nums.length-1]<0){
            return res;
        }
        for(int i=0;i<=nums.length-3;i++){
            if(nums[i]>0){
                return res;
            }
            if(i!=0&&nums[i-1]==nums[i]){
                continue;
            }
            int j=i+1,k= nums.length-1;
            while(j<k) {
                int s=nums[i] + nums[j] + nums[k];
                if (s == 0) {
                    List<Integer> t=new ArrayList<>();
                    t.add(nums[i]);
                    t.add(nums[j]);
                    t.add(nums[k]);
                    res.add(t);
                    j++;k--;
                    while(j<k&&nums[j]==nums[j-1]){
                        j++;
                    }
                    while(k<nums.length-1&&nums[k]==nums[k+1]&&j<k){
                        k--;
                    }

                }else if(s>0){
                    k--;
                    while(k<nums.length-1&&nums[k]==nums[k+1]&&j<k){
                        k--;
                    }
                }else{
                    j++;
                    while(j<k&&nums[j]==nums[j-1]){
                        j++;
                    }
                }
            }
        }
        return res;
    }
}
