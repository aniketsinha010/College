package Sorting.CycleSort;

public class Leetcode41 {
    static int firstMissingPositive(int[] nums){
        int i = 0 ;
        while(i < nums.length){
            int correctIndex = nums[i] - 1;
            // Ignore elements that are negative and greater than N, since they don’t affect the smallest missing
            // positive...
            if(nums[i] >0 && nums[i] <= nums.length &&  nums[i] != nums[correctIndex]){
                swap(nums,i,correctIndex);
            }
            else {
                i++;
            }
        }

        for(int j=0; j<nums.length ; j++){
            if(nums[j] != j+1){
                return (j+1);
            }
        }

        // If all numbers are placed correctly, return n+1
        return (nums.length + 1);
    }

    static void swap(int[] arr, int start, int end){
        if(start != end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
        }
    }

    public static void main(String[] args) {
        int[] arr = {7,8,9,11,12};
        int answer = firstMissingPositive(arr);
        System.out.println(answer);
    }
}
