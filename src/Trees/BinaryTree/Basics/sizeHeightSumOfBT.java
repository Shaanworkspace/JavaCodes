package Trees.BinaryTree.Basics;

public class sizeHeightSumOfBT {
    public static class Node {
        int val;
        Node left;
        Node right;
        Node(int val) {
            this.val = val;
        }
    }

    //  Empty display method (your task to implement!)
    public static int size(Node root) {
        if(root==null) return 0;
        // our work is to get the sum of left and right then add the root vala node in it and return
        int left = size(root.left);
        int right = size(root.right);
        return 1+left+right;
    }

    public static int height(Node root) {
        if (root == null) return 0;
        int left = height(root.left);
        int right = height(root.right);
        return 1 + Math.max(left, right);
    }

    public static int sumOfTree(Node root) {
        if(root==null) return 0;
        // our work is to get the sum of left and right then add the root vala node in it and return
        int left = sumOfTree(root.left);
        int right = sumOfTree(root.right);
        return root.val +left+right;
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
        */
        Node root = new Node(7);
        root.left = new Node(3);
        root.left.left = new Node(1);
        root.left.right = new Node(5);
        return root;
    }

    //  Main to test your display() method
    public static void main(String[] args) {
        Node tree1 = createDemoTree1();
        Node tree2 = createDemoTree2();
        Node tree3 = createDemoTree3();

        System.out.println("Display size of Demo Tree 1:");
        System.out.println(size(tree1));
        System.out.println(sumOfTree(tree1));
        System.out.println("\nDisplay  size of Demo Tree 2:");
        System.out.println(size(tree2));
        System.out.println(sumOfTree(tree2));
        System.out.println("\nDisplay  size of Demo Tree 3:");
        System.out.println(size(tree3));
        System.out.println(sumOfTree(tree3));
    }
}
