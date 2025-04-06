package Exam_DAA;

public class Assignment5 {

    public static int mergeSortAndCount(int[] arr, int left, int right) {
        int count = 0;

        if (left < right) {
            int mid = (left + right) / 2;

            // Count inversions in left and right halves
            count += mergeSortAndCount(arr, left, mid);
            count += mergeSortAndCount(arr, mid + 1, right);

            // Count cross inversions during merge
            count += mergeAndCount(arr, left, mid, right);
        }

        return count;
    }

    public static int mergeAndCount(int[] arr, int left, int mid, int right) {
        int[] leftArr = java.util.Arrays.copyOfRange(arr, left, mid + 1);
        int[] rightArr = java.util.Arrays.copyOfRange(arr, mid + 1, right + 1);

        int i = 0, j = 0, k = left, swaps = 0;

        while (i < leftArr.length && j < rightArr.length) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k++] = leftArr[i++];
            } else {
                arr[k++] = rightArr[j++];
                swaps += (leftArr.length - i); // Inversion found
            }
        }

        while (i < leftArr.length) arr[k++] = leftArr[i++];
        while (j < rightArr.length) arr[k++] = rightArr[j++];

        return swaps;
    }

    public static void main(String[] args) {
        int[] arr = {2, 4, 1, 3, 5};
        int n = arr.length;

        int inversionCount = mergeSortAndCount(arr, 0, n - 1);
        System.out.println("Number of inversion pairs: " + inversionCount);
    }
}

