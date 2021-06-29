import java.util.*;

public class GroupAnagrams {
    public static void main(String[] args)throws Exception {
        String[] m=new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        GroupAnagrams rotate=new GroupAnagrams();
        rotate.groupAnagrams(m);
    }
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map=new HashMap<>();
        for(String s:strs){
            int t=0;
            StringBuilder sb=new StringBuilder();
            int[] cnt=new int[26];
            for(int i=0;i<s.length();i++){
                int c=s.charAt(i)-'a';
                cnt[c]++;
            }
            for(int i=0;i<26;i++){
                if(cnt[i]!=0){
                    sb.append(i+'a').append(cnt[i]);
                }
            }
            String st=sb.toString();
            List<String> l=map.get(st);
            if(l==null){
                l=new ArrayList<>();
            }
            l.add(s);
            map.put(st,l);
        }
        return new ArrayList<>(map.values());
    }
}
