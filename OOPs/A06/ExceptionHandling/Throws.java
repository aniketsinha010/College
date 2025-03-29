package OOPs.A06.ExceptionHandling;

/*
throws declares that a method may throw one or more exceptions.
The caller must handle or propagate the exception.
Typically used for checked exceptions (IOException, SQLException, etc.).
*/

public class Throws {
    public static void divide(int a, int b) throws ArithmeticException { // Declaring exception
        System.out.println("Result: " + (a / b));
    }

    public static void main(String[] args) {
        try {
            divide(10, 0); // ❌ Exception occurs
        } catch (ArithmeticException e) {
            System.out.println("Exception handled: " + e.getMessage());
        }
    }
}
