import java.util.Scanner;

/**
 * 29. 两数相除
 * 给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
 *
 * 返回被除数 dividend 除以除数 divisor 得到的商。
 *
 * 整数除法的结果应当截去（truncate）其小数部分，例如：truncate(8.345) = 8 以及 truncate(-2.7335) = -2
 */
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
        long ldividend=dividend,ldivisor=divisor;
        long res=0;
        boolean positive=true;
        if(ldividend<0&&ldivisor>0||ldividend>0&&divisor<0){
            positive=false;
        }
        //将负数值全部转换为正数
        if(ldividend<0){
            ldividend=-ldividend;
        }
        if(divisor<0){
            ldivisor=-ldivisor;
        }
        while(ldividend>=ldivisor){
            int bit=shiftBit(ldividend,ldivisor);
            ldividend=ldividend-(ldivisor<<bit);
            res=res|(1L<<bit);
            if(positive){
                if(res>Integer.MAX_VALUE){
                    return Integer.MAX_VALUE;
                }
            }else{
                if(-res<Integer.MIN_VALUE){
                    return Integer.MAX_VALUE;
                }
            }
        }
        if(!positive){
            return (int)-res;
        }else{
            return (int)res;
        }
    }
    private int shiftBit(long a,long b){
        int bit=0;
        while(a>=(b<<1)){
            bit++;
            b=b<<1;
        }
        return bit;
    }
}
