package array.Bit_Manipulation.Basics.OperationOnBinary;

public class additionOnBinary {
    public static String addBinary(String A, String B,int k) {
        StringBuilder  result = new StringBuilder();
        int carry=0;
        for(int i = k-1; i >= 0; i--){

            // convert char -→ int (as we have binary in String so we need number to perform addition )
            int bitA = A.charAt(i) - '0';
            int bitB = B.charAt(i) - '0';


            int sum = bitA + bitB + carry;

            // Sum bit = remainder when dividing by 2
            result.append(sum % 2);

            // Carry = quotient when dividing by 2
            carry = sum / 2;
        }
        // Handle overflow carry
        if (carry == 1) {
            result.append('1');
        }

        // We appended bits in reverse order → reverse before returning
        return result.reverse().toString();
    }
    public static void main(String[] args) {
        // Test Case 1: 13 (1101) + 1 (0001)
        String A = "00001101"; // 13 in 8-bit
        String B = "00000001"; // 1
        System.out.println("A: " + A + " + B: " + B + " = " + addBinary(A, B, 8));

        // Test Case 2: 42 (101010) + 5 (000101) padded to 8 bits
        String C = "00101010"; // 42
        String D = "00000101"; // 5
        System.out.println("C: " + C + " + D: " + D + " = " + addBinary(C, D, 8));

        // Test Case 3: edge case - overflow (255 + 1 in 8-bit)
        String E = "11111111"; // 255
        String F = "00000001"; // 1
        System.out.println("E: " + E + " + F: " + F + " = " + addBinary(E, F, 8));
    }
}
