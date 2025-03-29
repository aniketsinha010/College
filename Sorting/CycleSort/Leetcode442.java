package Sorting.CycleSort;

import java.util.ArrayList;

public class Leetcode442 {
    static ArrayList<Integer> findDuplicates(int[] nums) {
        int i = 0;
        while(i < nums.length){
            int correctIndex = nums[i] - 1;
            if(nums[i] != nums[correctIndex]){
                swap(nums,i,correctIndex);
            }
            else{
                i++;
            }
        }

        ArrayList<Integer> list = new ArrayList<>();

        for(int j=0; j<nums.length; j++){
            if(nums[j] != (j+1)){
                list.add(nums[j]);
            }
        }
        return list;
    }

    static void swap(int[] arr, int start, int end){
        if(start != end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
        }
    }

    public static void main(String[] args) {
        int[] arr = {4,3,2,7,8,2,3,1};
        ArrayList<Integer> answer = findDuplicates(arr);
        System.out.println(answer);
    }
}
