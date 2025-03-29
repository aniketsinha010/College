package Sorting.MergeSort;

// Done from a different lecture...

public class MergeSort {

    public static void divide(int[] arr,int startIndex,int endIndex){
        if (startIndex < endIndex){
            // This function recursively splits the array into two halves until each part contains a single element.
            // Base Condition: if (startIndex < endIndex) → stops recursion when only one element remains...
            int mid = startIndex + (endIndex-startIndex)/2;
            divide(arr,startIndex,mid); // calling divide on the left half of the array...
            divide(arr,mid+1,endIndex); // calling divide on the left half of the array...
            conquer(arr,startIndex,mid,endIndex); // merges the two sorted halves...
        }
    }

    public static void conquer(int[] arr,int startIndex,int mid,int endIndex){
        int[] mergedArray = new int[endIndex-startIndex+1]; // This temporary array holds the sorted elements before
        // copying them back to arr[]...
        int index1 = startIndex; // points to the left subarray (startIndex to mid)...
        int index2 = mid+1; // points to the right subarray (mid + 1 to endIndex)...
        int mergedIndex = 0; // tracks the current position in the merged array...

        // merging the two sorted halves...
        while(index1 <= mid && index2 <= endIndex){
            if(arr[index1] <= arr[index2]){
                mergedArray[mergedIndex] = arr[index1];
                mergedIndex++;
                index1++;
            }
            else {
                mergedArray[mergedIndex] = arr[index2];
                mergedIndex++;
                index2++;
            }
        }

        // copying remaining elements from left subarray...
        while(index1 <= mid){
            mergedArray[mergedIndex] = arr[index1];
            mergedIndex++;
            index1++;
            // If elements remain in the left half, they are copied to mergedArray...
        }

        // copying remaining elements from right subarray...
        while(index2 <= endIndex){
            mergedArray[mergedIndex] = arr[index2];
            mergedIndex++;
            index2++;
            // If elements remain in the right half, they are copied to mergedArray...
        }

        // Copy merged elements back to the original array...
        for (int i = 0, j = startIndex; i < mergedArray.length; i++, j++) {
            arr[j] = mergedArray[i];
        }
    }


    // Function to print the array
    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }


    public static void main(String[] args){
        int[] arr = {6,3,9,5,2,8};
        System.out.println("Original Array:");
        printArray(arr);

        divide(arr, 0, arr.length - 1);

        System.out.println("Sorted Array:");
        printArray(arr);
    }
}
