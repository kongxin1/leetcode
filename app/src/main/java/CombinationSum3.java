import java.util.ArrayList;
import java.util.List;

public class CombinationSum3 {
    public static void main(String[] args) {
        CombinationSum3 c=new CombinationSum3();
        c.combinationSum3(3,7);
    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res=new ArrayList<List<Integer>>();
        int[] s=new int[9];
        rescu(res,n,k,s,0,0);
        return res;
    }
    public void rescu(List<List<Integer>> res,int n,int k,int[] s,int i,int sj){
        if(i==k){
            int sum=0;
            for(int j=0;j<i;j++){
                sum+=s[j];
            }
            if(sum==n){
                List<Integer> r=new ArrayList<Integer>();
                res.add(r);
                for(int j=0;j<i;j++){
                    r.add(s[j]);
                }
            }else{
                return;
            }
        }
        for(int j=sj+1;j<=9;j++){
            s[i]=j;
            rescu(res,n,k,s,i+1,j);
        }
    }
}
