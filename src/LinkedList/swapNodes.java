package LinkedList;

public class swapNodes {
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
        System.out.println("Print functions =====================================");
    }

    public static ListNode swapNodes1(ListNode head, int k) {
        int len=0;
        ListNode temp =head;
        while(temp != null){
            len++;
            temp=temp.next;
        }

        if(k>len ) return head;

        System.out.println(k+k+"    "+len+"Length of linkedlist");
        temp =head;
        for(int i = 1;i<k-1;i++){
            temp=temp.next;
        }

        ListNode s1Prev = temp;
        ListNode s1=temp.next;
        temp =head;
        for(int i = 1;i<len-k;i++){
            temp=temp.next;
        }
        ListNode s2Prev = temp;
        ListNode s2=temp.next;
        if(k==len-k){
            s1Prev.next=s2;
            s1.next=s2.next;
            s2.next=s1;
            return head;
        }

        ListNode s2Next = s2.next;
        s2.next = s1.next;
        s1.next = s2Next;

        s1Prev.next=s2;
        s2Prev.next=s1;

        return head;
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
    public static void main(String[] args) {
        int[] arr = {1,2};

        System.out.println("Array: [7, 9, 6, 6, 7, 8, 3, 0, 9, 5]");

        ListNode a = arrayToLinkedList(arr);
        print(a);

        ListNode n = swapNodes1(a,1);

        System.out.println("+++++++++++++++++++++++++++");
        print(n);
    }
}
