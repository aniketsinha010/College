package Exam_DAA;

import java.util.Arrays;

public class Assignment1 {

    static int[] findSum(int[] arr,int target){
        int start = 0;
        int end = arr.length-1;
        while(start < end){
            if(arr[start]+arr[end] == target){
                return new int[]{arr[start],arr[end]};
            }
            else{
                start++;
                end--;
            }
        }
        return new int[]{-1,-1};
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 6, 8, 9};
        int X = 10;
        int[] answer = findSum(arr,X);
        System.out.println(Arrays.toString(answer));
    }
}
