package LinkedList;

public class insertGreatestCommonDivisors2807 {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {}

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static ListNode arrayToLinkedList(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }

        // Create the head node
        ListNode head = new ListNode(arr[0]);
        ListNode current = head;

        // Create remaining nodes
        for (int i = 1; i < arr.length; i++) {
            current.next = new ListNode(arr[i]);
            current = current.next;
        }

        return head;
    }

    public static int gcd(int a , int b){
        if(b==0) return a;
        return gcd(b,a%b);
    }
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        if(head.next == null) return head;

        ListNode b = head;
        ListNode f = head.next;

        while(f != null){
            ListNode n = new ListNode(gcd(b.val,f.val));
            b.next=n;
            n.next=f;
            b=f;
            f=f.next;
        }
        return head;
    }

    public static void print(ListNode head){
        int len=0;
        ListNode temp = head;
        System.out.print("[ ");
        while(temp != null){
            System.out.print(temp.val+" ");
            len++;
            temp=temp.next;
        }
        System.out.print(" ]");

        System.out.println("Length of List :"+len);
    }

    public static void main(String[] args) {
        int[] arr = {12, 15, 21};
        ListNode head = arrayToLinkedList(arr);
        print(head);
        insertGreatestCommonDivisors2807 hh = new insertGreatestCommonDivisors2807();

        ListNode result = hh.insertGreatestCommonDivisors(head);
        print(result);



    }
}
