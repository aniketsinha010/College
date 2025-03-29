package OOPs.A05.Interface_2;

public interface Animal {
    // abstract method...
    public abstract void eat();
    // methods in interfaces are by default public and abstract so there is no need to write 'public' and 'abstract'
    // keyword separately...
    void sleep();


    // we can also use static constants in interfaces...
    public static final int MAX_AGE = 100;
    // variables in interfaces are by default public, static and final, so there is no
    // need to specify those three keywords separately...


    // Since Java8 interfaces can have static and default methods...
    public static void info(){
        System.out.println("This is an animal interface.");
    }

    // default method...
    public default void run(){
        System.out.println("Animal is running.");
    }
}
