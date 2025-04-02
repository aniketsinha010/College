package ExamAss.Three;

class Animal{
    void m1(){
        System.out.println("I am an Animal.");
    }
}

class Dog extends Animal{
    void m2(){
        System.out.println("I am also a dog.");
    }
}

class BabyDog extends Dog{
    void m3(){
        System.out.println("Also a baby dog.");
    }
}

public class Main {
    public static void main(String[] args) {
        BabyDog kalu = new BabyDog();
        kalu.m1();
        kalu.m2();
        kalu.m3();
    }
}
