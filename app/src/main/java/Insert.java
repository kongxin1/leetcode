import java.util.*;

public class Insert {
    public static void main(String argc[]){
        int[][] matrix=new int[][]{{1,2}};
        Insert r=new Insert();
        r.insert(matrix,new int[]{4,8});
    }
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if(intervals.length==0){
            int[][] r=new int[1][2];
            r[0]=newInterval;
            return r;
        }
        int s=0,e=intervals.length,mid;

        while(s<e){
            mid=(s+e)/2;
            if(intervals[mid][0]==newInterval[0]){
                s=mid;
                break;
            }else if(intervals[mid][0]>newInterval[0]){
                e=mid-1;
            }else{
                s=mid+1;
            }
        }
        if(s>=intervals.length){
            s=intervals.length-1;
        }else if(s<0){
            s=0;
        }
        List<int[]> res=new ArrayList();
        if(intervals[s][0]>newInterval[0]&&s>0&&intervals[s-1][1]>=newInterval[0]){
            s--;
            newInterval[0]=intervals[s][0]<=newInterval[0]?intervals[s][0]:newInterval[0];
            newInterval[1]=intervals[s][1]<=newInterval[1]?newInterval[1]:intervals[s][1];
        }else if(intervals[s][0]<newInterval[0]&& intervals[s][1]>=newInterval[0]){
            newInterval[0]=intervals[s][0]<=newInterval[0]?intervals[s][0]:newInterval[0];
            newInterval[1]=intervals[s][1]<=newInterval[1]?newInterval[1]:intervals[s][1];
        }else if( intervals[s][1]<newInterval[0]){
            s++;
        }
        for(int i=0;i<s;i++){
            res.add(intervals[i]);
        }
        boolean flag=false;
        for(int i=s;i<intervals.length;i++){
            if( intervals[i][0]>=newInterval[0] && intervals[i][0]<=newInterval[1]){
                newInterval[1]=intervals[i][1]>=newInterval[1]?intervals[i][1]:newInterval[1];
            }else{
                if(!flag){
                    res.add(newInterval);
                    flag=true;
                }
                res.add(intervals[i]);
            }
        }
        if(!flag){
            res.add(newInterval);
        }

        int[][] r=new int[res.size()][2];
        for(int k=0;k<res.size();k++){
            r[k]=res.get(k);
        }

        return r;
    }
}

