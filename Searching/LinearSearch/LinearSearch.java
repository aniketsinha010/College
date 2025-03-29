package Searching.LinearSearch;

public class LinearSearch {

    static int linearSearch(int[] arr, int target){
        if(arr.length == 0){
            return -1;
        }
        for(int index = 0; index < arr.length ; index++){
            if(arr[index] == target){
                return index;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9};
        int num = 4;
        int answer = linearSearch(arr,num);
        System.out.println(answer);
    }

}
