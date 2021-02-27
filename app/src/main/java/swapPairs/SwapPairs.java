package swapPairs;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * 24. 两两交换链表中的节点
 * 执行结果：通过
 * 显示详情
 * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
 * 内存消耗：35.9  MB, 在所有 Java 提交中击败了85.74%的用户
 */
public class SwapPairs {
    public static void main(String[] args)throws Exception {
        SwapPairs code=new SwapPairs();
        Scanner sc = new Scanner(System.in);
        while(true) {
            String l = sc.nextLine();
            String[] a=l.split(",");
            ListNode head=null;
            ListNode pre=null;
            for(String s:a){
                ListNode node=new ListNode();
                if(pre!=null){
                    pre.next=node;
                }
                if(head==null){
                    head=node;
                }
                node.val=Integer.valueOf(s);
                pre=node;
            }
            head=code.swapPairs(head);
//            System.out.println(code.swapPairs(head));
            while(head!=null){
                System.out.print(head.val+" ");
                head=head.next;
            }
        }
    }
    public ListNode swapPairs(ListNode head) {
        if(head==null){
            return head;
        }
        ListNode first=head,pre=null;
        if(first.next==null){
            return head;
        }
        head=first.next;
        while(first!=null&&first.next!=null){
            if(pre!=null){
                pre.next=first.next;
            }
            pre=first.next;
            first.next=pre.next;
            pre.next=first;

            pre=first;
            first=first.next;
        }
        return head;
    }
}
