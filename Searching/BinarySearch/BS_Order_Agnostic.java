package Searching.BinarySearch;

public class BS_Order_Agnostic {

    static int binarySearch(int[] arr, int target){
        if(arr.length == 0){
            return -1;
        }
        int start = 0;
        int end = arr.length - 1;
        int mid;

        boolean isAscending = arr[start] < arr[end];

        while(start <= end){
            mid = start + (end-start)/2;
            if(arr[mid] == target){
                return mid;
            }

            if(isAscending){
                if(target < arr[mid]){
                    end = mid - 1;
                }
                else{
                    start = mid + 1;
                }
            }
            else {
                if(target < arr[mid]){
                    start = mid + 1;
                }
                else{
                    end = mid - 1;
                }
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        int[] nums = {10,8,6,4,2,0,-2,-4,-6,-8,-10};
        int answer = binarySearch(nums,-4);
        System.out.println(answer);

        int[] nums2 = {-10,-8,-6,-4,-2,0,2,4,6,8,10};
        int answer2 = binarySearch(nums2,-4);
        System.out.println(answer2);
    }
}
