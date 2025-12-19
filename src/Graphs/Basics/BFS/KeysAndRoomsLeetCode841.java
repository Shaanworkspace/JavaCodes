package Graphs.Basics.BFS;

import java.util.*;

public class KeysAndRoomsLeetCode841 {

	public boolean canVisitAllRoomsBrute(List<List<Integer>> rooms) {
		int n = rooms.size();
		boolean[] key = new boolean[n];
		Queue<Integer> queue = new LinkedList<>();
		key[0]=true;
		queue.offer(0);
		while(!queue.isEmpty()){
			int curr = queue.poll();
			for(int a: rooms.get(curr)){
				if(!key[a]){
					key[a]=true;
					queue.offer(a);
				}
			}
		}
		for (boolean result:key){
			if(!result){
				return false;
			}
		}
		return true;
	}

	public boolean canVisitAllRoomsTryYourSelf(List<List<Integer>> rooms) {
		return false;
	}

	public boolean canVisitAllRooms(List<List<Integer>> rooms) {
		return false;
	}

	private static void runTest(KeysAndRoomsLeetCode841 solver,
	                            List<List<Integer>> rooms, boolean expected, String name) {
		System.out.println(name);
		System.out.println("Input : " + rooms);
		boolean brute = solver.canVisitAllRoomsBrute(rooms);
		boolean your  = solver.canVisitAllRoomsTryYourSelf(rooms);
		boolean opt   = solver.canVisitAllRooms(rooms);

		System.out.println("Expected : " + expected);
		System.out.printf("Brute Force      : %-6b%n", brute);
		System.out.printf("TryYourSelf      : %-6b%n", your);
		System.out.printf("Optimized (O(n+E)) : %-6b%n", opt);
		System.out.println("--------------------------------------------\n");
	}

	public static void main(String[] args) {
		KeysAndRoomsLeetCode841 solver = new KeysAndRoomsLeetCode841();

		List<List<Integer>> rooms1 = new ArrayList<>();
		rooms1.add(List.of(1));
		rooms1.add(List.of(2));
		rooms1.add(List.of(3));
		rooms1.add(Collections.emptyList());

		List<List<Integer>> rooms2 = new ArrayList<>();
		rooms2.add(Arrays.asList(1,3));
		rooms2.add(Arrays.asList(3,0,1));
		rooms2.add(List.of(2));
		rooms2.add(List.of(0));

		List<List<Integer>> rooms3 = new ArrayList<>();
		rooms3.add(Arrays.asList(6,7,8));
		rooms3.add(Arrays.asList(5,9,4));
		rooms3.add(List.of());
		rooms3.add(List.of(8));
		rooms3.add(List.of(4));
		rooms3.add(List.of());
		rooms3.add(Arrays.asList(1,9,2,3));
		rooms3.add(List.of(7));
		rooms3.add(Arrays.asList(6,5));
		rooms3.add(List.of(2,3,1));

		runTest(solver, rooms1, true,  "Test 1");
		runTest(solver, rooms2, false, "Test 2");
		runTest(solver, rooms3, true,  "Important - Test 3");
	}
}