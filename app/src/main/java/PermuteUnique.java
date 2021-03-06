import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * 47. 全排列 II
 * 执行结果：通过
 * 显示详情
 * 执行用时：1 ms, 在所有 Java 提交中击败了100.00%的用户
 * 内存消耗：38.9 MB, 在所有 Java 提交中击败了93.16%的用户
 */
public class PermuteUnique {
    public static void main(String[] args)throws Exception {
        PermuteUnique code=new PermuteUnique();
        Scanner sc = new Scanner(System.in);
        while(true) {
            String l = sc.nextLine();
            String[] str=l.split(",");
            int[] a=new int[str.length];
            for(int i=0;i<str.length;i++){
                a[i]=Integer.valueOf(str[i]);
            }
            code.permuteUnique(a).forEach(System.out::println);
        }
    }
    public List<List<Integer>> permuteUnique(int[] nums) {
        int[] p=new int[nums.length];
        List<List<Integer>> res=new ArrayList<>();
        Arrays.sort(nums);
        process(nums,res,new int[nums.length],p,0);
        return res;
    }
    public void process(int[] nums,List<List<Integer>> res,int[] entry,int[] p,int length){
        int pre=-100;
        for(int i=0;i<nums.length;i++){
            if(p[i]==0&&pre!=nums[i]){
                entry[length]=nums[i];
                if(length+1== nums.length){
                    List<Integer> list=new ArrayList<Integer>(nums.length);
                    for(int t:entry){
                        list.add(t);
                    }
                    res.add(list);
                    return;
                }
                p[i]=1;
                process(nums,res,entry,p,length+1);
                p[i]=0;
                pre=nums[i];
            }
        }
    }
}
