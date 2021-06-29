import java.util.Arrays;
import java.util.Scanner;

public class Jump {
    public static void main(String[] args)throws Exception {
        Jump code=new Jump();
        Scanner sc = new Scanner(System.in);
        while(true) {
            String l = sc.nextLine();
            String a[]=l.split(",");
            int i[]= Arrays.stream(a).mapToInt(x->Integer.valueOf(x)).toArray();

            System.out.println(code.jump(i));
        }
    }
    public int jump(int[] nums) {
        int jump[]=new int[nums.length];
        for(int i=1;i<nums.length;i++){
            jump[i]=100000;
        }
        int max=0;
        for(int i=0;i<nums.length;i++){
            int j=nums[i];
            for(int k=i+1;k<nums.length&&k<=i+j;k++){
                if(jump[k]>jump[i]+1){
                    jump[k]=jump[i]+1;
                }
            }
        }
        return jump[nums.length-1];
    }
}
