package OOPs.A05.Interface_2;

public class Cat implements Animal{
    // implementing abstract methods
    @Override
    public void eat(){
        System.out.println("Cat is eating.");
    }
    @Override
    public void sleep(){
        System.out.println("Cat is sleeping.");
    }

    // overriding default method(not compulsory)...
    @Override
    public void run(){
        System.out.println("Cat is running.");
    }
}
