import java.util.Arrays;
import java.util.Scanner;

public class Search {
    public static void main(String[] args)throws Exception {
        Search code=new Search();
        Scanner sc = new Scanner(System.in);
        while(true) {
            String l = sc.nextLine();
            String a[]=l.split(",");
            int i[]= Arrays.stream(a).mapToInt(x->Integer.valueOf(x)).toArray();
            String s = sc.nextLine();
            System.out.println(code.search(i,Integer.valueOf(s)));
        }
    }
    public int search(int[] nums, int target) {
        if(nums.length==0){
            return -1;
        }
        for(int i=0;i<nums.length;i++){
            if(nums[i]==target){
                return i;
            }
        }
        return -1;
    }
}
