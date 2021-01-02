import java.util.Scanner;

public class Divide {
    public static void main(String[] args)throws Exception {
        Divide code=new Divide();
        Scanner sc = new Scanner(System.in);
        while(true) {
            String i = sc.nextLine();
            String[] s=i.split(",");
            System.out.println(code.divide(Integer.valueOf(s[0]),Integer.valueOf(s[1])));
        }
    }
    public int divide(int dividend, int divisor) {
        if(dividend==0){
            return 0;
        }
        long res=0;
        long tdivisor=divisor;
        while(true){
            if(dividend<0&&divisor<0&&dividend<=tdivisor){
                res++;
            }else if(dividend>0&&divisor>0&&dividend>=tdivisor){
                res++;
            }else if(dividend>0&&divisor<0&&(-dividend)<=tdivisor){
                res--;
            }else if(dividend<0&&divisor>0&&dividend<=(-tdivisor)){
                res--;
            }else{
                break;
            }
            tdivisor+=divisor;
        }
        return (int)res;
    }
}
