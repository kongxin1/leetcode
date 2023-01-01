public class CountPrimes {
    public static void main(String[] args) {
        CountPrimes c=new CountPrimes();
        c.countPrimes(3);
    }
    public int countPrimes(int n) {
        if(n==1||n==0||n==2){
            return 0;
        }

        int t=(int)Math.sqrt(n);
        boolean[] p=new boolean[n];

        for(int i=2;i<=t;i++){
            if(p[i]==true){
                continue;
            }
            int j=i*i;
            while(j<n){
                p[j]=true;
                j=j+i;
            }
        }

        int res=0;
        for(int i=2;i<n;i++){
            if(p[i]==false){
                res++;
            }
        }
        return res;
    }
}
