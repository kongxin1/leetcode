public class MinOperations {
    public static void main(String[] args) {
        MinOperations m=new MinOperations();
        m.minOperations("110");
    }
    public int[] minOperations(String boxes) {
        int m=0,n=0;
        int ans[]=new int[boxes.length()];
        for(int i=0;i<boxes.length();i++){
            if(boxes.charAt(i)=='1'){
                n++;
                ans[0]+=i-0;
            }
        }
        if(boxes.charAt(0)=='1'){
            m++;
            n--;
        }
        for(int i=1;i<boxes.length();i++){
            ans[i]=ans[i-1]-n+m;
            if(boxes.charAt(i)=='1'){
                n--;
                m++;
            }
        }
        return ans;
    }
}
