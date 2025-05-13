package OOPS.Abstraction;

abstract class Animal {
    // Abstract method (does not have a body)
    abstract void sound();

    // Concrete method
    void eat() {
        System.out.println("This animal eats food.");
    }
}
