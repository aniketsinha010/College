package Searching.BinarySearch;

// in case of descending sorting just change the side of search...

public class BS_Descending {
    static int binarySearch(int[] arr, int target){
        if(arr.length == 0){
            return -1;
        }
        int start = 0;
        int end = arr.length - 1;
        int mid;
        while(start <= end){
            mid = (start+end)/2;
            if(arr[mid] == target){
                return mid;
            }
            if(target > arr[mid]){
                end = mid - 1;  // changed side of search...
            }
            else{
                start = mid + 1;  // changed side of search...
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {10,8,6,4,2,0,-2,-4,-6,-8,-10};
        int answer = binarySearch(nums,-4);
        System.out.println(answer);
    }
}

