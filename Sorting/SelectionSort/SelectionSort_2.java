package Sorting.SelectionSort;

import java.util.Arrays;

public class SelectionSort_2 {

    static void selectionSort(int[] arr){
        for(int i=0; i<arr.length; i++){
            int lastIndex = (arr.length-i-1);
            int maxIndex = findMaxIndex(arr,0,lastIndex);
            swap(arr,maxIndex,lastIndex);
        }
    }

    static void swap(int[] arr, int maxIndex, int lastIndex){
        if(maxIndex != lastIndex){
            int temp = arr[lastIndex];
            arr[lastIndex] = arr[maxIndex];
            arr[maxIndex] = temp;
        }
    }

    static int findMaxIndex(int[] arr, int startIndex, int lastIndex){
        int max = startIndex;
        for(int i=startIndex; i<lastIndex; i++){
            if(arr[i+1] > arr[max]){
                max = (i+1);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = {6,2,9,56,5,4,1,674,84,64,97,-71,54,8};
        System.out.println("Original Array : ");
        System.out.println(Arrays.toString(arr));
        selectionSort(arr);
        System.out.println("Sorted Array : ");
        System.out.println(Arrays.toString(arr));
    }
}
