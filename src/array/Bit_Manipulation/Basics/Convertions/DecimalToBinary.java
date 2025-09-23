package array.Bit_Manipulation.Basics.Convertions;

public class DecimalToBinary {

    // Decimal → Binary
    public String decimalToBinary(int num) {
        if (num == 0) return "0"; // handle zero edge case
        StringBuilder binary = new StringBuilder();
        while (num > 0) {
            int remainder = num % 2;
            binary.append(remainder); // append either 0 or 1
            num = num / 2;
        }
        return binary.reverse().toString();
    }

    // Binary → Decimal
    public int binaryToDecimal(String binary) {
        int result = 0;
        for (int i = 0; i < binary.length(); i++) {
            char bit = binary.charAt(i);
            result = result * 2 + (bit - '0'); // (bit-'0') → numeric value
        }
        return result;
    }

    public static void main(String[] args) {
        DecimalToBinary converter = new DecimalToBinary();

        //  Test Case 1
        int num1 = 13;
        String bin1 = converter.decimalToBinary(num1);
        System.out.println("Decimal: " + num1 + " → Binary: " + bin1);
        System.out.println("Binary: " + bin1 + " → Decimal: " + converter.binaryToDecimal(bin1));

        //  Test Case 2
        int num2 = 42;
        String bin2 = converter.decimalToBinary(num2);
        System.out.println("Decimal: " + num2 + " → Binary: " + bin2);
        System.out.println("Binary: " + bin2 + " → Decimal: " + converter.binaryToDecimal(bin2));

        //  Test Case 3 (Edge case: zero stays zero)
        int num3 = 0;
        String bin3 = converter.decimalToBinary(num3);
        System.out.println("Decimal: " + num3 + " → Binary: " + bin3);
        System.out.println("Binary: " + bin3 + " → Decimal: " + converter.binaryToDecimal(bin3));
    }
}