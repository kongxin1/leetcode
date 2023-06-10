import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Set;

public class SmallestInfiniteSet {
    public static void main(String[] args) {
        SmallestInfiniteSet s=new SmallestInfiniteSet();
        s.addBack(2);
        System.out.println(s.popSmallest());
        System.out.println(s.popSmallest());
        System.out.println(s.popSmallest());
        s.addBack(1);
        System.out.println(s.popSmallest());
        System.out.println(s.popSmallest());
        System.out.println(s.popSmallest());
    }
    private PriorityQueue<Integer> q;
    private int smallest;
    private Set<Integer> set;
    public SmallestInfiniteSet() {
        q=new PriorityQueue();
        smallest=1;
        set=new HashSet<>();
    }

    public int popSmallest() {
        if(q.size()==0){
            smallest++;
            return smallest-1;
        }else{
            int t=q.poll();
            set.remove(t);
            return t;
        }
    }

    public void addBack(int num) {
        if(!set.contains(num)&&num<smallest){
            set.add(num);
            q.add(num);
        }
    }
}
