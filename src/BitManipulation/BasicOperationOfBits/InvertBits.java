package BitManipulation.BasicOperationOfBits;

public class InvertBits {
	public void InvertBitMethod1(int a) {
		int temp = a;
		System.out.print("Bits of " + a + ": ");
		StringBuilder sc = new StringBuilder();

		while (temp > 0) {
			int curr = temp & 1;
			if (curr == 1) sc.append(0);
			else sc.append(1);

			temp >>= 1;
		}
		System.out.println(sc.reverse().toString());
	}

	public int InvertBitMethod2(int a) {
		return ~a;
	}
}
