package Searching.LinearSearch;
import java.util.Arrays;

public class LS_2D {
    static int[] linearSearch(int[][] arr, int target){
        // here int[] means return type is an array...
        for(int row=0; row<arr.length ; row++){
            for(int column=0; column<arr[row].length; column++){
                if(arr[row][column] == target){
                    return new int[]{row,column};
                }
            }
        }
        return new int[]{-1,-1};
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {10, 20, 30},
                {40, 50},
                {60},
                {},
                {70, 80, 90, 100}
        };
        int[] answer = linearSearch(matrix,80);
        System.out.println(Arrays.toString(answer));
    }
}
