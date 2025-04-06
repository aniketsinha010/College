package Exam_DAA;

public class Assignment2 {

    static int binarySearch(int[] arr,int target){
        int start=0;
        int end = arr.length-1;
        int mid;
        while(start <= end){
            mid = (start+end)/2;
            if(arr[mid] == target){
                return mid;
            }
            if(target>arr[mid]){
                start=mid+1;
            }
            else {
                end = mid-1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,6,7,8,9};
        int X = 6;
        int ans = binarySearch(arr,X);
        System.out.println(ans);
    }
}
