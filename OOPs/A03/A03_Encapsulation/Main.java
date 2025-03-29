package OOPs.A03.A03_Encapsulation;

public class Main {
    public static void main(String[] args){
        Person aniket = new Person();

        aniket.setName("Aniket Sinha");
        aniket.getName();

        aniket.setAge(21);
        aniket.getAge();
    }
}


/*
Encapsulation refers to the practice of bundling the data (variables) and methods (functions) that operate on the data
into a single unit, or class, and restricting access to some of the object's components. This is done by hiding the
internal state of the object and only exposing a controlled interface through public methods.

# Data Hiding : The fields (variables) of a class are made private or protected so they are not directly accessible
from outside the class. This prevents unauthorized or unintended modification of the data.

# Public Methods (Getters and Setters) : Public methods are provided to access and modify the values of private
variables. These methods allow controlled access to the object's data, ensuring that the object remains in a valid
state.
*/