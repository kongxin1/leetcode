import java.util.ArrayList;
import java.util.List;

public class KidsWithCandies {
    public static void main(String[] args) {
        KidsWithCandies k=new KidsWithCandies();
        k.kidsWithCandies(new int[]{2,3,5,1,3},3);
    }
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> res=new ArrayList<>(candies.length);
        int max=0;
        for(int i=0;i<candies.length;i++){
            max=Math.max(max,candies[i]);
        }
        for(int i=0;i<candies.length;i++){
            if(candies[i]+extraCandies>=max){
                res.add(Boolean.TRUE);
            }else{
                res.add(Boolean.FALSE);
            }
        }
        return res;
    }
}
