package LinkedList;


import java.util.List;

public class RemoveMiddleOfLinkedList2095 {
     public static class ListNode {
        int val;
         ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }


    public static ListNode deleteMiddle(ListNode head) {
         if(head.next==null){
             return null;
         }
        ListNode slow=head;
        ListNode fast=head;
        ListNode pre=slow;
        while(fast!=null && fast.next!=null){
            pre=slow;
            slow=slow.next;
            fast=fast.next.next;
        }
        if (slow != null){
            pre.next=slow.next;
        }
    return head;
    }
    public static void print(ListNode head){
        ListNode temp = head;
        while(temp != null){
            System.out.println(temp.val);
            temp=temp.next;
        }
        System.out.println("===========================================");
    }
    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        ListNode e = new ListNode(5);
        ListNode f = new ListNode(6);
        ListNode g = new ListNode(7);
//        ListNode h = new ListNode(8);

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;
        f.next = g;
//        g.next = h;

        print(a);
        deleteMiddle(a);
        print(a);
        
    }
}
