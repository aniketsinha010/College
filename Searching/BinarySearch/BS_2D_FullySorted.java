package Searching.BinarySearch;

// A "sorted matrix" is a matrix where all elements within each row are arranged in ascending order, and typically,
// the first element of any row is greater than or equal to the last element of the previous row, meaning the entire
// matrix can be considered somewhat "sorted" when traversing from top left to bottom right...

import java.util.Arrays;

public class BS_2D_FullySorted {

    static int[] search(int[][] arr, int target){
        return new int[]{};
        ////////// NOT COMPLETED //////////
    }


    public static void main(String[] args){
        int[][] matrix = {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        int target = 8;
        int[] answer = search(matrix,target);
        System.out.println(Arrays.toString(answer));
    }
}
