package Searching.LinearSearch;

public class LS_2D_Maximum {
    static int maxSearch(int[][] arr){
        int max = arr[0][0];
        for(int row=0; row< arr.length; row++){
            for(int column=0; column<arr[row].length; column++){
                if(arr[row][column] > max){
                    max = arr[row][column];
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {23,43,11,67},
                {},
                {7,81},
                {12,77,17},
                {63}
        };
        int answer = maxSearch(matrix);
        System.out.println(answer);
    }
}
