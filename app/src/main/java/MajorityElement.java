import java.util.Arrays;
import java.util.Scanner;

/**
 * 面试题 17.10. 主要元素
 * 数组中占比超过一半的元素称之为主要元素。给定一个整数数组，找到它的主要元素。若没有，返回-1。
 * 执行结果：通过
 * 显示详情
 * 执行用时：1 ms, 在所有 Java 提交中击败了100.00%的用户
 * 内存消耗：41.8 MB, 在所有 Java 提交中击败了44.59%的用户
 */
public class MajorityElement {
    public static void main(String[] args)throws Exception {
        MajorityElement code=new MajorityElement();
        Scanner sc = new Scanner(System.in);
        while(true) {
            String l = sc.nextLine();
            String[] a=l.split(",");
            int[] i=new int[a.length];
            Integer[] in=Arrays.stream(a).map(x->Integer.valueOf(x)).toArray(Integer[]::new);

            for(int t=0;t<i.length;t++){
                i[t]=in[t];
            }
            System.out.println(code.majorityElement(i));
        }
    }
    public int majorityElement(int[] nums) {
        if(nums.length==0){
            return -1;
        }
        if(nums.length==1){
            return nums[0];
        }
        int res=nums[0];
        int cnt=1;
        for(int i=1;i< nums.length;i++){
            if(res==nums[i]){
                cnt++;
            }else{
                if(cnt==0){
                    res=nums[i];
                    cnt++;
                }else{
                    cnt--;
                }
            }
        }
        cnt=0;
        for(int i=0;i< nums.length;i++){
            if(res==nums[i]){
                cnt++;
            }
        }
        if(cnt>nums.length/2){
            return res;
        }else{
            return -1;
        }
    }
}
