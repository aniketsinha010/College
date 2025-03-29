package OOPs.A02;

// Static variables and Static Methods...

/*
In Java, static variables are variables that belong to the class rather than any specific instance of the class.
These variables are shared among all instances of the class, meaning they hold the same value for every object of that
class...Accessible using the class name, without requiring an object instance.
Syntax: ClassName.variableName...
The value of a static variable is the same across all instances unless explicitly modified....
*/

/*
In Java, static methods are methods that belong to the class rather than any specific instance(object) of the class.
They are defined using the static keyword and can be called without creating an object of the class. Since static
methods are not tied to any instance, they cannot access instance variables or instance methods directly.
They can only work with static variables and other static methods...'main' method is also a static method...
*/

public class Static {
    public static void main(String[] args) {
        Human aniket = new Human(20,"Aniket Sinha",0,true); // we don't have to import 'Human' as it is in the same package...
        System.out.println(aniket.population);
        Human ma = new Human(52,"Anindita Sinha",15000,false);
        System.out.println(ma.population);
        // we can access static variables without even creating any object of that class...
        System.out.println(Human.population);
        System.out.println();

        // calling static method...
        Human.incrementCounter();
        aniket.incrementCounter();
        ma.incrementCounter(); // Even though you can call a static method using an object reference, it's generally
        // recommended to use the class name to avoid confusion.

        // greeting(); // A non-static method cannot be referenced within a static method...but a static method can
        // be called within a non-static method...

        // but you can use non-static method by referencing their instance in a static context...
        Static bhai = new Static();
        bhai.greeting();
    }

    void greeting(){
        System.out.println("Hello Everyone !!!");
    }
}
