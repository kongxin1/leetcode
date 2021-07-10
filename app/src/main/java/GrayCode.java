import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GrayCode {
    public static void main(String argc[]){
        GrayCode g=new GrayCode();
        g.grayCode(4);
    }
    public List<Integer> grayCode(int n) {
        Integer[] r=new Integer[1<<n];
        r[0]=0;
        if(n==0){
            return Arrays.asList(r);
        }
        r[1]=1;
        if(n==1){
            return Arrays.asList(r);
        }
        int max=1<<n,i=2;
        while(i<max){
            int t=i;
            for(int l=i-1;l>=0;l--) {
               r[i]= t | r[l];
               i++;
            }
        }
        return Arrays.asList(r);
    }
}
