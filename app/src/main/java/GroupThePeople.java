import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupThePeople {
    public static void main(String[] args) {
        GroupThePeople g=new GroupThePeople();
        g.groupThePeople(new int[]{2,1,3,3,3,2});
    }
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        Map<Integer,List<Integer>> map=new HashMap();
        List<List<Integer>> ans=new ArrayList<>();
        for(int i=0;i< groupSizes.length;i++){
            int t=groupSizes[i];
            List<Integer> list=map.get(t);
            if(list==null){
                list=new ArrayList<>();
                list.add(i);
                map.put(t,list);
            }else{
                list.add(i);
            }
            if(list.size()==t){
                ans.add(list);
                map.remove(t);
            }
        }
        return ans;
    }
}
