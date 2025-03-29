package OOPs.A06.Cloning.DeepCopy;


class Address implements Cloneable {
    String city;

    Address(String city) {
        this.city = city;
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    /* The Address class implements Cloneable to allow cloning. The clone() method calls super.clone(), which performs
    a shallow copy of Address. This ensures that when Address is cloned inside Person, it gets a separate copy...
    */
}


class Person implements Cloneable {
    String name;
    Address address;

    Person(String name, String city) {
        this.name = name;
        this.address = new Address(city);
    }

    // Deep Cloning: Manually cloning referenced objects
    public Object clone() throws CloneNotSupportedException {
        Person cloned = (Person) super.clone();
        cloned.address = (Address) address.clone(); // Cloning inner object
        return cloned;
    }
    /* Step 1: super.clone() creates a shallow copy of Person...
    Step 2: cloned.address = (Address) address.clone(); This creates a new Address object for the cloned Person.This
    ensures that the address reference is not shared between p1 and p2 (Deep Cloning)...
    */
}

public class Deep{
    public static void main(String[] args) throws CloneNotSupportedException {
        Person p1 = new Person("John", "New York");
        Person p2 = (Person) p1.clone(); // Deep Cloning

        System.out.println("Before Modification:");
        System.out.println(p1.name + " lives in " + p1.address.city);
        System.out.println(p2.name + " lives in " + p2.address.city);

        // Modifying cloned object's city
        p2.address.city = "Los Angeles";

        System.out.println("\nAfter Modification:");
        System.out.println(p1.name + " lives in " + p1.address.city);
        System.out.println(p2.name + " lives in " + p2.address.city);
    }
}

// CloneNotSupportedException is thrown when an object attempts to call the clone() method but does not implement the
// Cloneable interface...