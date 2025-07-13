package OOPS.Interfaces;


interface Flyable {
    void fly();
}

interface Swimmable {
    void fly();
}

public class multiInheritance implements Flyable, Swimmable {
    public void fly() {
        System.out.println("Duck is flying.");
    }

    public static void main(String[] args) {
        multiInheritance m = new multiInheritance();
        m.fly();
    }
}
