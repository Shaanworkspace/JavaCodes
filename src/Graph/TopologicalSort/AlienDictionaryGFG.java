package Graph.TopologicalSort;

import java.util.*;

public class AlienDictionaryGFG {

	// BFS Topo Sort -> inbound
	public String findOrderTopoBFS(String[] words) {

		List<List<Integer>> adj = new ArrayList<>();
		for (int i = 0; i < 26; i++) {
			adj.add(new ArrayList<>());
		}

		boolean[] present = new boolean[26];

		int countPresent=0;
		for (String word : words) {
			for (char c : word.toCharArray()) {
				if (!present[c - 'a']) {   // ✅ only count once
					present[c - 'a'] = true;
					countPresent++;
				}
			}
		}

		int n = words.length;
		int[] inbound = new int[26];
		for (int i = 0; i < n - 1; i++) {
			String s1 = words[i];
			String s2 = words[i + 1];

			if (s1.length() > s2.length() && s1.startsWith(s2)) {
				return "";
			}

			//compare until difference
			int len = Math.min(s1.length(), s2.length());
			for (int a = 0; a < len; a++) {
				if (s1.charAt(a) == s2.charAt(a)) continue;

				int u = s1.charAt(a) - 'a';
				int v = s2.charAt(a) - 'a';

				adj.get(u).add(v);
				inbound[v]++;
				break;
			}
		}

		StringBuilder s = new StringBuilder();
		Queue<Integer> queue = new ArrayDeque<>();

		//adding all 0 inbound
		for (int i = 0; i < inbound.length; i++) if (present[i] && inbound[i] == 0) queue.add(i);

		while (!queue.isEmpty()) {
			int curr = queue.poll();
			s.append((char)(curr + 'a'));

			for (int nei : adj.get(curr)) {
				inbound[nei]--;
				if (inbound[nei] == 0) {
					queue.add(nei);
				}
			}
		}
		if (s.length() != countPresent) return "";
		return s.toString();
	}

	public String findOrderMethod2(String[] words) {
		return "";
	}

	public String findOrderMethod3(String[] words) {
		return "";
	}

	private static void runTest(AlienDictionaryGFG solver,
	                            String[] words, boolean isValidExpected, String testName) {

		System.out.println(testName);
		System.out.println("Input     : words = " + Arrays.toString(words));
		System.out.println("Expected  : " + isValidExpected);

		String m1 = solver.findOrderTopoBFS(words);
		String m2 = solver.findOrderMethod2(words);
		String m3 = solver.findOrderMethod3(words);

		System.out.printf("Method 1         : %-10s %s%n",
				m1, validate(words, m1) == isValidExpected ? "PASS" : "FAIL");
		System.out.printf("Method 2         : %-10s %s%n",
				m2, validate(words, m2) == isValidExpected ? "PASS" : "FAIL");
		System.out.printf("Method 3         : %-10s %s%n",
				m3, validate(words, m3) == isValidExpected ? "PASS" : "FAIL");

		System.out.println("--------------------------------------------\n");
	}

	// Driver-like validation
	private static boolean validate(String[] words, String order) {
		if (order == null || order.isEmpty()) return false;

		int[] pos = new int[26];
		for (int i = 0; i < order.length(); i++) {
			pos[order.charAt(i) - 'a'] = i;
		}

		for (int i = 0; i < words.length - 1; i++) {
			String w1 = words[i];
			String w2 = words[i + 1];

			int len = Math.min(w1.length(), w2.length());
			boolean found = false;

			for (int j = 0; j < len; j++) {
				if (w1.charAt(j) != w2.charAt(j)) {
					if (pos[w1.charAt(j) - 'a'] > pos[w2.charAt(j) - 'a']) {
						return false;
					}
					found = true;
					break;
				}
			}

			if (!found && w1.length() > w2.length()) return false;
		}

		return true;
	}

	static void main() {

		AlienDictionaryGFG solver = new AlienDictionaryGFG();

		System.out.println("=================================================");
		System.out.println("Alien Dictionary - Tests");
		System.out.println("=================================================\n");

		runTest(solver,
				new String[]{"baa", "abcd", "abca", "cab", "cad"},
				true,
				"Test 1");

		runTest(solver,
				new String[]{"caa", "aaa", "aab"},
				true,
				"Test 2");

		runTest(solver,
				new String[]{"ab", "cd", "ef", "ad"},
				false,
				"Test 3");
	}
}