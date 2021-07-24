public class AreOccurrencesEqual {
    public static void main(String argv[]){
        AreOccurrencesEqual a=new AreOccurrencesEqual();
        a.areOccurrencesEqual("aaabb");
    }
    public boolean areOccurrencesEqual(String s) {
        if(s==null||s.length()==0){
            return true;
        }
        int a[]=new int[30];
        for(int i=0;i<s.length();i++){
            a[s.charAt(i)-'a']++;
        }
        int t=0;
        for(int i=0;i<26;i++){
            if(t==0&&a[i]!=0){
                t=a[i];
            }
            if(t!=0&&a[i]!=0&&t!=a[i]){
                return false;
            }
        }
        return true;
    }
}
