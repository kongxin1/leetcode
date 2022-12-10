public class LRUCache {
    public static void main(String argv[]){

        //["LRUCache","put","put","put","put","get","get","get","get","put","get","get","get","get","get"]
        //[[3],[1,1],[2,2],[3,3],[4,4],[4],[3],[2],[1],[5,5],[1],[2],[3],[4],[5]]
        LRUCache lRUCache=new LRUCache(3);
        lRUCache.put(1, 1); // 缓存是 {1=1}
        lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
        lRUCache.put(3, 3);
        lRUCache.put(4, 4);
        lRUCache.get(4);
        lRUCache.get(3);
        lRUCache.get(2);
        lRUCache.get(1);
        lRUCache.put(5, 5);
        lRUCache.get(1);
        lRUCache.get(2);
        lRUCache.get(3);
        lRUCache.get(4);
        lRUCache.get(5);
    }
    private int c;
    private Entry root;
    private Entry[] list;
    private int length;
    public LRUCache(int capacity) {
        list=new Entry[10001];
        c=capacity;
        length=0;
    }

    public int get(int key) {
        Entry e=list[key];
        if(e==null){
            return -1;
        }
        translat(e);
        return e.value;
    }

    public void put(int key, int value) {
        if(list[key]!=null){
            list[key].value=value;
            list[key].key=key;
            translat(list[key]);
        }else{
            Entry e=new Entry();
            e.value=value;
            e.key=key;
            if(root==null){
                root=e;
                root.next=root;
                root.pre=root;
            }else {
                e.next = root;
                e.pre = root.pre;
                root.pre.next=e;
                root.pre = e;
                root = e;
            }
            list[key]=root;
            if(length+1>c){
                Entry ee=root.pre;
                list[ee.key]=null;
                ee.pre.next=ee.next;
                ee.next.pre=ee.pre;
            }else{
                length++;
            }
        }
    }
    public void translat(Entry e){
        if(e!=root){
            e.pre.next=e.next;
            if(e!=root.pre){
                e.next.pre=e.pre;
                e.pre = root.pre;
            }
            e.next=root;
            root.pre=e;
            root=e;
        }
    }
}
class Entry{
    Entry pre;
    int value;
    int key;
    Entry next;
}
