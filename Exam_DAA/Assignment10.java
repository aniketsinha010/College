package Exam_DAA;

import java.util.Arrays;

// this is actually count sort not cycle sort...

public class Assignment10 {

    static void cycleSort(int[] arr){
        int i = 0 ;
        while(i < arr.length){
            int correctIndex = arr[i] - 1;
            if(arr[i] != arr[correctIndex]){
                swap(arr,i,correctIndex);
            }
            else {
                i++;
            }
        }
    }

    static void swap(int[] arr, int firstIndex, int secondIndex){
        int temp = arr[firstIndex];
        arr[firstIndex] = arr[secondIndex];
        arr[secondIndex] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {3,5,2,1,4};
        System.out.println("Original Array : ");
        System.out.println(Arrays.toString(arr));
        cycleSort(arr);
        System.out.println("Sorted Array : ");
        System.out.println(Arrays.toString(arr));
    }
}


/*
Whenever numbers are given from range 1 to N , use Cyclic Sort...

Cyclic Sort is an efficient sorting algorithm that is particularly useful for sorting arrays where the elements are in
a specific range, such as when the elements are integers from 0 to n-1. It operates in O(n) time complexity and O(1)
space complexity, making it very efficient for certain types of problems.

How Cyclic Sort Works :
Cyclic sort works by placing each element in its correct position in the array. The key idea is to use the value of
the elements to determine their correct index. The algorithm repeatedly swaps elements until all elements are in their
correct positions.
*/