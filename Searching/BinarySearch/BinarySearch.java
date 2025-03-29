package Searching.BinarySearch;

public class BinarySearch {

    static int binarySearch(int[] arr, int target){
        if(arr.length == 0){
            return -1;
        }
        int start = 0;
        int end = arr.length - 1;
        int mid;
        while(start <= end){
            mid = (start+end)/2; // there might be a possibility that 'mid' might exceed the 'int' limit in Java, so
            // it is better to do 'mid = start + (end - start)/2' ...
            if(arr[mid] == target){
                return mid;
            }
            if(target > arr[mid]){
                start = mid + 1;
            }
            else{
                end = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7,8,9};
        int answer = binarySearch(nums,9);
        System.out.println(answer);

        int[] nums2 = {-10,-8,-6,-4,-2,0,2,4,6,8,10};
        int answer2 = binarySearch(nums2,-4);
        System.out.println(answer2);

        int answer3 = binarySearch(nums2,3);
        System.out.println(answer3);
    }
}
