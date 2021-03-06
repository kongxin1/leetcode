import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * 39. 组合总和
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的数字可以无限制重复被选取。
 *
 * 说明：

 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。
 * 示例 1：
 *
 * 输入：candidates = [2,3,6,7], target = 7,
 * 所求解集为：
 * [
 *   [7],
 *   [2,2,3]
 * ]
 * 示例 2：
 *
 * 输入：candidates = [2,3,5], target = 8,
 * 所求解集为：
 * [
 *   [2,2,2,2],
 *   [2,3,3],
 *   [3,5]
 * ]
 *
 * 提示：
 *
 * 1 <= candidates.length <= 30
 * 1 <= candidates[i] <= 200
 * candidate 中的每个元素都是独一无二的。
 * 1 <= target <= 500
 */
public class CombinationSum {
    public static void main(String[] args)throws Exception {
        CombinationSum code=new CombinationSum();
        Scanner sc = new Scanner(System.in);
        while(true) {
            String line = sc.nextLine();
            String[] s=line.split(" ");
            String[] str=s[0].split(",");
            int[] candidates=new int[str.length];

            for(int i=0;i<candidates.length;i++){
                candidates[i]=Integer.valueOf(str[i]);
            }
            int target=Integer.valueOf(s[1]);
            System.out.println(code.combinationSum(candidates,target));
        }
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res=new ArrayList<List<Integer>>();
        if(candidates.length==0){
            return res;
        }
        Arrays.sort(candidates);
        if(candidates[0]>target){
            return res;
        }
        recursion(0,res,target,candidates,0,new ArrayList<>());
        return res;
    }
    private void recursion(int n,List<List<Integer>> res,int target,int[] candidates,int sum,List<Integer> list){
        if(sum>target){
            return;
        }
        for(int i=n;i< candidates.length;i++){
            int e= candidates[i];
            if(sum+e>target){
                return;
            }
            list.add(e);
            if(sum+e==target){
                List<Integer> t=new ArrayList<>();
                for(Integer j:list){
                    t.add(j);
                }
                res.add(t);
            }else{
                recursion(i,res,target,candidates,sum+e,list);
            }
            list.remove(list.size()-1);
        }
    }
}
