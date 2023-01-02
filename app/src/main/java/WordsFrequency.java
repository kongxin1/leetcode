import java.util.HashMap;
import java.util.Map;

public class WordsFrequency {
    Map<String,Integer> map;
    public WordsFrequency(String[] book) {
        map=new HashMap<>();
        for(int i=0;i<book.length;i++){
            if(map.get(book[i])==null){
                map.put(book[i],1);
            }else{
                int t=map.get(book[i]);
                t++;
                map.put(book[i],t);
            }
        }
    }

    public int get(String word) {
        Integer res=map.get(word);
        if(res==null){
            return 0;
        }else{
            return res;
        }
    }
}
