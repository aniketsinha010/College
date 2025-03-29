package OOPs.A02;

/*
This shows the initialization of static variables using static blocks... Static blocks are executed when the class
is loaded into memory and are often used to initialize static variables with logic...The static block runs only once
when the class is first loaded by the Java Virtual Machine (JVM). It’s not executed every time an object of the class
is created...
*/

public class Static_Block {
    static int a = 4;
    static int b;
    // to initialise 'b' we can use static block...
    static {
        System.out.println("I am in Static Block !!");
        b = a * 5;
    }


    public static void main(String[] args) {
        Static_Block obj = new Static_Block();
        System.out.println(Static_Block.b);

        Static_Block.b += 5;
        System.out.println(Static_Block.b);

        // creating another object...
        Static_Block ob2 = new Static_Block();
        System.out.println(Static_Block.b);
        // here the statement "I am in Static Block !!" doesn't get printed and the value of b remains 25 which shows
        // that the static block runs only once when the first object (obj) is created...
    }
}
