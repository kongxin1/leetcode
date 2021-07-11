import java.util.HashSet;
import java.util.Set;

public class CountPalindromicSubsequence {
    public static void main(String argv[]){
        CountPalindromicSubsequence c=new CountPalindromicSubsequence();
        System.out.print(c.countPalindromicSubsequence("bbcbaba"));
    }
    public int countPalindromicSubsequence(String s) {
        int res=0;
        boolean[][] repeat=new boolean['z'+1]['z'+1];
        boolean[] flag=new boolean['z'+1];
        int length=s.length();
        for(int i=0;i<length-2;i++){
            if(flag[s.charAt(i)]==false) {
                flag[s.charAt(i)]=true;
                for (int j = length - 1; j > i + 1; j--) {
                    char a = s.charAt(i), b = s.charAt(j);
                    if (a == b) {
                        for (int k = i + 1; k < j; k++) {
                            char c = s.charAt(k);
                            if (repeat[a][c] == false) {
                                res++;
                                repeat[a][c] = true;
                            }
                        }
                        break;
                    }
                }
            }
        }
        return res;
    }
}
