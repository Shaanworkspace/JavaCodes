package Trees.BinarySearchTree.Deletion;

import java.awt.image.renderable.RenderableImageOp;

public class DeleteFor1Child {

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

    // Delete node with 1‑child case
    static TreeNode delete(TreeNode root, int key) {
        if(root == null) return  null;
        if(root.val > key){
            if((root.val==key) && (root.left==null && root.right==null)){

            }
            if(root.left != null && root.left.val ==key){
                root.left = (root.left.left !=null)?root.left.left:root.left.right;
                return root;
            }
            else {
                return delete(root.left,key);
            }
        }
        else if(root.val < key){
            if(root.right != null && root.right.val ==key){
                root.right = (root.right.left !=null)?root.right.left:root.right.right;
                return root;
            }
            else {
                return delete(root.right,key);
            }
        }
        return root;
    }

    static TreeNode deleteOptimised(TreeNode root, int key) {
        /*
        Go according to the thinking process as
        -> as agr root.val > key then we need ki hamra root ke left pe delete ho --> root.left=delet(root.left,key)
        -> as agr root.val<key then we need ki hamara root ke right pe delete ho --> root.right=delet(root.right,key)
        -> as agr root.val==key then means yhi node h jo delete krna h, mai iske aage ka node trasfer kr du taki left ya right pe attach ho jy

         */

        if (root == null) return null;

        if(root.val <key){
            root.right=deleteOptimised(root.right,key);
        } else if(root.val>key){
            root.left = deleteOptimised(root.left,key);
        } else{
            if (root.left == null)
                return root.right;
            else
                return root.left;
        }

        return root;
    }

    public static void main(String[] args) {
        TreeNode root = null;
        int[] vals = {10, 5, 15, 12,11,6};
        for (int v : vals) root = insert(root, v);

        System.out.print("Before deletion: ");
        inorder(root);
        System.out.println();

        int key = 5;
        root = deleteOptimised(root, key); // 15 has one child (12)

        System.out.print("After deleting node ("+key+") with 1 child: ");
        inorder(root);
    }
}
