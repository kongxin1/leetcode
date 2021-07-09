import java.util.*;

public class Combine {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res=new ArrayList();
        process(res,n,k,new int[k],1,0);
        return res;
    }
    public void process(List<List<Integer>> res,int n,int k,int[] t,int s,int index){
        if(index==k){
            List<Integer> l=new ArrayList(k);
            for(int i=0;i<k;i++){
                l.add(t[i]);
            }
            res.add(l);
            return;
        }
        for(int i=s;i<=n;i++){
            t[index]=i;
            process(res,n,k,t,i+1,index+1);
        }
    }
}
