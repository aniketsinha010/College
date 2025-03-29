package Searching.BinarySearch;

// Binary Search using recursion...

public class BS_Using_Recursion {
    static int search(int[] arr, int start, int end, int target){
        if(start > end){
            return -1;
        }
        int mid = (start + (end-start)/2);
        if(arr[mid] == target){
            return mid;
        }
        if(target > arr[mid]){
            return search(arr, mid+1, end, target);  // if the function has return type then we need to add the
            // return keyword before recursive function call...
        }
        return search(arr, start, mid-1, target);
    }

    public static void main(String[] args) {
        int[] nums = {-10,-8,-6,-4,-2,0,2,4,6,8,10};
        int target1 = 2;
        int answer1 = search(nums,0, nums.length,target1);
        System.out.println(answer1);

        int target2 = 3;
        int answer2 = search(nums,0, nums.length,target2);
        System.out.println(answer2);
    }
}
