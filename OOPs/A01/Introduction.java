package OOPs.A01;


// Introduction to OOPs //

/* A class is a named group of properties and functions...By convention a class starts with capital letters...
In Java, a class is a blueprint for creating objects. It defines the structure and behavior that the objects of
the class will have. Classes are a fundamental part of Java's object-oriented programming (OOP) model...
An object is an instance of a class...
A class is the blueprint, while an object is the actual thing created based on the blueprint...

*/


// creating a class...
class Student{
    int roll;
    String name;
    float marks;
    // variables defined within a class are known as instance variables...here roll, name, marks are instance variables...
}


public class Introduction {

    public static void main(String[] args) {
        Student aniket; // this is just declaring...
        aniket = new Student(); // this creates an object from the Student class..
        // here the 'new' operator allocates the memory at run time and returns a reference variable to it which is
        // going to be stored in aniket here...

        Student samya = new Student(); // in one line...

        System.out.println(aniket.roll); // here the default values will be printed...
        System.out.println(aniket.name);
        System.out.println(aniket.marks);
        System.out.println();

        // setting values...
        aniket.name = "Aniket Sinha";
        aniket.roll = 20;
        aniket.marks = 72.8f;
        System.out.println(aniket.roll);
        System.out.println(aniket.name);
        System.out.println(aniket.marks);
        System.out.println();
    }
}

/*
We will see in the future that a static method (like main) cannot directly call a non-static method or access non-static
variables, but here we can avail the variables of non-static Student class, this is because :
In Java, the main method is static, meaning it belongs to the class rather than an instance of the class. However, the
Student class itself is not static, so its instance variables (roll, name, and marks) belong to an instance of the
class. The key point here is that we are not accessing instance variables directly from a static context. Instead, we
create an instance of Student inside the main method...
*/