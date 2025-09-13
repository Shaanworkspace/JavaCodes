package LinkedList;

public class BasicLinkedListOperation {
    public static class ListNode{
        int data;
        ListNode next = null;
        public ListNode(int data) {
            this.data = data;
        }
    }
    public static int lengthOfLL(ListNode head){
        ListNode temp=head;
        int count=0;
        while(temp!=null){
            count++;
            temp=temp.next;
        }
        return count;
    }
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp= head;
        int len = lengthOfLL(head);
        if(len==1 && n==1) return head;
        for(int i =0;i<len-n-1;i++){
            temp=temp.next;
        }
        if(temp.next.next!=null){
            temp.next=temp.next.next;
        }
        return head;
    }
    public static void print(ListNode head){
        int len=0;
        ListNode temp = head;
        System.out.print("[ ");
        while(temp != null){
            System.out.print(temp.data+" ");
            len++;
            temp=temp.next;
        }
        System.out.print(" ]");

        System.out.println("Length of List :"+len);
    }

    public int lengthOfLinkedList(ListNode a){
        int len=0;
        ListNode temp =a;
        while(temp != null){

            temp=temp.next;
        }
        return len;
    }
    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        ListNode e = new ListNode(5);
        System.out.println(a);
        a.next=b;
        System.out.println(a.next); //basicLinkedList$Node@2a84aee7
        System.out.println(b); //basicLinkedList$Node@2a84aee7
//
        b.next=c;
        System.out.println(b.next); //basicLinkedList$Node@a09ee92
        System.out.println(c); //basicLinkedList$Node@a09ee92

        c.next=d;
        System.out.println(c.next);
        System.out.println(d);
        d.next=e;
        int len = lengthOfLL(a);
        System.out.println(len);
        System.out.println("----------------------------------------------");
        print(a);
        System.out.println("----------------------------------------------");
        ListNode result = removeNthFromEnd(a,1);
        print(result);

        System.out.println("---------------------------------------------length");
        BasicLinkedListOperation basicLinkedListOperation = new BasicLinkedListOperation();
        System.out.println(basicLinkedListOperation.lengthOfLinkedList(a));
    }
}
