package Exam_DAA;


import java.util.*;

public class Assignment11 {

    // Partition function like in QuickSort
    static int partition(int[] arr, int low, int high) {
        int pivot = arr[high], i = low;

        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
            }
        }

        // Swap pivot to correct position
        int temp = arr[i];
        arr[i] = arr[high];
        arr[high] = temp;

        return i;
    }

    // QuickSelect to find kth smallest
    static int quickSelect(int[] arr, int low, int high, int k) {
        if (low == high) return arr[low];

        int pivotIndex = partition(arr, low, high);

        int count = pivotIndex - low + 1;

        if (count == k) return arr[pivotIndex];
        else if (count > k) return quickSelect(arr, low, pivotIndex - 1, k);
        else return quickSelect(arr, pivotIndex + 1, high, k - count);
    }

    // Find neighbors of median
    static void findMedianNeighbors(int[] arr) {
        int n = arr.length;

        // Make a copy to preserve original array
        int[] arrCopy = Arrays.copyOf(arr, n);

        int median = quickSelect(arrCopy, 0, n - 1, (n + 1) / 2);

        // Find neighbors manually
        Integer smaller = null, larger = null;

        for (int num : arr) {
            if (num < median) {
                if (smaller == null || num > smaller) smaller = num;
            } else if (num > median) {
                if (larger == null || num < larger) larger = num;
            }
        }

        System.out.println("Median: " + median);
        System.out.println("Smaller neighbor: " + (smaller != null ? smaller : "None"));
        System.out.println("Larger neighbor: " + (larger != null ? larger : "None"));
    }

    public static void main(String[] args) {
        int[] arr = {7, 2, 9, 4, 5, 6, 3};

        findMedianNeighbors(arr);
    }
}
