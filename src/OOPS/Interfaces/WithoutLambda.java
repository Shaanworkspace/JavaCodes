package OOPS.Interfaces;

import java.util.ArrayList;
import java.util.LinkedList;

@FunctionalInterface
interface functionalInterface {
    abstract void print();
    default void shaa(){
        System.out.println("shaan");
    }
    static void shan(){
        System.out.println("saaa");
    }

    public static final int s =9;
    static void s(){
        System.out.println(s);
    }
}

@FunctionalInterface
interface Printer {
    void printMessage();
}

public class WithoutLambda {
    public static void main(String[] args) {
        // Using anonymous inner class
        Printer printer = new Printer() {
            @Override
            public void printMessage() {
                System.out.println("shaan");
            }
        };
        printer.printMessage();

        functionalInterface f = new functionalInterface() {
            @Override
            public void print() {
                System.out.println("print of functional interface");
            }
        };
        f.print();
        functionalInterface flam = ()->{
            System.out.println("flam lambda");
        };
        flam.print();
        flam.shaa();
        LinkedList<Integer> a = new LinkedList<>();
    }
}