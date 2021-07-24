package detectCycle;

public class DetectCycle {
    public static void main(String argv[]){
        DetectCycle d=new DetectCycle();
        ListNode l1=new ListNode(3);
        ListNode l2=new ListNode(2);
        ListNode l3=new ListNode(0);
        ListNode l4=new ListNode(-4);
//        ListNode l5=new ListNode(5);
        l1.next=l2;
        l2.next=l3;
        l3.next=l4;
//        l4.next=l5;
        l4.next=l2;
        System.out.println(d.detectCycle(l1).val);

    }
    public ListNode detectCycle(ListNode head) {
        if(head==null){
            return null;
        }
        ListNode one=head.next,two=head.next;
        if(two!=null){
            two=two.next;
        }
        while(true){
            if(one==null||two==null){
                return null;
            }
            if(one==two){
                break;
            }else{
                one=one.next;
                two=two.next;
                if(two!=null){
                    two=two.next;
                }
            }
        }
        ListNode h=head;
        while(true){
            if(h==one){
                return h;
            }
            h=h.next;
            one=one.next;
        }
    }
}
