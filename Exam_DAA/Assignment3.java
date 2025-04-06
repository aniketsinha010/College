package Exam_DAA;

import java.util.Arrays;

public class Assignment3 {

    static int[] binaryTwoD(int[][]arr,int target){
        int row=0;
        int column = arr[0].length-1;
        while(row < arr.length && column >= 0){
            if(arr[row][column] == target){
                return new int[]{row,column};
            }
            if(target>arr[row][column]){
                row++;
            }
            else {
                column--;
            }
        }
        return new int[]{-1,-1};
    }

    public static void main(String[] args) {
        int target = 80;
        int[][] matrix1 = {
                {10,20,30},
                {40,50,60},
                {70,80,90}
        };
        int[] ans = binaryTwoD(matrix1,target);
        System.out.println(Arrays.toString(ans));
    }
}
