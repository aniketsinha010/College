package OOPs.A05.Abstract;

public class Main {
    public static void main(String[] args) {
        System.out.println();

        Son son = new Son(21);
        son.career("teacher");
        System.out.println();

        Daughter daughter = new Daughter(18);
        daughter.career("doctor");
        System.out.println();

        // Parent mom = new Parent();
        // You cant create objects of an Abstract class...

        Parent.hello();
    }
}


/*
Abstract methods in Java are methods that are declared without a body(implementation). An abstract method only
specifies the method signature (name, parameters, and return type). The implementation of the method is provided by a
subclass. If a class contains at least one abstract method, the class must be declared as abstract.
*/