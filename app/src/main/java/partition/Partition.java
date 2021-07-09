package partition;

public class Partition {
	public static void main(String argv[]){
		Partition p=new Partition();
		ListNode l1=new ListNode(1);
//		ListNode l2=new ListNode(5,l1);
//		
//		ListNode l3=new ListNode(2,l2);
//		ListNode l4=new ListNode(3,l3);
//		ListNode l5=new ListNode(4,l4);
		ListNode head=new ListNode(2,l1);
		
		p.partition(head, 4);
	}
    public ListNode partition(ListNode head, int x) {
    	ListNode tailLess=null,tailMore=null,next=head;
    	ListNode headLess=null,headMore=null;
    	while(next!=null){
    		if(next.val<x&&headLess==null){
    			tailLess=headLess=next;
    		}else if(next.val>=x&&headMore==null){
    			tailMore=headMore=next;
    		}
    		if(headLess==null||headMore==null){
    			if(next.val<x){
    				tailLess=next;
    			}else{
    				tailMore=next;
    			}
    		}else{
    			next=next.next;
    			break;
    		}
    		next=next.next;
    	}
    	if(headLess==null||headMore==null){
    		return head;
    	}
    	while(next!=null){
    		ListNode t=next;
    		next=next.next;
    		if(t.val<x){
    			tailLess.next=t;
    			tailLess=t;
    		}else{
    			tailMore.next=t;
    			tailMore=t;
    		}    		
    	}
    	tailLess.next=headMore;
    	tailMore.next=null;
    	
    	return headLess;
    }
}
