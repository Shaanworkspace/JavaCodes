package Trees.BinaryTree.Basics;

public class printNthLevelElements {
    public static class Node {
        int val;
        Node left;
        Node right;
        Node(int val) {
            this.val = val;
        }
    }

    public static int printNoOfLevel(Node root){
        if(root==null) return 0;
        if(root.left==null && root.right==null) return 0;
        return 1+Math.max(printNoOfLevel(root.left),printNoOfLevel(root.right));
    }

    //  Empty display method (your task to implement!)
    public static void printNthLevelLeftToRight(Node root, int level) {

        if(root==null) return;

        if(level==1) System.out.print(root.val +" ");

        printNthLevelLeftToRight(root.left,level-1);

        printNthLevelLeftToRight(root.right,level-1);
    }

    public static void printNthLevelRightToLeft(Node root,int level) {

        if(root==null) return;

        if(level==1) System.out.print(root.val +" ");

        printNthLevelRightToLeft(root.right,level-1);
        printNthLevelRightToLeft(root.left,level-1);

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
        printNthLevelLeftToRight(tree1,1);
        System.out.println("\nDisplay  size of Demo Tree 2:");
        printNthLevelLeftToRight(tree2,2);
        System.out.println("\nDisplay  size of Demo Tree 3:");
        printNthLevelLeftToRight(tree3,3);
    }
}
