public class MyPow {
    public static void main(String argv[]){
        MyPow m=new MyPow();
        System.out.println(m.myPow(2.00000,-2147483648));
    }
    public double myPow(double x, int n) {
        if(n==0||Math.abs(x-1.0d)<=0.00000001d){
            return 1.0d;
        }
        boolean negative=false,one=false;
        if(n==-2147483648){
            n=-2147483647;
            one=true;
        }
        if(n<0){
            n=-n;
            negative=true;
        }
        double res=1.0;
        if((n&1)==1){
            res=x;
            n--;
        }
        double mid=x;
        while(n!=0) {
            mid *= mid;
            n = n >> 1;
            if ((n & 1) == 1) {
                res *= mid;
            }
        }
        if(one){
            res*=x;
        }
        if(negative){
            return 1.0d/res;
        }else{
            return res;
        }
    }
}
