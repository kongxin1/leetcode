import java.util.HashMap;
import java.util.Map;

public class FractionToDecimal {
    public static void main(String[] args) {
        FractionToDecimal f=new FractionToDecimal();
        f.fractionToDecimal(-1,-2147483648);
    }
    public String fractionToDecimal(int numerator, int denominator) {
        Map<Long,Integer> map=new HashMap<>();
        StringBuilder res=new StringBuilder();
        if(numerator==0){
            return "0";
        }
        long n=numerator;
        long d=denominator;
        if(n<0&&d<0){
            n=-n;
            d=-d;
        }else if(n<0){
            n=-n;
            res.append('-');
        }else if(d<0){
            d=-d;
            res.append('-');
        }
        if(n>d){
            res.append(n/d);
            n=n%d;
        }
        if(n!=0){
            if(res.length()==0){
                res.append(0);
            }
            res.append('.');
            int i=res.length();
            map.put(n,i);
            while(true){
                n=n*10;
                if(n<d){
                    res.append('0');
                }else{
                    res.append(n / d);
                    n=n%d;
                    if(n==0){
                        break;
                    }
                }
                if(map.get(n)==null){
                    i++;
                    map.put(n,i);
                }else{
                    break;
                }
            }
            if(n!=0) {
                int index = map.get(n);
                res.insert(index, '(');
                res.append(')');
            }
        }
        return res.toString();
    }
}
