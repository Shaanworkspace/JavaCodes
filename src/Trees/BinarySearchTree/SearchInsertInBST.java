package Trees.BinarySearchTree;
public class SearchInsertInBST {
    public boolean search(TreeNode node , int target){
        if(node == null) return false;
        if(node.val == target)
            return true;
        if(node.val < target)
            return search(node.right,target);
        else
            return search(node.left,target);
    }

     public TreeNode insert (TreeNode node ,int value){
        TreeNode node1 =new TreeNode(value);
        if(node==null){
            node = node1;
            return node;
        }
        if(node.val < value)
            node.right = insert(node.right,value);
        else
            node.left = insert(node.left,value);
        return node;
    }
    public static void main(String[] args) {
        TreeNode node = new TreeNode();
        SearchInsertInBST searchInsertInBST = new SearchInsertInBST();
        int[] values = {1,2,3,4,5,6,7,8};
        for(int v : values){
            searchInsertInBST.insert(node , v);
        }
        System.out.println(searchInsertInBST.search(node,40));
    }
}
