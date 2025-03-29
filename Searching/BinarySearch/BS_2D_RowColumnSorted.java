package Searching.BinarySearch;

import java.util.Arrays;

// A "row-wise and column-wise sorted matrix" is a matrix where every row is sorted in ascending order from left to
// right, and every column is also sorted in ascending order from top to bottom...

public class BS_2D_RowColumnSorted {

    static int[] search(int[][] arr, int target){
        // starting form the top right corner...
        int row = 0;
        int column = arr[0].length - 1;

        while(row < arr.length && column >= 0){
            if(arr[row][column] == target){
                return new int[]{row,column};
            }
            if(arr[row][column] < target){
                row++;
            }
            else{
                column--;
            }
        }
        return new int[]{-1,-1};
    }

    public static void main(String[] args){
        int target = 80;

        int[][] matrix1 = {
                {10,20,30},
                {40,50,60},
                {70,80,90}
        };
        int[] answer = search(matrix1,target);
        System.out.println(Arrays.toString(answer));

        int[][] matrix2 = {
                {1, 4, 7, 11},
                {2, 5, 8, 12},
                {3, 6, 9, 16},
                {10, 13, 14, 17}
        };
        int target2 = 17;
        int[] result = search(matrix2, target2);
        System.out.println(Arrays.toString(result));
    }
}
