package OOPs.A05.Interface;

public class Car implements Brake,Engine{
    // implementing abstract methods...
    @Override
    public void brake() {
        System.out.println("I brake like a normal car.");
    }

    @Override
    public void start() {
        System.out.println("I start like a normal car.");
    }

    @Override
    public void stop() {
        System.out.println("I stop like a normal car.");
    }

    @Override
    public void acc() {
        System.out.println("I accelerate like a normal car.");
    }
}
