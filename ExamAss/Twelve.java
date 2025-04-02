package ExamAss;

import java.util.Scanner;

public class Twelve {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter String : ");
        String input = sc.nextLine();
        int[] arr = {1,2,3,4,5,6,7,8,9};
        try{
            int index = Integer.parseInt(input);
            System.out.println(arr[index]);
        }
        catch(NumberFormatException e){
            System.out.println(e);
        }
        catch(ArrayIndexOutOfBoundsException e){
            System.out.println(e);
        }
    }
}
