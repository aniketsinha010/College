package Sorting.BubbleSort;

import java.util.Arrays;

public class BubbleSort {

    static void bubbleSort(int[] arr){
        boolean swapped;
        // Outer loop for each pass...
        for(int i=0; i<arr.length-1; i++){
            swapped = false;
            // Inner loop for comparing adjacent elements...
            for(int j=0; j<arr.length-1-i; j++){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    swapped = true;
                }
            }
            // If no swaps happened, array is already sorted..
            if (!swapped) break;
        }
    }

    public static void main(String[] args) {
        int[] arr = {6,2,9,56,5,4,1,674,84,64,97,-71,54,8};
        System.out.println("Original Array : ");
        System.out.println(Arrays.toString(arr));
        bubbleSort(arr);
        System.out.println("Sorted Array : ");
        System.out.println(Arrays.toString(arr));
    }
}

/*
The swapped boolean variable is used as an optimization to make Bubble Sort more efficient when the array is already
sorted or nearly sorted.

How It Works :

1) Tracks if any swaps occur during a pass through the array.
2) If no swaps occur in a full pass, it means the array is already sorted.
3) When swapped remains false, we break out of the loop early, avoiding unnecessary iterations.
*/


/*
Bubble Sort is the simplest sorting algorithm that works by repeatedly swapping the adjacent elements if they are in
the wrong order. This algorithm is not suitable for large data sets as its average and worst-case time complexity
are quite high.

We sort the array using multiple passes. After the first pass, the maximum element goes to end (its correct position).
Same way, after second pass, the second-largest element goes to second last position and so on. In every pass, we
process only those elements that have already not moved to correct position. After k passes, the largest k elements
must have been moved to the last k positions. In a pass, we consider remaining elements and compare all adjacent and
swap if larger element is before a smaller element. If we keep doing this, we get the largest (among the remaining
elements) at its correct position.
*/