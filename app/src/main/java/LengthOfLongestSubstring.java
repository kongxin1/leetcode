import java.util.Scanner;
/*
3. 无重复字符的最长子串
给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 */
public class LengthOfLongestSubstring {
    public static void main(String[] args)throws Exception {
        LengthOfLongestSubstring code=new LengthOfLongestSubstring();
        Scanner sc = new Scanner(System.in);
        while(true) {
            String i = sc.nextLine();
            System.out.println(code.lengthOfLongestSubstring(i));
        }
    }
    public int lengthOfLongestSubstring(String s) {
        int len=s.length();
        if(len==0){
            return 0;
        }
        int n[]=new int[len];//记录以当前字符为起点，最长无重复字符的子串长度
        int d[]=new int[len];//记录与当前字符相同的右边第一个字符的位置
        int c[]=new int[130];
        byte[] chs=s.getBytes();
        int res=1;
        //初始化数组d
        for (int i = len - 1; i >= 0; i--){
            int t=chs[i];
            if(c[t]!=0){
                d[i]=c[t];
            }
            c[t]=i;
        }
        n[len-1]=1;
        for (int i = len - 2; i >= 0; i--) {
            if(d[i]==0||n[i+1]+i+1<=d[i]){
                n[i]=1+n[i+1];
            }else if(n[i+1]+i+1>d[i]){
                n[i]=d[i]-i;
            }
            if(res<n[i]){
                res=n[i];
            }
        }
        return res;
    }
}

