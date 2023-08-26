/**
 * 功能描述
 *
 * @author: 孔新
 * @date: 2023年08月26日 18:19
 */
public class ReverseVowels {
    public static void main(String[] args) {
        ReverseVowels reverseVowels=new ReverseVowels();
        reverseVowels.reverseVowels("ai");
    }
    public String reverseVowels(String s) {
        char[] chars=s.toCharArray();
        int i=0,j=s.length()-1;

        while(i<j){
            char ci=getChar(i,chars);
            while(ci!='a'&&ci!='e'&&ci!='i'&&ci!='o'&&ci!='u'&&i<j&&ci!=0){
                i++;
                ci=getChar(i,chars);
            }
            char cj=getChar(j,chars);
            while(cj!='a'&&cj!='e'&&cj!='i'&&cj!='o'&&cj!='u'&&i<j&&cj!=0){
                j--;
                cj=getChar(j,chars);
            }
            if(i==j||ci==0||cj==0){
                break;
            }
            char t=chars[i];
            chars[i]=chars[j];
            chars[j]=t;
            i++;j--;
        }
        return new String(chars);
    }
    public char getChar(int i,char[] cs){
        if(i<0||i>=cs.length){
            return 0;
        }
        char ci=cs[i];
        if(ci<='Z'){
            ci+=('a'-'A');
        }
        return ci;
    }
}
