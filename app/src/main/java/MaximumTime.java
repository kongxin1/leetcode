public class MaximumTime {
    public static void main(String argv[]){
        MaximumTime m=new MaximumTime();
        m.maximumTime("1?:22");
    }
    public String maximumTime(String time) {
        StringBuilder res=new StringBuilder();
        char h1=time.charAt(0);
        char h2=time.charAt(1);

        char m1=time.charAt(3);
        char m2=time.charAt(4);

        if(h1=='?'&&h2=='?'){
            res.append("23");
        }else if(h1=='?'){
            if(h2>='0'&&h2<='3'){
                res.append('2').append(h2);
            }else{
                res.append('1').append(h2);
            }
        }else if(h2=='?'){
            res.append(h1);
            if(h1=='2'){
                res.append('3');
            }else{
                res.append('9');
            }
        }else{
            res.append(h1).append(h2);
        }
        res.append(':');

        if(m1=='?'&&m2=='?'){
            res.append("59");
        }else if(m1=='?'){
            res.append('5').append(m2);
        }else if(m2=='?'){
            res.append(m1).append('9');
        }else{
            res.append(m1).append(m2);
        }
        return res.toString();
    }
}
