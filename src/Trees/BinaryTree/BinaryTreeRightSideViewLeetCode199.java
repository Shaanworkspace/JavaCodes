package Trees.BinaryTree;
import java.util.*;

public class BinaryTreeRightSideViewLeetCode199 {

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode() {}
		TreeNode(int val) { this.val = val; }
		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}

	public List<Integer> rightSideViewBFS(TreeNode root) {
		List<Integer> add = new ArrayList<>();
		if(root==null) return add;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		while(!queue.isEmpty()){
			int si = queue.size();
			for(int i =0;i<si;i++){
				TreeNode curr = queue.poll();
				if(i==si-1){
					add.add(curr.val);
				}
				if(curr.left!=null) queue.offer(curr.left);
				if(curr.right!=null) queue.offer(curr.right);
			}
		}
		return add;
	}

	public List<Integer> rightSideViewTryYourSelf(TreeNode root) {
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> add = new ArrayList<>();
		int h = findHeight(root);
		for(int i=0;i<h;i++){
			levelTraver(root,i,add);
			result.add(add);
			add = new ArrayList<>();
		}
		add = new ArrayList<>();
		for(List<Integer> a : result){
			add.add(a.getLast());
		}
		return add;
	}

	private static void levelTraver(TreeNode root, int level, List<Integer> add) {
		if(root==null || level<0) return;
		if(level==0){
			add.add(root.val);
			return;
		}
		if(root.right!=null) levelTraver(root.right,level-1,add);
		if(root.left!=null) levelTraver(root.left,level-1,add);
	}


	private static int findHeight(TreeNode root) {
		if(root==null) return 0;
		return 1+Math.max(findHeight(root.left),findHeight(root.right));
	}

	public List<Integer> rightSideView(TreeNode root) {
		return null;
	}

	private static void runTest(BinaryTreeRightSideViewLeetCode199 solver,
	                            TreeNode root, List<Integer> expected, String name) {
		System.out.println(name);

		List<Integer> brute = solver.rightSideViewBFS(root);
		List<Integer> your  = solver.rightSideViewTryYourSelf(root);
		List<Integer> opt   = solver.rightSideView(root);

		System.out.println("Expected         : " + expected);
		System.out.println("Brute Force      : " + brute);
		System.out.println("TryYourSelf      : " + your);
		System.out.println("Optimized        : " + opt);
		System.out.println("--------------------------------------------\n");
//
//		List<Integer> brute1 = solver.rightSideViewBrute(root);
//		List<Integer> your1  = solver.rightSideViewTryYourSelf(root);
//		List<Integer> opt1  = solver.rightSideView(root);
//
//		System.out.println("Expected         : " + expected);
//		System.out.println("Brute Force      : " + brute1);
//		System.out.println("TryYourSelf      : " + your1);
//		System.out.println("Optimized        : " + opt1);
//		System.out.println("--------------------------------------------\n");
	}

	public static void main(String[] args) {
		BinaryTreeRightSideViewLeetCode199 solver = new BinaryTreeRightSideViewLeetCode199();

		TreeNode root1 = new TreeNode(1,
				new TreeNode(2, null, new TreeNode(5)),
				new TreeNode(3, null, new TreeNode(4))
		);

		TreeNode root2 = new TreeNode(1,
				new TreeNode(2, new TreeNode(4, new TreeNode(5), null), null),
				new TreeNode(3)
		);

		TreeNode root3 = new TreeNode(1, null, new TreeNode(3));

		TreeNode root4 = null;

		TreeNode root5 = new TreeNode(1,
				new TreeNode(2, new TreeNode(4), null),
				new TreeNode(3)
		);

		TreeNode root6 = new TreeNode(1,
				new TreeNode(2),
				null
		);

		TreeNode root7 = new TreeNode(70,
				new TreeNode(50, new TreeNode(25,new TreeNode(23,new TreeNode(21,null,new TreeNode(22)),null),new TreeNode(35,new TreeNode(34),null)), new TreeNode(60)),
				new TreeNode(80, null,null));

		runTest(solver, root1, Arrays.asList(1, 3, 4), "Test 1");
		runTest(solver, root2, Arrays.asList(1, 3, 4, 5), "Test 2");
		runTest(solver, root3, Arrays.asList(1, 3), "Test 3");
		runTest(solver, root4, Arrays.asList(), "Test 4 - Empty tree");
		runTest(solver, root5, Arrays.asList(1, 3, 4), "Test 5");
		runTest(solver, root6, Arrays.asList(1, 2), "Test 6 - Left only");
		runTest(solver, root7, Arrays.asList(70, 80, 60, 35, 34,22), "Test 7 - Full tree");
	}
}