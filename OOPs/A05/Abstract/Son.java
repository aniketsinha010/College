package OOPs.A05.Abstract;

public class Son extends Parent{

    public Son(int age){
        super(age);
    }

    // subclass providing implementation for abstract method...
    @Override
    void career(String name){
        System.out.println("Hello I am a boy, I am " + age + " and I want to be a "+name);
    }
}
