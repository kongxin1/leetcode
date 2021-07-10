import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class TimeMap {

    Map<String, TreeMap> map;

    public TimeMap() {
        map=new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        TreeMap<Integer,String> tree=map.get(key);
        if(tree==null){
            tree=new TreeMap<Integer,String>();
            map.put(key,tree);
        }
        tree.put(timestamp,value);
    }

    public String get(String key, int timestamp) {
        TreeMap<Integer,String> tree=map.get(key);
        if(tree==null){
            return "";
        }
        Map.Entry<Integer,String> entry= tree.floorEntry(timestamp);
        if(entry==null){
            return "";
        }else {
            return entry.getValue();
        }
    }

    public static void main(String argv[]){
        TimeMap map=new TimeMap();
        map.set("love","high",10);
        map.set("love","low",20);
        System.out.println(map.get("love",5));
        System.out.println(map.get("love",10));
        System.out.println( map.get("love",15));
        System.out.println(map.get("love",20));
        System.out.println(map.get("love",25));
    }
}
