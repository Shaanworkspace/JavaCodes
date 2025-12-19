package Trees.BinarySearchTree.Deletion;

public class DeleteFor0Child {

    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) { this.val = val; }
    }

    // Trees.BST insert helper
    static TreeNode insert(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);
        if (val < root.val) root.left = insert(root.left, val);
        else root.right = insert(root.right, val);
        return root;
    }

    // Print inorder
    static void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        System.out.print(root.val + " ");
        inorder(root.right);
    }

    // 🔹 Delete only leaf nodes (0‑child case)
    static TreeNode delete(TreeNode root, int key) {
        if (root == null) return null;
        if(root.val == key){
            //check to delete only the end nodes
            if (root.left == null && root.right == null) {
                return null;
            }
        }
        else if(root.val>key){
            root.left = delete(root.left,key);
        }
        else if(root.val<key){
            root.right = delete(root.right,key);
        }
        return root;
    }

    static void deleteOptimised(TreeNode root, int key) {
        if (root == null) return;
        if(root.val>key){
            if (root.left == null) return;
            if(root.left.val==key){
                root.left=null;
            } else{
                delete(root.left,key);
            }
        }
        else{
            if (root.right == null) return;
            if(root.right.val ==key){
                root.right=null;
            }
            else delete(root.right,key);
        }
        return;
    }

    public static void main(String[] args) {
        TreeNode root = null;
        int[] vals = {5, 3, 8, 2, 4, 7, 9};
        for (int v : vals) root = insert(root, v);

        System.out.print("Before deletion: ");
        inorder(root);
        System.out.println();

//        root = delete(root, 8); // 9 is a leaf node
        deleteOptimised(root, 8);
        System.out.print("After deleting leaf (9): ");
        inorder(root);
    }
}
