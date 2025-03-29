package OOPs.A06.ExceptionHandling;

// creating custom exception...


// Custom exception class (Checked Exception)
class InvalidAgeException extends Exception {
    // constructor...
    public InvalidAgeException(String message) {
        super(message); // Pass the message to Exception class
    }
}

public class CustomException {
    // Method to check age
    public static void checkAge(int age) throws InvalidAgeException {
        if (age < 18) {
            throw new InvalidAgeException("Age must be 18 or above!");
        }
        System.out.println("Access Granted!");
    }

    public static void main(String[] args) {
        try {
            checkAge(16); // Throws exception
        } catch (InvalidAgeException e) {
            System.out.println("Exception Handled : " + e.getMessage());
        }
    }
}

