public class IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        int j=0;
        for(int i=0;i<s.length();i++){
            char cs=s.charAt(i);
            boolean isFound=false;
            while(j<t.length()){
                if(cs==t.charAt(j)){
                    j++;
                    isFound=true;
                    break;
                }else{
                    j++;
                }
            }
            if(!isFound){
                return false;
            }
        }
        return true;
    }
}
