public class GetLucky {
    public static void main(String argv[]){
        GetLucky g=new GetLucky();
        g.getLucky("leetcode",2);
    }
    public int getLucky(String s, int k) {
        int sum=0;
        for(int i=0;i<s.length();i++){
            int c=s.charAt(i)-'a'+1;
            while(c!=0) {
                sum+=(c%10);
                c=c/10;
            }
        }
        k--;
        int t=0;
        for(int i=0;i<k;i++){
            t=0;
            while(sum!=0){
                t+=sum%10;
                sum/=10;
            }
            sum=t;
        }
        return sum;
    }
}
