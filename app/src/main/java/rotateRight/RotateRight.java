package rotateRight;

public class RotateRight {
    public static void main(String arg[]){
        RotateRight f=new RotateRight();
        ListNode n1=new ListNode(1);
        ListNode n2=new ListNode(2);
        ListNode n3=new ListNode(3);
        ListNode n4=new ListNode(4);
        ListNode n5=new ListNode(5);
        n1.next=n2;n2.next=n3;n3.next=n4;n4.next=n5;
        f.rotateRight(n1,2);
    }
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null||k==0){
            return head;
        }
        int length=0;
        ListNode n=head,tail=n;
        while(n!=null){
            length++;
            tail=n;
            n=n.next;
        }
        k=k%length;
        if(length==1||k==0){
            return head;
        }
        ListNode kn=head,pre=null;
        int i=0;
        while(i<length-k){
            pre=kn;
            kn=kn.next;
            i++;
        }
        pre.next=null;
        tail.next=head;
        head=kn;
        return head;
    }
}
