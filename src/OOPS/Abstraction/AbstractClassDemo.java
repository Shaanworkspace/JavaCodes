package OOPS.Abstraction;
abstract class Vehicle {

    // Field
    String brand = "Generic Vehicle";

    // Static block
    static {
        System.out.println("Static block in abstract class executed.");
    }

    // Constructor
    Vehicle() {
        System.out.println("Constructor of abstract class called.");
    }

    // Abstract method (must be overridden)
    abstract void start();

    // Concrete method (with body)
    void stop() {
        System.out.println("Vehicle stopped.");
    }

    // Public method
    public void fuel() {
        System.out.println("Filling fuel in the vehicle.");
    }

    // Static method
    static void showInfo() {
        System.out.println("Static method in abstract class.");
    }

    // Final method (cannot be overridden)
    final void displayBrand() {
        System.out.println("Brand: " + brand);
    }
}

class Car extends Vehicle {

    // Implementing abstract method
    @Override
    void start() {
        System.out.println("Car started.");
    }
}

public class AbstractClassDemo {
    public static void main(String[] args) {
        Car myCar = new Car();

        myCar.start();          // Call implemented abstract method
        myCar.stop();           // Call concrete method
        myCar.fuel();           // Call public method
        myCar.displayBrand();   // Call final method

        Vehicle.showInfo();     // Call static method
    }
}
