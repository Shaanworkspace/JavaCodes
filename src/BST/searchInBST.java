package BST;

import com.sun.source.tree.Tree;

public class searchInBST {
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(){}
        TreeNode(int val){
            this.val=val;
        }
        TreeNode(int val, TreeNode left , TreeNode right){
            this.val=val;
            this.left=left;
            this.right=right;
        }
    }
    static boolean search(TreeNode node , int target){
        if(node == null) return false;
        if(node.val == target)
            return true;
        if(node.val < target)
            search(node.right,target);
        else
            search(node.left,target);
        return false;
    }

     static TreeNode insert (TreeNode node ,int value){
        TreeNode node1 =new TreeNode(value);
        if(node==null){
            node = node1;
            return node;
        }
        if(node.val < value)
            insert(node.right,value);
        else
            insert(node.left,value);
        return node;
    }
    public static void main(String[] args) {
        TreeNode node = new TreeNode();
        int[] values = {1,2,3,4,5,6,7,8};


    }
}
