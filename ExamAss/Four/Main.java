package ExamAss.Four;

class Animal{
    void m1(){
        System.out.println("I am in superclass animal.");
    }
}

class Cat extends Animal{
    void m2(){
        System.out.println("Cat and animal.");
    }
}

class Dog extends Animal{
    void m3(){
        System.out.println("Dog and animal.");
    }
}

public class Main {
    public static void main(String[] args) {
        Cat cat = new Cat();
        cat.m1();
        cat.m2();

        Dog dog = new Dog();
        dog.m1();
        dog.m3();
    }
}
