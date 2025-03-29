package OOPs.A06.ExceptionHandling;

public class MultipleCatch {
    public static void main(String[] args) {
        // try catch can also be used within main method...
        try{
            int[] arr = {1,2,3};
            int a = 10;
            int b = 0;
            int result = a/b; // this is basically ArithmeticException....
            System.out.println(arr[5]); // this is basically ArrayIndexOutOfBoundsException....
        }
        catch (ArithmeticException error){
            System.out.println(error);
        }
        catch (ArrayIndexOutOfBoundsException error){
            System.out.println(error);
        }
        catch (RuntimeException error){
            System.out.println(error);
        }
        catch (Exception error){
            System.out.println(error);
        }
        // See Java exception hierarchy...
        finally {
            System.out.println("Thank You");
        }
    }
}

// Note : The second exception (ArrayIndexOutOfBoundsException) never occurs because the program stops execution at the
// first exception (ArithmeticException) and then the 'finally message' is printed irrespective of previous events...
