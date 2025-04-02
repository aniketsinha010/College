package ExamAss;

// Base class
class Animal {
    void makeSound() {
        System.out.println("Animals make different sounds.");
    }
}

// Derived class (Child class)
class Dog extends Animal {
    void bark() {
        System.out.println("Dog barks: Woof! Woof!");
    }
}

// Main class to test inheritance
public class Two {
    public static void main(String[] args) {
        // Creating an object of the derived class
        Dog myDog = new Dog();

        // Calling methods
        myDog.makeSound(); // Inherited method from Animal class
        myDog.bark(); // Method from Dog class
    }
}

