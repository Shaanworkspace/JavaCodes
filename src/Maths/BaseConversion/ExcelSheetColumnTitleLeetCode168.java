package Maths.BaseConversion;

import java.util.*;

public class ExcelSheetColumnTitleLeetCode168 {

	public String convertToTitleMethod1(int columnNumber) {
		StringBuilder sc = new StringBuilder();
		while (columnNumber>0){
			columnNumber--;
			int num = columnNumber%26;
			sc.append((char)('A'+num));
			columnNumber /=26;
		}
		return sc.reverse().toString();
	}

	public String convertToTitleMethod2(int columnNumber) {
		return "";
	}

	public String convertToTitleMethod3(int columnNumber) {
		return "";
	}

	private static void runTest(ExcelSheetColumnTitleLeetCode168 solver,
	                            int columnNumber, String expected, String testName) {

		System.out.println(testName);
		System.out.println("Input     : columnNumber = " + columnNumber);
		System.out.println("Expected  : \"" + expected + "\"");

		String m1 = solver.convertToTitleMethod1(columnNumber);
		String m2 = solver.convertToTitleMethod2(columnNumber);
		String m3 = solver.convertToTitleMethod3(columnNumber);

		System.out.printf("Method1   : %-10s %s%n",
				"\"" + m1 + "\"", m1.equals(expected) ? "PASS" : "FAIL");
		System.out.printf("Method2   : %-10s %s%n",
				"\"" + m2 + "\"", m2.equals(expected) ? "PASS" : "FAIL");
		System.out.printf("Method3   : %-10s %s%n",
				"\"" + m3 + "\"", m3.equals(expected) ? "PASS" : "FAIL");

		System.out.println("--------------------------------------------\n");
	}

	public static void main(String[] args) {
		ExcelSheetColumnTitleLeetCode168 solver = new ExcelSheetColumnTitleLeetCode168();

		System.out.println("=================================================");
		System.out.println("Excel Sheet Column Title - Tests");
		System.out.println("=================================================\n");

		runTest(solver, 1, "A", "Test 1");
		runTest(solver, 28, "AB", "Test 2");
		runTest(solver, 701, "ZY", "Test 3");
	}
}