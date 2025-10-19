package array;

import java.util.*;

public class ComputeDecimalRepresentationLC {

    // Optimized or clean solution
    public int[] decimalRepresentation(int n) {

        return new int[0];
    }


    public int[] decimalRepresentationBrute(int n) {
        List<Integer> result = new ArrayList<>();
        int temp = n,i=1,factor=1;
        while (temp > 0) {
            int ch =  temp % 10;
            if(ch>0){
                result.add(ch*factor);
            }
            temp /= 10;
            factor *= 10;
        }
        java.util.Collections.reverse(result);
        return result.stream().mapToInt(in -> in).toArray();
    }


    public void printArray(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i != arr.length - 1) System.out.print(", ");
        }
        System.out.println("]");
    }

    // 💥 Stylish PSVM (Main Test Runner)
    public static void main(String[] args) {
        ComputeDecimalRepresentationLC solver = new ComputeDecimalRepresentationLC();

        System.out.println("====================================");
        System.out.println("     Decimal Representation Tests    ");
        System.out.println("====================================\n");

        int[] tests = {537, 102, 6, 90040};
        String[] expected = {
                "[500, 30, 7]",
                "[100, 2]",
                "[6]",
                "[90000, 40]"
        };

        for (int i = 0; i < tests.length; i++) {
            System.out.printf("🔹 Test %d%n", i + 1);
            System.out.println("------------------------------------");
            System.out.println("Input Number : " + tests[i]);
            System.out.println("Expected     : " + expected[i]);
            System.out.print("Got          : ");
            solver.printArray(solver.decimalRepresentationBrute(tests[i]));
            System.out.println();
        }

        System.out.println("====================================");
        System.out.println("        ✅  All Tests Executed        ");
        System.out.println("====================================");
    }
}