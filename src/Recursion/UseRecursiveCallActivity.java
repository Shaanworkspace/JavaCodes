package Recursion;

public class UseRecursiveCallActivity {
    static int doubleValue(int x) {
        return x * 2;
    }

    static void test() {
        doubleValue(10);   // ❌ doesn't do anything -> Learn that we have to make use of all recursive calls and functions
        System.out.println(doubleValue(10)); // ✅ prints 20
    }

    public static void main(String[] args) {
        test();
    }
}

