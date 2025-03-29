package Sorting.CycleSort;

import java.util.Arrays;

public class Leetcode645 {
    static int[] findErrorNums(int[] nums) {
        int i = 0;
        while(i < nums.length){
            int correctIndex = nums[i] - 1;
            if(nums[i] != nums[correctIndex]){
                swap(nums,i,correctIndex);
            }
            else {
                i++;
            }
        }

        for(int j=0; j<nums.length; j++){
            if(nums[j] != (j+1)){
                return new int[]{nums[j],(j+1)};
            }
        }
        return new int[]{-1,-1};
    }

    static void swap(int[] arr, int start, int end){
        if(start != end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,2,2,4};
        int[] answer = findErrorNums(arr);
        System.out.println(Arrays.toString(answer));
    }
}
