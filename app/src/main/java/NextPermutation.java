import java.util.Arrays;
import java.util.Scanner;

/**
 * 31. 下一个排列
 * 执行结果： 通过
 * 显示详情
 * 执行用时：1 ms ,在所有 Java 提交中击败了98.26%的用户
 * 内存消耗：38.2 MB, 在所有 Java 提交中击败了98.85%的用户
 */
public class NextPermutation {
    public static void main(String[] args)throws Exception {
        NextPermutation code=new NextPermutation();
        Scanner sc = new Scanner(System.in);
        while(true) {
            String l = sc.nextLine();
            String[] str=l.split(",");
            int[] a=new int[str.length];
            for(int i=0;i<str.length;i++){
                a[i]=Integer.valueOf(str[i]);
            }
            while(true) {
                code.nextPermutation(a);
                Arrays.stream(a).forEach(System.out::print);
                System.out.println();
            }
        }
    }
    public void nextPermutation(int[] nums) {
        if(nums.length==1){
            return;
        }
        if(nums.length==2){
            swap(nums,0,1);
            return ;
        }

        int i=1;
        while(i<nums.length){
            if(nums[i-1]<nums[i]){
                break;
            }
            i++;
        }
        if(i==nums.length){
            for(int j=0;j<nums.length/2;j++){
                swap(nums,j,nums.length-1-j);
            }
            return;
        }
        i=nums.length-1;
        //首先找到序列的分界点
        while(i>=1){
            if(nums[i-1]>=nums[i]){
                i--;
            }else{
                break;
            }
        }
        if(i==nums.length-1){
            swap(nums,i-1,i);
            return;
        }
        if(nums[i-1]<nums[nums.length-1]) {
            swap(nums, i - 1, nums.length - 1);
            for(int k=i;k<(nums.length-i)/2+i;k++){
                swap(nums, k, nums.length-1-(k-i));
            }
        }else if(nums[i-1]>=nums[nums.length-1]){
            int j;
            for( j= nums.length-1;j>=0;j--){
                if(nums[j]>nums[i-1]){
                    break;
                }
            }
            swap(nums, i - 1, j);
            for(int k=i;k<(nums.length-i)/2+i;k++){
                swap(nums, k, nums.length-1-(k-i));
            }
        }
    }
    public void swap(int[] nums,int i,int j){
        int t=nums[i];
        nums[i]=nums[j];
        nums[j]=t;
    }
}
