package array.Bit_Manipulation.Basics;

public class Compliment1s {

    // Method to convert Binary → One's Complement Binary
    public String compliment1sConvert(String binary) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < binary.length(); i++) {
            char bit = binary.charAt(i);
            if (bit == '0') {
                result.append('1');
            } else if (bit == '1') {
                result.append('0');
            } else {
                throw new IllegalArgumentException("Invalid binary character: " + bit);
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Compliment1s converter = new Compliment1s();

        //  Test Case 1
        String bin1 = "00001101"; // 13 in 8-bit
        System.out.println("Binary: " + bin1 + " → 1's Complement: " + converter.compliment1sConvert(bin1));

        //  Test Case 2
        String bin2 = "10101010"; // alternating bits
        System.out.println("Binary: " + bin2 + " → 1's Complement: " + converter.compliment1sConvert(bin2));

        //  Test Case 3 (Edge: all 0s)
        String bin3 = "00000000";
        System.out.println("Binary: " + bin3 + " → 1's Complement: " + converter.compliment1sConvert(bin3));

        //  Test Case 4 (Edge: all 1s)
        String bin4 = "11111111";
        System.out.println("Binary: " + bin4 + " → 1's Complement: " + converter.compliment1sConvert(bin4));
    }
}