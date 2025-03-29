package OOPs.A02;


// this class is for 'Static.java' ....

public class Human {
    int age; // Instance Variable
    String name; // Instance Variable
    float salary; // Instance Variable
    boolean male; // Instance Variable
    static long population; // Static Variable

    // Constructor
    public Human(int age, String name, float salary, boolean male) {
        this.age = age;
        this.name = name;
        this.salary = salary;
        this.male = male;
        Human.population += 1; // ClassName.variableName
    }

    // creating static method...
    static int counter;
    static void incrementCounter(){
        counter++;
        System.out.println("Counter : " + counter);
    }
}

