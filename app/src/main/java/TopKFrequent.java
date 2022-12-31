import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequent {
    public static void main(String[] args) {
        TopKFrequent t=new TopKFrequent();
        t.topKFrequent(new int[]{1,1,1,2,2,3},2);
    }
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            Integer j=map.get(nums[i]);
            if(j==null){
                map.put(nums[i],1);
            }else{
                j++;
                map.put(nums[i],j);
            }
        }
        PriorityQueue<int[]> q=new PriorityQueue(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
        for(Map.Entry<Integer,Integer> e: map.entrySet()){
            int[] i=new int[2];
            i[0]=e.getValue();
            i[1]=e.getKey();
            if(q.size()==k){
                if(q.peek()[0]<i[0]){
                    q.remove();
                    q.add(i);
                }
            }else{
                q.add(i);
            }
        }
        int[] res=new int[k];
        for(int i=0;i<k;i++){
            res[i]=q.remove()[1];
        }
        return res;
    }
}
