package OOPS.Encapsulation.Private;

class Employee {
    private static final int salary = 50000; // private variable

    private static void displaySalary() { // private method
        System.out.println("Salary: " + salary);
    }

    public void showDetails() {
        displaySalary();  // Can access inside the same class
    }

    public static void main(String[] args) {
        System.out.println(salary);
        displaySalary();
    }
}