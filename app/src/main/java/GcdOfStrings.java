public class GcdOfStrings {
    public static void main(String[] args) {
        GcdOfStrings g=new GcdOfStrings();
        System.out.println(g.gcdOfStrings("LEET","CODE"));
    }
    public String gcdOfStrings(String str1, String str2) {
        int len1=str1.length(),len2=str2.length();
        int len=Math.min(len1,len2);
        while(len>=1){
            if(len1%len==0&&len2%len==0){
                for(int i=len;i<len+len;i++){
                    int j=i;
                    while(j<len1){
                        if(str1.charAt(j)!=str1.charAt(i-len)){
                            return "";
                        }
                        j+=len;
                    }
                }
                for(int i=len;i<len+len;i++){
                    int j=i-len;
                    while(j<len2){
                        if(str2.charAt(j)!=str1.charAt(i-len)){
                            return "";
                        }
                        j+=len;
                    }
                }
                return str1.substring(0,len);
            }
            len--;
        }
        return "";
    }
}
