import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 17. 电话号码的字母组合
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * 示例:
 *
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 */
public class LetterCombinations {
    private String[] digitToAlph=new String['9'+1];
    public static void main(String[] args)throws Exception {
        LetterCombinations code=new LetterCombinations();
        Scanner sc = new Scanner(System.in);
        while(true) {
            String i = sc.nextLine();
            System.out.println(code.letterCombinations(i));
        }
    }
    public List<String> letterCombinations(String digits) {
        List<String> res=new ArrayList<>();
        if(digits.length()==0){
            return res;
        }
        digitToAlph['2']="abc";
        digitToAlph['3']="def";
        digitToAlph['4']="ghi";
        digitToAlph['5']="jkl";
        digitToAlph['6']="mno";
        digitToAlph['7']="pqrs";
        digitToAlph['8']="tuv";
        digitToAlph['9']="wxyz";


        char[] str=new char[digits.length()];
        recursion(0,res,digits,str);
        return res;
    }
    private void recursion(int n,List<String> res,String digits,char[] str){
        if(n==digits.length()){
            res.add(new String(str));
            return;
        }
        char c=digits.charAt(n);
        int length=digitToAlph[c].length();
        for(int i=0;i<length;i++){
            str[n]=digitToAlph[c].charAt(i);
            recursion(n+1,res,digits,str);
        }
    }
}
