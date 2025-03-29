package OOPs.A05.Interface_2;

public class Dog implements Animal{
    // implementing abstract methods by overriding(compulsory)...
    @Override
    public void eat() {
        System.out.println("Dog is eating.");
    }
    @Override
    public void sleep() {
        System.out.println("Dog is sleeping.");
    }
}
