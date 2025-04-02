package ExamAss;

import java.util.Scanner;

public class Ten {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter String : ");
        String input = sc.nextLine();
        try{
            int num = Integer.parseInt(input);
            System.out.println("Valid Input : " + num);
        } catch(NumberFormatException e){
            System.out.println(e);
        }
    }
}