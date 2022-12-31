public class TrailingZeroes {
    public static void main(String[] args) {
        TrailingZeroes t=new TrailingZeroes();
        t.trailingZeroes(10);
    }
    public int trailingZeroes(int n) {
        int res=0;
        for(int i=5;i<=n;i+=5){
            int t=i;
            while(t%5==0){
                t=t/5;
                res++;
            }

        }
        return res;
    }
}
