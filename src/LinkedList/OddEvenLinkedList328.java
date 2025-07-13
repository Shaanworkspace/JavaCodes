package LinkedList;

public class OddEvenLinkedList328 {
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
    public static ListNode oddEvenList(ListNode head) {
        if(head==null){
            return null;
        }
        if(head.next==null){
            return head;
        }
        if(head.next.next==null){
            return head;
        }
        ListNode temp1 = head;
        ListNode head2 = head.next;
        ListNode temp2=head2;

        while (temp1.next !=null && temp2.next!=null){
            temp1.next = temp2.next;
            temp1=temp1.next;

            if(temp1.next!=null){
                temp2.next=temp1.next;
                temp2=temp2.next;
            }
        }
        temp1.next=head2;
        temp2.next=null;
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

        print(oddEvenList(a));
    }
}
