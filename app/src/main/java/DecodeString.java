public class DecodeString {
    private int i=0;
    public static void main(String[] args) {
        DecodeString d=new DecodeString();
        d.decodeString("abc3[cd2[aa]]xyz");
    }
    public String decodeString(String s) {
        i=0;
        StringBuilder t=new StringBuilder();
        while(i<s.length()){
            t.append(recu(s));
            i++;
        }
        return t.toString();
    }

    public StringBuilder recu(String s){
        int dup=0;
        StringBuilder t=new StringBuilder();
        while(i<s.length()){
           if(s.charAt(i)>='0'&&s.charAt(i)<='9'){
               dup=dup*10+(s.charAt(i)-'0');
           }else if(s.charAt(i)=='['){
               i++;
               StringBuilder tt=recu(s);
               for(int j=0;j<dup;j++){
                   t.append(tt);
               }
               dup=0;
           }else if(s.charAt(i)==']'){
               return t;
           }else{
                t.append(s.charAt(i));
           }
           i++;
       }
        return t;
    }
}
