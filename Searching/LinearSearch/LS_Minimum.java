package Searching.LinearSearch;

public class LS_Minimum {
    static int minimumSearch(int[] arr){
        if(arr.length == 0){
            return -1;
        }
        int min = arr[0];
        for(int i=0;i<arr.length-1;i++){
            if(arr[i+1] < min) {
                min = arr[i + 1];
            }
        }
        return min;
    }

    public static void main(String[] args) {
        int[] arr = {12,4,23,77,54,9,2,11,26,1};
        int answer = minimumSearch(arr);
        System.out.println(answer);
    }
}
