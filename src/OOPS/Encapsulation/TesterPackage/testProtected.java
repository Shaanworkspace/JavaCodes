package OOPS.Encapsulation.TesterPackage;


import OOPS.Encapsulation.Protected.Person;

public class testProtected extends Person {
    public void display() {
        System.out.println(name);  // ✅ Can access protected member through inheritance
        showName();                // ✅
    }

    public static void main(String[] args) {
        testProtected s = new testProtected();
        s.display();
    }
}
