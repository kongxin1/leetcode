import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 43. 字符串相乘
 * 执行结果：通过
 * 显示详情
 * 执行用时：7 ms, 在所有 Java 提交中击败了54.30%的用户
 * 内存消耗：38.5 MB, 在所有 Java 提交中击败了75.86%的用户
 */
public class Multiply {
    public static void main(String[] args)throws Exception {
        Multiply code=new Multiply();
        Scanner sc = new Scanner(System.in);
        List<Integer> list=new ArrayList<Integer>();
        while(true) {
            String line = sc.nextLine();
            String[] s=line.split(",");
            System.out.println(code.multiply(s[0],s[1]));
        }
    }
    public String multiply(String num1, String num2) {
        byte res[]=new byte[300];
        byte mid[]=new byte[300];
        int midLength=0,resLength=0;
        for(int i=num1.length()-1;i>=0;i--){
            int a=num1.charAt(i)-'0';
            int c=0;
            for(int j=num2.length()-1;j>=0;j--){
                int b=num2.charAt(j)-'0';
                mid[midLength++]=(byte)((a*b+c)%10);
                c=((a*b+c)/10);
            }

            while(c!=0) {
                mid[midLength++]=(byte)(c%10);
                c/=10;
            }

            if(resLength==0){
                for(int j=0;j<midLength;j++){
                    res[resLength++]=mid[j];
                }
            }else{
                int j=num1.length()-1-i,m,n;
                c=0;
                for(int k=0;k<midLength||c!=0;k++,j++){
                    m=0;
                    if(k<midLength){
                        m= mid[k];
                    }
                    if(j<resLength) {
                        n = res[j];
                        res[j]=(byte)((m+n+c)%10);
                        c=(m+n+c)/10;
                    }else{
                        res[resLength++] = (byte)((m+c)%10);
                        c=(m+c)/10;
                    }
                }
            }
            midLength=0;
        }
        StringBuilder s=new StringBuilder();
        resLength--;
        for(;resLength>=0;resLength--){
            if(res[resLength]!=0){
                break;
            }
        }
        for(;resLength>=0;resLength--){
            s.append(res[resLength]);
        }
        if(s.length()==0){
            s.append(0);
        }
        return s.toString();
    }
}
