import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Merge {
    public static void main(String[] args) {
        Merge m=new Merge();
        int[][] intervals=new int[][]{{1,1},{1,2},{10,11},{12,13}};
        m.merge(intervals);
    }
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(x,y)->{
            if(x[0]>y[0]) return 1;
            else if(x[0]==y[0]) {
                return 0;
            }
            return -1;
        });
        List<int[]> res=new ArrayList<>();
        int min=intervals[0][0],max=intervals[0][1];
        for(int i=1;i<intervals.length;i++){
            if(max>=intervals[i][0]){
                if(max<intervals[i][1]) {
                    max = intervals[i][1];
                }
            }else{
                int[] t=new int[2];
                t[0]=min;t[1]=max;
                res.add(t);
                min=intervals[i][0];
                max=intervals[i][1];
            }
        }
        int[] t=new int[2];
        t[0]=min;t[1]=max;
        res.add(t);
        return res.stream().toArray(int[][]::new);
    }
}
