package LinkedList.Basics.Insertion;



public class InsertAtEnd {
    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    Node insertAtEnd(Node head, int data) {
        Node newNode = new Node(data);


        System.out.println("Inserted " + data + " at the end.");
        printVisualList(head);
        System.out.println("------------------------------------");

        return head;
    }

    void printVisualList(Node head) {
        if (head == null) {
            System.out.println("[empty list]");
            return;
        }

        Node temp = head;
        while (temp != null) {
            System.out.print("[" + temp.data + "]");
            if (temp.next != null) System.out.print(" ⇒ ");
            temp = temp.next;
        }
        System.out.println(" ⇒ null");
    }

    public static void main(String[] args) {
        InsertAtEnd listOps = new InsertAtEnd();
        Node head = null;

        System.out.println("=== Starting Linked List Insertions at End ===\n");

        head = listOps.insertAtEnd(head, 10);
        head = listOps.insertAtEnd(head, 20);
        head = listOps.insertAtEnd(head, 30);
        head = listOps.insertAtEnd(head, 40);
        head = listOps.insertAtEnd(head, 50);

        System.out.println("\n=== Final Linked List State ===");
        listOps.printVisualList(head);
    }
}