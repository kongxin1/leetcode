import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 22. 括号生成
 */
public class GenerateParenthesis {
    List<List<String>> res;
    public static void main(String[] args)throws Exception {
        GenerateParenthesis code=new GenerateParenthesis();
        Scanner sc = new Scanner(System.in);
        while(true) {
            String line = sc.nextLine();
            System.out.println(code.generateParenthesis(Integer.valueOf(line)));
        }
    }
    public List<String> generateParenthesis(int n) {
        if(res==null){
            res=new ArrayList<>();
            List<String> entry1=new ArrayList<>();
            entry1.add("()");
            res.add(entry1);
            for(int i=2;i<=8;i++){
                res.add(doGenPara(i));
            }
        }
        return res.get(n-1);
    }
    private List<String> doGenPara(int n){
        int start=1;
        for(int i=1;i<n;i++){
            start=(start<<1)|1;
        }
        int end=start<<n;
        start=2;
        for(int i=1;i<n;i++){
            start|=(start<<2);
        }
        List<String> r=new ArrayList<>();
        for(;start<=end;start+=2){
            int c=0;
            int t=start;
            while(t!=0){
                if((t&1)==0){
                    c-=1;
                }else{
                    c+=1;
                }
                if(c>0){
                    break;
                }
                t=t>>>1;
            }
            if(t==0&&c==0){
                StringBuilder str=new StringBuilder();
                t=start;
                while(t!=0){
                    if((t&1)==0){
                        str.append('(');
                    }else{
                        str.append(')');
                    }
                    t=t>>>1;
                }
                r.add(str.toString());
            }
        }
        return r;
    }
}
