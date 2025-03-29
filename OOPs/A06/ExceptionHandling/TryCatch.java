package OOPs.A06.ExceptionHandling;


//public class TryCatch {
//    static void divide(int a,int b){
//        System.out.println(a/b);
//    }
//
//    public static void main(String[] args){
//        int[] numerator = {10,20,30,40};
//        int[] denominator = {1,5,0,4};
//        for(int i=0;i<numerator.length;i++){
//            divide(numerator[i],denominator[i]);
//        }
//        // This gives error. Only the first two results are printed and nothing after that gets printed...
//        /* Output :
//        10
//        4
//        Exception in thread "main" java.lang.ArithmeticException: / by zero
//            at OOPs.A06.TryCatch.divide(TryCatch.java:5)
//	        at OOPs.A06.TryCatch.main(TryCatch.java:12)
//        */
//        System.out.println("Thank You");
//    }
//}



// Now doing the same thing using try catch...

public class TryCatch {
    static void divide(int a,int b){
        try{
            System.out.println(a/b);
        }
        catch (ArithmeticException error){
            // Here, we specifically know that it would be an 'ArithmeticException', if we don't know exactly the kind of
            // exception then we can use 'RuntimeException'. There will no difference in output...
            System.out.println(error);
//            System.out.println("Can't divide by zero.");
        }
    }

    public static void main(String[] args){
        int[] numerator = {10,20,30,40};
        int[] denominator = {1,5,0,4};
        for(int i=0;i<numerator.length;i++){
            divide(numerator[i],denominator[i]);
        }
        System.out.println("Thank You");
    }
}
