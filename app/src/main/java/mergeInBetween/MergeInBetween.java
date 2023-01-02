package mergeInBetween;

public class MergeInBetween {
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode l1=list1,l2=list1,l3=list2;
        for(int i=0;i<a-1;i++){
            l1=l1.next;
        }
        for(int i=0;i<b;i++){
            l2=l2.next;
        }
        l1.next=list2;
        while(true){
            if(l3.next==null){
                break;
            }else{
                l3=l3.next;
            }
        }
        l3.next=l2.next;

        return list1;
    }
}
