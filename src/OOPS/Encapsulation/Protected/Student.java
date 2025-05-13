package OOPS.Encapsulation.Protected;

public class Student extends Person {
    public void display() {
        System.out.println(name);  // ✅ Can access protected member through inheritance
        showName();                // ✅ Accessible in another package
    }

    public static void main(String[] args) {
        Student s = new Student();
        s.display();
    }
}
