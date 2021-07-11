import java.util.Arrays;

public class HIndex {
    public static void main(String argv[]) {
        HIndex h=new HIndex();
        System.out.print(h.hIndex(new int[]{3,0,6,1,5}));
    }
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        for(int i=0;i< citations.length;i++){
            int c=citations.length-i;
            if(citations[i]>=c){
                return c;
            }
        }
        return 0;
    }
}
