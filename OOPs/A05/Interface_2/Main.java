package OOPs.A05.Interface_2;

public class Main {
    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.eat();
        dog.sleep();
        System.out.println();

        // any variable in an interface is constant and is inherited by the classes
        // implementing the interface
        System.out.println(Dog.MAX_AGE);
        System.out.println(Cat.MAX_AGE);
        System.out.println(Animal.MAX_AGE);
        System.out.println();

        // calling static method...
        Animal.info();
        // dog.info();
        //Static methods must always be called using the interface name...
        System.out.println();

        // calling default method...
        dog.run();
        Cat cat = new Cat();
        cat.run();
    }
}


/*
A class is the blueprint for creating an object, whereas interface is the blueprint for class. Interfaces can only have
abstract methods and static and final variables.

You Can't Create Objects of an Interface :
An interface cannot be instantiated because it does not have any implementation (i.e., it contains abstract methods
that have no body). Interfaces are meant to be implemented by classes, which then provide concrete behavior for the
methods declared in the interface.

No Constructors : Interfaces cannot have constructors because they do not maintain state and cannot be instantiated.

Since Java8 interfaces can have static and default methods...Static methods must always be called using the interface
name...Default methods are inherited by implementing classes, but they can override the default implementation if
needed.Default methods are not abstract, so implementing classes are not forced to override them.
*/