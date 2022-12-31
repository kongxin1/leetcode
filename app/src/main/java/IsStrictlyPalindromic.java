public class IsStrictlyPalindromic {
    public static void main(String[] args) {
        IsStrictlyPalindromic i=new IsStrictlyPalindromic();
        i.isStrictlyPalindromic(9);
    }
    public boolean isStrictlyPalindromic(int n) {
        StringBuilder sb=new StringBuilder();
        for(int i=2;i<=n-2;i++){
            int t=n;
            while(t!=0) {
                sb.append(t % i);
                t=t/i;
            }
            if(!judge(sb)){
                return false;
            }
            sb.delete(0,sb.length());
        }
        return true;
    }
    public boolean judge(StringBuilder sb){
        int i=0,j=sb.length()-1;
        while(i<j){
            if(sb.charAt(i)!=sb.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
