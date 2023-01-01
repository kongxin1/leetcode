public class ReverseWords {
    public static void main(String[] args) {
        ReverseWords r=new ReverseWords();
        r.reverseWords("a good   example");
    }
    public String reverseWords(String s) {
        s=s.trim();
        String[] array=s.split(" ");
        StringBuilder res=new StringBuilder();
        for(int i=array.length-1;i>=0;i--){
            if(array[i].equals("")){
                continue;
            }else{
                if(i!=array.length-1){
                    res.append(' ');
                }
                res.append(array[i]);
            }
        }
        return res.toString();
    }
}
