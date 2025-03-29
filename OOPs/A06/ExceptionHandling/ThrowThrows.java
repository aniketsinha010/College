package OOPs.A06.ExceptionHandling;

public class ThrowThrows {
    static void  divide(int a,int b) throws ArithmeticException{
        if(b == 0){
            throw new ArithmeticException("Denominator cannot be zero!!!!");
        }
        else{
            System.out.println(a/b);
        }
    }

    public static void main(String[] args) {
        try{
            divide(10,2);
            divide(10,1);
            divide(10,0);
        }
        catch (Exception error){
            System.out.println("Exception Caught : " + error);
        }
    }
}
