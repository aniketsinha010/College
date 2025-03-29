package Searching.BinarySearch;

// Here satirising from bottom left...

import java.util.Arrays;

public class BS_2D_RowColumnSorted_2 {
    static int[] binarySearch2D(int[][] arr, int target){
        // starting from bottom left...
        int row = arr.length - 1;
        int column = 0;
        while(row >= 0 && column < arr[row].length){
            if(arr[row][column] == target){
                return new int[]{row,column};
            }
            if(target > arr[row][column]){
                column++;
            }
            else{
                row--;
            }
        }
        return new int[]{-1,-1};
    }

    public static void main(String[] args){
        int[][] matrix = {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        int target = 8;
        int[] answer = binarySearch2D(matrix,target);
        System.out.println(Arrays.toString(answer));
    }
}
