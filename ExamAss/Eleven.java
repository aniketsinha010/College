package ExamAss;

import java.util.Scanner;

public class Eleven {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Numerator : ");
        int numerator = sc.nextInt();
        System.out.println("Enter Denominator : ");
        int denominator = sc.nextInt();
        try{
            int result = numerator/denominator;
            System.out.println("Result : "+result);
        }catch (ArithmeticException e){
            System.out.println(e);
        }
    }
}
