package Sorting.SelectionSort;

import java.util.Arrays;

public class SelectionSort {

    static void selectionSort(int[] arr){
        for(int i=0; i<arr.length; i++){
            int maxIndex = 0; // considering the first element as the max element...
            int lastIndex = (arr.length - i - 1); // the unsorted part decreases after every iteration...
            for(int j=1; j <= lastIndex; j++){ // inner loop starts from 1 because maxIndex is initialized to 0...
                if(arr[j] > arr[maxIndex]){
                    maxIndex = j;
                }
            }
            // swapping...
            if (maxIndex != lastIndex) { // Avoid unnecessary swaps
                int temp = arr[lastIndex];
                arr[lastIndex] = arr[maxIndex];
                arr[maxIndex] = temp;
            }
        }
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
