import java.util.*;

public class GroupAnagrams {
    public static void main(String[] args)throws Exception {
        String[] m=new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        GroupAnagrams rotate=new GroupAnagrams();
        rotate.groupAnagrams(m);
    }
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<List<Integer>,List<String>> map=new HashMap<>();
        for(String s:strs){
            int t=0;
            List<Integer> list=new ArrayList<>(26);
            int[] cnt=new int[26];
            for(int i=0;i<s.length();i++){
                int c=s.charAt(i)-'a';
                cnt[c]++;
            }
            for(int i:cnt){
                list.add(i);
            }
            List<String> l=map.get(list);
            if(l==null){
                l=new ArrayList<>();
            }
            l.add(s);
            map.put(list,l);
        }
        List<List<String>> res=new ArrayList<>();
        for(List<String> l:map.values()){
            res.add(l);
        }
        return res;
    }
}
