import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * 40. 组合总和 II
 * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的每个数字在每个组合中只能使用一次。
 *
 * 说明：
 *
 * 所有数字（包括目标数）都是正整数。
 * 解集不能包含重复的组合。
 * 示例 1:
 *
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 所求解集为:
 * [
 *   [1, 7],
 *   [1, 2, 5],
 *   [2, 6],
 *   [1, 1, 6]
 * ]
 * 示例 2:
 *
 * 输入: candidates = [2,5,2,1,2], target = 5,
 * 所求解集为:
 * [
 *   [1,2,2],
 *   [5]
 * ]
 *
 *
 * 执行结果：
 * 通过
 * 执行用时： * 2 ms, 在所有 Java 提交中击败了99.91%的用户
 * 内存消耗：38.8 MB, 在所有 Java 提交中击败了35.98%的用户
 */
public class CombinationSum2 {
    public static void main(String[] args)throws Exception {
        CombinationSum2 code=new CombinationSum2();
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
            System.out.println(code.combinationSum2(candidates,target));
        }
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
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
            if(i!=n&&e==candidates[i-1]){
                continue;
            }
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
                recursion(i+1,res,target,candidates,sum+e,list);
            }
            list.remove(list.size()-1);
        }
    }
}
