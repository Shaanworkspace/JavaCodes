package Trees.BinaryTree.Basics.Traversal;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.LinkedTransferQueue;

public class bfs {
    public static class Node {
        int val;
        Node left;
        Node right;
        Node(int val) {
            this.val = val;
        }
    }

    public static void bfsTraversal(Node root) {
        Queue<Node> queue = new LinkedList<>();
        if(root!=null) queue.add(root);
        while(!queue.isEmpty()){
            Node temp = queue.peek();
            if(temp.left!=null) queue.add(temp.left);
            if(temp.right!=null) queue.add(temp.right);
            System.out.println(temp.val+" ");
            queue.remove();
        }
    }

    //  Helper method to construct a demo tree
    public static Node createDemoTree1() {
        /*
              1
             / \
            2   3
           / \
          4   5
        */
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        return root;
    }

    //  Second demo tree
    public static Node createDemoTree2() {
        /*
              10
               \
                20
                 \
                  30
        */
        Node root = new Node(10);
        root.right = new Node(20);
        root.right.right = new Node(30);
        return root;
    }

    //  Third demo tree
    public static Node createDemoTree3() {
        /*
              7
             /
            3
           / \
          1   5
         /
        1
        */
        Node root = new Node(7);
        root.left = new Node(3);
        root.left.left = new Node(1);
        root.left.left.left = new Node(1);
        root.left.right = new Node(5);
        return root;
    }

    //  Main to test your display() method
    public static void main(String[] args) {
        Node tree1 = createDemoTree1();
        Node tree2 = createDemoTree2();
        Node tree3 = createDemoTree3();

        System.out.println("Display size of Demo Tree 1:");
        bfsTraversal(tree1);
        System.out.println("\nDisplay  size of Demo Tree 2:");
        bfsTraversal(tree2);
        System.out.println("\nDisplay  size of Demo Tree 3:");
        bfsTraversal(tree3);
    }
}
