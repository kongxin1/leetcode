import java.util.Arrays;
import java.util.Scanner;

public class CountAndSay {
    public static void main(String[] args)throws Exception {
        CountAndSay code=new CountAndSay();
        Scanner sc = new Scanner(System.in);
        while(true) {
            String l = sc.nextLine();
            System.out.println(code.countAndSay(Integer.valueOf(l)));
        }
    }
    public String countAndSay(int n) {
        if(n==1){
            return "1";
        }
        String res="1";
        for(int i=2;i<=n;i++){
            res=gen(res);
        }
        return res;
    }
    public String gen(String s){
        StringBuilder sb=new StringBuilder();
        int length=s.length();
        int t=s.charAt(0);
        int cnt=1;
        for(int i=1;i<length;i++){
            if(t!=s.charAt(i)){
                sb.append(cnt).append((char)t);
                t=s.charAt(i);
                cnt=1;
            }else{
                cnt++;
            }
        }
        sb.append(cnt).append((char)t);
        return sb.toString();
    }
}
