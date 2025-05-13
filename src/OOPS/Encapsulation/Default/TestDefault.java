package OOPS.Encapsulation.Default;

// In the same package
public class TestDefault {
    public static void main(String[] args) {
        Department d = new Department();
        d.showDept();  // ✅ Works fine within the same package
    }
}
