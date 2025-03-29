package Sorting.InsertionSort;

import java.util.Arrays;

public class InsertionSort {

    static void insertionSort(int[] arr){
        for(int i=1; i<arr.length; i++){
            // We start from i = 1 because the first element (index 0) is already "sorted"...
            int key = arr[i]; // key stores the current element to be inserted into its correct position...
            int j = i-1; // j is the index of the last sorted element before key...
            while(j >= 0 && arr[j] > key){
                // arr[j] > key → If arr[j] is greater, it means key is smaller and needs to be shifted left...
                arr[j+1] = arr[j];
                j--; // moves j to the previous index (j - 1) to continue comparisons...
            }
            arr[j+1] = key;
            // Once j moves to a position where arr[j] is not greater than key, we insert key at arr[j + 1]...
        }
    }

    public static void main(String[] args) {
        int[] arr = {6,2,9,56,5,4,1,674,84,64,97,-71,54,8};
        System.out.println("Original Array : ");
        System.out.println(Arrays.toString(arr));
        insertionSort(arr);
        System.out.println("Sorted Array : ");
        System.out.println(Arrays.toString(arr));
    }
}


/*
How Insertion Sort Works :

1) Start with the second element (since a single element is already sorted).
2) Pick the current element and compare it with the elements before it.
3) Shift elements to the right until the correct position for the current element is found.
4) Insert the element in its correct position.
5) Repeat for all elements in the array.
*/