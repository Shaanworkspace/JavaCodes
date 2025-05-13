package OOPS.Abstraction;

public class TestAbstraction {
    public static void main(String[] args) {
        Animal a = new Dog();  // Upcasting
        a.sound();  // Outputs: Dog barks
        a.eat();    // Outputs: This animal eats food.
    }
}
