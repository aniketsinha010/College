package OOPs.A05.Abstract;

public class Daughter extends Parent{

    public Daughter(int age){
        super(age);
    }

    @Override
    void career(String name){
        System.out.println("Hello I am a girl, I am " + age + " and I want to be a "+name);
    }
}
