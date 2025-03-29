package OOPs.A03.A02_Polymorphism;

public class Main {
    public static void main(String[] args) {
        System.out.println();
        Shape unknown = new Shape();
        unknown.area();
        System.out.println();

        Circle circle = new Circle();
        circle.area();
        System.out.println();

        Square square = new Square();
        square.area(); // If a method called is not present in that subclass then the method from the closest
        // superclass in the inheritance chain is executed...there is no area method in 'Square' subclass, so the
        // area method form its superclass 'Shape' is being executed...
        System.out.println();

        // already seen in last lecture, referencing child class using parent class...
        Shape triangle = new Triangle();
        triangle.area();
    }
}

// By default, every class in java extends the object class...


/*

Polymorphism in Object-Oriented Programming (OOP) in Java refers to the ability of a single interface or method to
represent multiple behaviors. It is derived from the Greek words "poly" (many) and "morph" (forms), meaning "many
forms." Polymorphism is a key feature of OOP that allows objects to be treated as instances of their parent class
rather than their actual class, promoting flexibility and reusability...


## There are two types of polymorphism ::::

1) Compile Time / Static Polymorphism :
It is achieved through method overloading. Method overloading means same name of methods but any or all of datatype of
arguments, number of arguments, ordering of arguments is different...Example : see the 'Box' class from Inheritance
part, there four different 'Box' constructors were defined all having the same name but in each of them there are
some differences in the arguments...It is called compile-time polymorphism because the decision about which overloaded
method to call is made by the Java compiler during the compilation phase depending upon the method name and
the number, types, and order of the arguments provided in the call...


2) Run Time / Dynamic Polymorphism :
It is achieved through method overriding. Method overriding in Java is a feature that allows a subclass to provide a
specific implementation of a method that is already defined in its superclass.The overriding method must have the same
name, return type, and parameters as the method in the parent class,only body will be different.Method overriding can
only occur between a superclass and its subclass.The access level of the overriding method cannot be more restrictive
than the method in the superclass. For example, if the superclass method is protected, the overriding method cannot be
private. The @Override annotation is optional but recommended to indicate that a method is being overridden.
Static methods belong to the class, not an object, so they cannot participate in runtime polymorphism...
Example : The 'Shape' class and its subclasses. All of 'Shape' class and its subclasses have the method 'area' with
the same name, return type, and parameters (specifically in this case there are no parameters) only the body of all
the methods are different. The decision about which method to call in method overriding is determined at runtime, based
on the actual type of the object. In "Shape triangle = new Triangle();" , 'Shape' is the reference type but 'Triangle'
is the object, so the 'area' method from 'Triangle' subclass will be called...Dynamic Method Dispatch allows the Java .
Virtual Machine (JVM) to decide which version of an overridden method to call based on the actual type of the object,
not the type of the reference variable....If a method called is not present in that subclass then the method from the
closest superclass in the inheritance chain is executed.This means that the method will be executed from the first
superclass that defines it, even if the subclass does not provide an override...If a method is marked as 'final' in
the superclass, it cannot be overridden by subclasses.This ensures that the method's behavior remains the same for
all subclasses.However, a final method can still be inherited by subclasses, but its implementation cannot be changed.
But a final class in Java is a class that cannot be subclassed or inherited from. This means you cannot create a new
class that extends or inherits the properties and behaviors of a final class...

*/

