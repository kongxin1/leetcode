public class AddRungs {
    public static void main(String[] args){
        AddRungs a=new AddRungs();
        System.out.println(a.addRungs(new int[]{3},1));
    }
    public int addRungs(int[] rungs, int dist) {
        int cnt=0,next=0;
        for(int i=0;i<rungs.length;){
            if(next+dist<rungs[i]){
                int d=rungs[i]-next;
                if(d%dist==0){
                    cnt+=d/dist-1;
                    next+=((d/dist)-1)*dist;
                }else{
                    cnt+=d/dist;
                    next+=((d/dist))*dist;
                }
            }else{
                next=rungs[i];
                i++;
            }
        }
        return cnt;
    }
}
