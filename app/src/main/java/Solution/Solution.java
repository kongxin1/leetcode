package Solution;

import java.util.Scanner;
public class Solution {
    public static void main(String[] args)throws Exception {
        Solution code=new Solution();
        Scanner sc = new Scanner(System.in);
        while(true) {
            ListNode l1 = new ListNode();
            ListNode l2 = new ListNode();
            ListNode t1 = l1;
            ListNode pre = null;
            //第一个整数
            while (true) {
                String line = sc.nextLine();
                if (line.equals("+")) {
                    break;
                }
                t1.val = Integer.valueOf(line);
                t1.next = new ListNode();
                pre = t1;
                t1 = t1.next;
            }
            pre.next = null;
            //第二个整数
            pre = null;
            ListNode t2 = l2;
            while (true) {
                String line = sc.nextLine();
                if (line == null || line.equals("")) {
                    break;
                }
                t2.val = Integer.valueOf(line);
                t2.next = new ListNode();
                pre = t2;
                t2 = t2.next;
            }
            pre.next = null;

            ListNode res=code.addTwoNumbers(l1, l2);
            while(res!=null){
                System.out.print(res.val);
                res=res.next;
            }
            System.out.print('\n');
        }

    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int c=0;//既表示进位又表示结果
        ListNode res=new ListNode();//表示最后的返回结果
        ListNode resList=res;
        while(true){
            if(l1!=null){
                c+=l1.val;
                l1=l1.next;
            }
            if(l2!=null){
                c+=l2.val;
                l2=l2.next;
            }
            resList.val=c%10;
            c=c>=10?1:0;
            if(l1!=null||l2!=null||c!=0){
                resList.next=new ListNode();
                resList=resList.next;
            }else{
                break;
            }
        }
        return res;
    }
}
