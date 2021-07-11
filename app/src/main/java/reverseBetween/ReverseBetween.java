package reverseBetween;

public class ReverseBetween {
    public static void main(String argv[]) {
        ReverseBetween p = new ReverseBetween();
        ListNode l1 = new ListNode(5);
        ListNode l2 = new ListNode(4, l1);
        ListNode l3 = new ListNode(3, l2);
        ListNode l4 = new ListNode(2, l3);
        ListNode head = new ListNode(1, l4);

        p.reverseBetween(head, 1, 4);
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == right) {
            return head;
        }
        ListNode leftNodePre = null, next = head;
        int i = 1;
        while (i != left) {
            leftNodePre = next;
            next = next.next;
            i++;
        }
        ListNode pre = next;
        next = next.next;
        for (i++; i != right+1; i++) {
            ListNode t = next;
            next = next.next;
            t.next = pre;
            pre = t;
        }
        if(leftNodePre!=null) {
            leftNodePre.next.next = next;
            leftNodePre.next = pre;
        }else{
            head.next=next;
            head=pre;
        }
        return head;
    }
}