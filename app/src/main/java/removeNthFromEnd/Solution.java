package removeNthFromEnd;

import java.util.Scanner;

/**
 * 19. 删除链表的倒数第N个节点
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 *
 * 示例：
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 *
 * 说明： 给定的 n 保证是有效的。
 *
 * 进阶：你能尝试使用一趟扫描实现吗？
 *
 * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
 * 内存消耗：36.4 MB, 在所有 Java 提交中击败了52.02%的用户
 */
public class Solution {
    public static void main(String[] args)throws Exception {
        Solution code=new Solution();
        Scanner sc = new Scanner(System.in);
        while(true) {
            String line = sc.nextLine();
            String[] s=line.split(",");
            ListNode head=new ListNode();
            ListNode iter=head;
            iter.val=Integer.valueOf(s[0]);
            for(int i=1;i<s.length-1;i++){
                ListNode t=new ListNode();
                t.val=Integer.valueOf(s[i]);
                iter.next=t;
                iter=t;
            }
            int n=Integer.valueOf(s[s.length-1]);
            ListNode list=code.removeNthFromEnd(head,n);
            for(ListNode l=list;l!=null;l=l.next){
                System.out.print(l.val+" , ");
            }

        }
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode preNthNode=null;//倒数第n节点的前一个节点
        ListNode t=head;//遍历指针，用于遍历一遍链表

        while(t.next!=null){
            t=t.next;//切换下一个节点
            n--;
            if(n==0){
                preNthNode=head;
            }else if(n<0){
                preNthNode=preNthNode.next;
            }
        }
        if(preNthNode==null){
            head=head.next;//删除第一个节点
        }else{
            preNthNode.next=preNthNode.next.next;
        }
        return head;
    }
}
