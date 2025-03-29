package OOPs.A06.ExceptionHandling;

/*
throw is used to manually throw an exception when a specific condition occurs.
It is followed by an exception object (new ExceptionType("message")).
*/

public class Throw {
    public static void checkAge(int age) {
        if (age < 18) {
            throw new ArithmeticException("Access Denied! You must be 18 or older."); // ❌ Throwing an exception
        }
        System.out.println("Access Granted!");
    }

    public static void main(String[] args) {
        checkAge(16);  // Throws exception
        System.out.println("End of program.");  // This line won’t execute
    }
}
