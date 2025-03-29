package OOPs.A05.Abstract;

public abstract class Parent {

    int age;

    // creating constructor of abstract class...
    public Parent(int age) {
        this.age = age;
    }

    // abstract parent();
    // you cant create abstract constructors...

    // if a class contains at least one abstract method then the class must be declared abstract as well...
    abstract void career(String name);


    static void hello(){
        System.out.println("Hello I am in Parent class");
    }
    // you cant create abstract static methods, but you can create static methods in abstract classes...
}
