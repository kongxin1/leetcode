package deleteDuplicates;

public class DeleteDuplicates {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }
        ListNode next=head.next,tail=null;
        ListNode pre=head;
        boolean flag=false;
        while(next!=null){
            ListNode t=next;
            next=next.next;
            if(t.val!=pre.val){
                if(!flag){
                    if(tail!=null){
                        tail.next=pre;
                    }else{
                        head=pre;
                    }
                    tail=pre;
                }
                pre=t;
                flag=false;
            }else{
                flag=true;
            }
        }
        if(!flag){
            if(tail!=null){
                tail.next=pre;
            }else if(tail==null){
                head=pre;
            }
            tail=pre;
        }
        if(tail!=null){
            tail.next=null;
            return head;
        }else{
            return null;
        }
    }
}
