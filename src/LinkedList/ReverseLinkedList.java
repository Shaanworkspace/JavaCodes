package LinkedList;

public class ReverseLinkedList {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public static void print(ListNode head){
        ListNode temp = head;
        while(temp != null){
            System.out.println(temp.val);
            temp=temp.next;
        }
        System.out.println("===========================================");
    }
    public static ListNode reverse(ListNode head){
        ListNode pre = null;
        ListNode curr = head;
        ListNode Next = null;
        while(curr!=null){
            Next=curr.next;
            curr.next=pre;
            pre=curr;
            curr=Next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        ListNode e = new ListNode(5);
        ListNode f = new ListNode(6);
        ListNode g = new ListNode(7);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;
        f.next = g;
        print(a);

        print(reverse(a));
    }
}
