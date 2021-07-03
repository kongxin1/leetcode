import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 6. Z 字形变换
 */
public class Convert {
    public static void main(String[] args)throws Exception {
        Convert code=new Convert();
        Scanner sc = new Scanner(System.in);
        while(true) {
            String l = sc.nextLine();
            String[] str=l.split(",");
            System.out.println(code.convert(str[0],Integer.valueOf(str[1])));
        }
    }
    public String convert(String s, int numRows) {
        int length=s.length();
        if(length<=numRows||numRows==1){
            return s;
        }
        int c=(numRows<<1)-2;
        int l=(length%c!=0)?length/c+1:length/c;
        StringBuilder res=new StringBuilder(s.length());
        for(int i=0;i<numRows;i++){
            for(int j=0;j<l;j++){
                if(i+j*c<length) {
                    res.append(s.charAt(i + j * c));
                }
                if(i!=0&&i!=numRows-1&&c-i+j*c<length){
                    res.append(s.charAt(c-i+j*c));
                }
            }
        }
        return res.toString();
    }
}
