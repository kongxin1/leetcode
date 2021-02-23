import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * 525. 连续数组
 * 执行结果：通过 显示详情
 * 执行用时： 7 ms , 在所有 Java 提交中击败了 99.24% 的用户
 * 内存消耗： 47.3 MB , 在所有 Java 提交中击败了 89.25% 的用户
 */
public class FindMaxLength {
    public static void main(String[] args)throws Exception {
        FindMaxLength code=new FindMaxLength();
        Scanner sc = new Scanner(System.in);
        while(true) {
            String line = sc.nextLine();
            String[] s=line.split(",");
            Integer[] numt=Arrays.stream(s).map(x->(Integer.valueOf(x))).toArray(Integer[]::new);
            int[] nums=new int[numt.length];
            for(int i=0;i<numt.length;i++){
                nums[i]=numt[i];
            }
            System.out.println(code.findMaxLength(nums));
        }
    }
    public int findMaxLength(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        int length=nums.length;
        int pos[]=new int[length*2+1];
        int max=0;
        int s=1;
        if(nums[0]==0){
            s=-1;
        }
        pos[length+s]=1;
        for(int i=1;i<nums.length;i++){
            if(nums[i]==0){
                s--;
            }else{
                s++;
            }
            if(s==0){
                max=i+1;
            }else {
                if (pos[length + s] != 0) {
                    if(i-pos[length+s]>max){
                        max=i-pos[length+s]+1;
                    }
                }else{
                    pos[length + s]=i+1;
                }
            }
        }
        return max;
    }
}
