package Trees.BinarySearchTree;
import java.util.*;

public class PredecessorAndSuccessorGFG {

	static class Node {
		int data;
		Node left, right;

		Node(int x) {
			data = x;
			left = right = null;
		}
	}

	public ArrayList<Node> findPreSucMethod1(Node root, int key) {
		ArrayList<Node> inorder = new ArrayList<>();
		helper(inorder,root);
//		for(Node a : inorder) System.out.print(a.data+" ");
		int n = inorder.size();
		for(int i =0;i<n;i++){
			if(inorder.get(i).data>key){
				Node succ = inorder.get(i);
				Node pre = null;
				if(i>0) pre = inorder.get(i-1);
				ArrayList<Node> res = new ArrayList<>();
				res.add(pre);
				res.add(succ);
				return res;
			} else if(inorder.get(i).data == key){
				Node succ = null;
				if(i<n-1) succ = inorder.get(i+1);

				Node pre = null;
				if(i>0) pre = inorder.get(i-1);
				ArrayList<Node> res = new ArrayList<>();
				res.add(pre);
				res.add(succ);
				return res;
			}
		}
		Node pre = inorder.size() > 0 ? inorder.get(inorder.size() - 1) : null;
		ArrayList<Node> res = new ArrayList<>();
		res.add(pre);
		res.add(null);
		return res;
	}

	private void helper(ArrayList<Node> arrayList, Node root) {
		if(root==null) return;
		helper(arrayList,root.left);
		arrayList.add(root);
		helper(arrayList,root.right);
	}

	public ArrayList<Node> findPreSucMethod2(Node root, int key) {
		return new ArrayList<>();
	}

	public ArrayList<Node> findPreSucMethod3(Node root, int key) {
		return new ArrayList<>();
	}

	private static void runTest(PredecessorAndSuccessorGFG solver,
	                            Node root, int key,
	                            Integer expectedPre, Integer expectedSuc,
	                            String testName) {

		System.out.println(testName);
		System.out.println("Key       : " + key);
		System.out.println("Expected  : [" + expectedPre + ", " + expectedSuc + "]");

		ArrayList<Node> m1 = solver.findPreSucMethod1(root, key);
		ArrayList<Node> m2 = solver.findPreSucMethod2(root, key);
		ArrayList<Node> m3 = solver.findPreSucMethod3(root, key);

		printResult("Method 1", m1, expectedPre, expectedSuc);
		printResult("Method 2", m2, expectedPre, expectedSuc);
		printResult("Method 3", m3, expectedPre, expectedSuc);

		System.out.println("--------------------------------------------\n");
	}

	private static void printResult(String method, ArrayList<Node> res,
	                                Integer expPre, Integer expSuc) {

		Integer pre = (res.size() > 0 && res.get(0) != null) ? res.get(0).data : null;
		Integer suc = (res.size() > 1 && res.get(1) != null) ? res.get(1).data : null;

		boolean pass = Objects.equals(pre, expPre) && Objects.equals(suc, expSuc);

		System.out.printf("%-15s : [%s, %s] %s%n",
				method,
				pre == null ? "null" : pre,
				suc == null ? "null" : suc,
				pass ? "PASS" : "FAIL");
	}

	public static void main(String[] args) {

		PredecessorAndSuccessorGFG solver = new PredecessorAndSuccessorGFG();

		System.out.println("=================================================");
		System.out.println("Predecessor and Successor in BST - Tests");
		System.out.println("=================================================\n");

		Node root1 = new Node(50);
		root1.left = new Node(30);
		root1.right = new Node(70);
		root1.left.left = new Node(20);
		root1.left.right = new Node(40);
		root1.right.left = new Node(60);
		root1.right.right = new Node(80);

		runTest(solver, root1, 65, 60, 70, "Test 1");

		Node root2 = new Node(8);
		root2.left = new Node(1);
		root2.right = new Node(9);
		root2.left.right = new Node(4);
		root2.left.right.left = new Node(3);
		root2.right.right = new Node(10);

		runTest(solver, root2, 8, 4, 9, "Test 2");
	}
}
