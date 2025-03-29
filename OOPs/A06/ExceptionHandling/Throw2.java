package OOPs.A06.ExceptionHandling;

public class Throw2 {
    public static void main(String[] args) {
        try{
            throw new Exception("Just checking");
        } catch (ArithmeticException e){
            System.out.println("Arithmetic Exception");
        } catch (Exception e) {
            System.out.println("Not Arithmetic Exception");
        }
    }
}
