package OOPs.A03.A02_Polymorphism;

public class Circle extends Shape{
    @Override
    void area(){
        System.out.println("Area is pi * radius * radius...");
    }
}
