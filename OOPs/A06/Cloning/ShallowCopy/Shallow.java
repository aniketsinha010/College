package OOPs.A06.Cloning.ShallowCopy;


class Address { // A class 'Address' is defined with a single field 'city'...
    String city;
    // A constructor Address(String city) initializes the city variable...
    Address(String city) {
        this.city = city;
    }
}


class Person implements Cloneable {
    // A class Person is defined. It implements the Cloneable interface, which allows the object to be cloned...
    String name;
    Address address;

    // Constructor for Person Class...
    Person(String name, String city) {
        this.name = name;
        this.address = new Address(city);
    }

    // Overriding clone() for shallow copy
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
    /*
    The clone() method is overridden to enable shallow copying. It calls super.clone(), which performs a bitwise copy
    of the object. Shallow copy means: The primitive fields (like name) are copied. The reference fields (like address)
    are not copied, but rather the reference is copied. So both the original and cloned objects share the same Address
    object...
    */
}


public class Shallow {
    public static void main(String[] args) throws CloneNotSupportedException {
        // throws CloneNotSupportedException is declared because clone() might throw this exception...

        Person p1 = new Person("John", "New York");
        Person p2 = (Person) p1.clone(); // Cloning
        /* p1.clone() is called to create a copy of p1 and assign it to p2. Since clone() is doing a shallow copy, p2
        gets: A new reference for p2 (the Person object itself is copied).The same Address reference as p1 (the Address
        object is shared).
        */

        System.out.println("Before Modification:");
        System.out.println(p1.name + " lives in " + p1.address.city);
        System.out.println(p2.name + " lives in " + p2.address.city);

        // Modifying cloned object's city
        p2.address.city = "Los Angeles";

        System.out.println("\nAfter Modification:");
        System.out.println(p1.name + " lives in " + p1.address.city);
        System.out.println(p2.name + " lives in " + p2.address.city);
        /* Both p1 and p2 now show "Los Angeles" as the city. This proves that the Address object is shared between p1
        and p2, which is a key characteristic of shallow copying...
        */
    }
}


/*
The Clonable interface in Java is used to indicate that a class allows its objects to be cloned, meaning an exact copy
can be made. It is a marker interface, which means it does not contain any methods but serves as a signal to the Java
runtime.

Key Points about Clonable Interface:

Enables Cloning: It allows the use of the clone() method from the Object class to create field-by-field copies of
objects.

Marker Interface: It does not have any methods, but if a class implements Clonable, it indicates that clone() is safe
to use.

Used with clone() Method: To allow cloning, a class must:
Implement Clonable
Override the clone() method (which is protected in Object)

Shallow Copy vs. Deep Copy:
The default clone() method performs a shallow copy (copies field values as-is).
A deep copy requires manually copying nested objects.
*/