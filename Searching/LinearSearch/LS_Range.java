package Searching.LinearSearch;

public class LS_Range {
    static int search(int[]arr, int target, int start, int end){
        if(arr.length == 0){
            return -1;
        }
        if(start > end){
            return -1; // starting index cant be greater than end index...
        }
        for(int i = start; i<=end ; i++){
            if(arr[i] == target){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9};
        int answer = search(arr,4,2,5);
        System.out.println(answer);

        int answer2 = search(arr,3,2,5);
        System.out.println(answer2);

        int answer3 = search(arr,2,2,5);
        System.out.println(answer3);
    }
}
