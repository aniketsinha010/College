// Interface 1
interface Animal {
    void eat();
}

// Interface 2
interface Bird {
    void fly();
}

// Class implementing multiple interfaces
class Bat implements Animal, Bird {
    @Override
    public void eat() {
        System.out.println("Bat is eating insects.");
    }

    @Override
    public void fly() {
        System.out.println("Bat is flying in the night sky.");
    }
}

// Main class
public class Main {
    public static void main(String[] args) {
        Bat bat = new Bat();
        bat.eat(); // Calling method from Animal interface
        bat.fly(); // Calling method from Bird interface
    }
}
