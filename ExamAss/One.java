package ExamAss;

public class One {

    static void m1(){
        System.out.println("This is a method without arguments and return type.");
    }

    static void m2(String name){
        System.out.printf("Hello I am %s and I am in a method with arguments but no return type.\n",name);
    }

    static boolean m3(int age){
        if(age < 18){
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        m1();
        m2("Aniket Sinha");
        boolean isAdult = m3(16);
        System.out.println("Is 16 years old an adult? " + isAdult);
    }
}

