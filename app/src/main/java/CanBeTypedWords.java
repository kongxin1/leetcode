public class CanBeTypedWords {
    public static void main(String[] args){
        CanBeTypedWords c=new CanBeTypedWords();
        c.canBeTypedWords("hello world","ad");
    }

    public int canBeTypedWords(String text, String brokenLetters) {
        boolean flag[]= new boolean['z'+1];
        for(int i=0;i<brokenLetters.length();i++){
            flag[brokenLetters.charAt(i)]=true;
        }
        String[] words=text.split(" ");
        int ok=0;
        for(int i=0;i<words.length;i++){
            String word=words[i];
            if(!word.equals(" ")){
                int j=0;
                for(j=0;j<word.length();j++){
                    if(flag[word.charAt(j)]){
                        break;
                    }
                }
                if(j==word.length()){
                    ok++;
                }
            }
        }
        return ok;
    }
}
