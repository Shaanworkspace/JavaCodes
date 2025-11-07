package LinkedList.Basics.Insertion;


public class InsertAtBeginning {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    Node insertAtBeginning(Node head, int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;

        // Visual narration
        System.out.println("🟢 Inserted " + data + " at the beginning.");
        System.out.println("   ↳ New head is now: [" + head.data + "]");
        printVisualList(head);
        System.out.println("------------------------------------");

        return head;
    }

    // Pretty visual print of the list
    void printVisualList(Node head) {
        if (head == null) {
            System.out.println("[empty list]");
            return;
        }
        Node temp = head;
        while (temp != null) {
            System.out.print("[" + temp.data + "]");
            if (temp.next != null) System.out.print(" → ");
            temp = temp.next;
        }
        System.out.println(" → null");
    }

    public static void main(String[] args) {
        InsertAtBeginning listOps = new InsertAtBeginning();
        Node head = null;

        System.out.println("=== Starting Linked List Insertions at Beginning ===\n");

        head = listOps.insertAtBeginning(head, 50);
        head = listOps.insertAtBeginning(head, 40);
        head = listOps.insertAtBeginning(head, 30);
        head = listOps.insertAtBeginning(head, 20);
        head = listOps.insertAtBeginning(head, 10);

        System.out.println("\n✅ Final Linked List State:");
        listOps.printVisualList(head);
    }
}