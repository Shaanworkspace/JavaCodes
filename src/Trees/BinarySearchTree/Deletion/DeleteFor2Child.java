package Trees.BinarySearchTree.Deletion;

import com.sun.source.tree.Tree;

public class DeleteFor2Child {

    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) { this.val = val; }
    }

    static TreeNode insert(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);
        if (val < root.val) root.left = insert(root.left, val);
        else root.right = insert(root.right, val);
        return root;
    }

    static void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        System.out.print(root.val + " ");
        inorder(root.right);
    }

    // Find smallest in right subtree
    static TreeNode findMin(TreeNode node) {
        while (node.left != null) node = node.left;
        return node;
    }

    // 🔹 Delete node with 2‑children case
    static TreeNode delete(TreeNode root, int key) {
        if (root == null) return null;

        if (key < root.val) root.left = delete(root.left, key);
        else if (key > root.val) root.right = delete(root.right, key);
        else {
            // Found the node
            if (root.left != null && root.right != null) {
                TreeNode succ = findMin(root.right);
                root.val = succ.val;
                root.right = delete(root.right, succ.val);
            }
        }
        return root;
    }

    static void deleteOptimised(TreeNode root, int key) {
        if (root == null) return;
        if(root.val>key){
            if (root.left == null) return;
            if(root.left.val==key){
                TreeNode next = root.left;
                if(next.left==null && next.right==null){
                    root.left=null;
                }
                if(next.left!=null || next.right!=null){
                    root.left = (next.left!=null)?next.left:next.right;
                }

            } else{
                delete(root.left,key);
            }
        }
        else{
            if (root.right == null) return;
            if(root.right.val==key){
                TreeNode next = root.right;
                if(next.left==null && next.right==null){
                    root.right=null;
                }
                if(next.left!=null || next.right!=null){
                    root.right = (next.left!=null)?next.left:next.right;
                }
            }
            else delete(root.right,key);
        }
        return;
    }

    public static void main(String[] args) {
        TreeNode root = null;
        int[] vals = {20, 10, 30, 5, 15, 25, 35};
        for (int v : vals) root = insert(root, v);

        System.out.print("Before deletion: ");
        inorder(root);
        System.out.println();
        int key = 35;
//        root = delete(root, 20); // 20 has 2 children (10, 30)
        deleteOptimised(root, key);
        System.out.print("After deleting node ("+key+") with 2 children: ");
        inorder(root);
    }
}