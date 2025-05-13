package OOPS.Encapsulation.Private;

public class TestPrivate {
    public static void main(String[] args) {
        Employee emp = new Employee();
        emp.showDetails();       // ✅ Allowed (public method calls private inside)
        // emp.salary;            // ❌ Error: salary has private access
        // emp.displaySalary();   // ❌ Error: displaySalary() has private access
    }
}
