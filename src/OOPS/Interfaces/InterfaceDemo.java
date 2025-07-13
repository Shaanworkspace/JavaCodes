package OOPS.Interfaces;

interface MyInterface {

    // Abstract method (must be implemented by implementing class)
    void abstractMethod();

    // Default method (since Java 8)
    default void defaultMethod() {
        System.out.println("This is a default method.");
        commonPrivateMethod();
    }

    // Another default method using private method
    default void anotherDefaultMethod() {
        System.out.println("This is another default method.");
        commonPrivateMethod();
    }

    // Static method (since Java 8)
    static void staticMethod() {
        System.out.println("This is a static method.");
    }

    // Private method (since Java 9)
    private void commonPrivateMethod() {
        System.out.println("This is a private method used by default methods.");
    }
}

class MyClass implements MyInterface {

    @Override
    public void abstractMethod() {
        System.out.println("Implementation of abstract method.");
    }
}

public class InterfaceDemo {
    public static void main(String[] args) {
        MyClass obj = new MyClass();

        obj.abstractMethod();         // Call abstract method
        obj.defaultMethod();          // Call default method
        obj.anotherDefaultMethod();   // Call another default method

        MyInterface.staticMethod();   // Call static method
    }
}
