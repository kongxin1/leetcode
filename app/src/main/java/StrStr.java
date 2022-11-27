public class StrStr {
    public static void main(String argv[]){
        StrStr StrStr=new StrStr();
        StrStr.strStr("1adbutsas","sad");
    }
    public int strStr(String haystack, String needle) {
        if(needle.length()>haystack.length()){
            return -1;
        }
        for(int i=0;i<haystack.length()-needle.length()+1;i++){
            if(haystack.charAt(i)==needle.charAt(0)){
                boolean isOk=true;
                for(int j=1;j<needle.length();j++){
                    if(haystack.charAt(i+j)!=needle.charAt(j)){
                        isOk=false;
                        break;
                    }
                }
                if(isOk){
                    return i;
                }
            }
        }
        return -1;
    }
}
