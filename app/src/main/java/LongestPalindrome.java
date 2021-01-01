import java.util.Scanner;

/**
 * 5. 最长回文子串
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 *
 * 示例 1：
 *
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 *
 * 输入: "cbbd"
 * 输出: "bb"
 * 由中心向两边扩散法：
 * 执行用时：8 ms, 在所有 Java 提交中击败了95.92%的用户
 * 内存消耗：38.4 MB, 在所有 Java 提交中击败了89.08%的用户
 * 动态规划法：
 *
 */
public class LongestPalindrome {
    public static void main(String[] args)throws Exception {
        LongestPalindrome code=new LongestPalindrome();
        Scanner sc = new Scanner(System.in);
        while(true) {
            String l = sc.nextLine();
            System.out.println(code.longestPalindrome(l));
        }
    }
    public String longestPalindrome(String s) {

        byte[] bytes=s.getBytes();
        int length= bytes.length;
        if(length==1){
            return s;
        }
        int start=1;
        int maxStart=0,maxEnd=0;
        while(start<=length-1){
            if(bytes[start]==bytes[start-1]){
                int st=start-1,en=start;
                while(st>=0&&en<=length-1&&bytes[st]==bytes[en]){
                    st--;en++;
                }
                if(maxEnd-maxStart<en-st-2){
                    maxEnd=en-1;maxStart=st+1;
                }
            }
            if(start<length-1&&bytes[start+1]==bytes[start-1]){
                int st=start-1,en=start+1;
                while(st>=0&&en<=length-1&&bytes[st]==bytes[en]){
                    st--;en++;
                }
                if(maxEnd-maxStart<en-st-2){
                    maxEnd=en-1;maxStart=st+1;
                }
            }
            start++;
        }
        return new String(bytes,maxStart,maxEnd-maxStart+1);
    }
}
