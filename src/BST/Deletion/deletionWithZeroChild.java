package BST.Deletion;
import BST.SearchInsertInBST;
import BST.TreeNode;

public class deletionWithZeroChild {
    
//    public TreeNode delete(TreeNode node,int target){
//        if(node == null) return node;
//        if(node.val == target){
//
//        }
//
//    }
    public static void main(String[] args) {
        TreeNode node = new TreeNode();
        SearchInsertInBST searchInsertInBST = new SearchInsertInBST();
        int[] values = {1,2,3,4,5,6,7,8};
        for(int v : values){
            searchInsertInBST.insert(node , v);
        }

    }
}
