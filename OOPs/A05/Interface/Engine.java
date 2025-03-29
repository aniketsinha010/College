package OOPs.A05.Interface;

public interface Engine {
    static final int price = 80000;
    /*
    Variables can be declared inside of interface declarations.They are implicitly final and static, meaning they cannot
    be changed by the implementing class.They must also be initialized. As the variables are by default static and final
    we can also write them without the static and final keyword...
    */
    float mileage = 22;


    // Abstract method (implicitly public and abstract)...
    void start();
    void stop();
    void acc();
}
