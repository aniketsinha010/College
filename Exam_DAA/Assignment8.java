package Exam_DAA;

public class Assignment8 {

    // Function to find first occurrence of x
    public static int firstOccurrence(int[] arr, int x) {
        int low = 0, high = arr.length - 1, result = -1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] == x) {
                result = mid;
                high = mid - 1; // keep searching in left part
            } else if (arr[mid] < x) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return result;
    }

    // Function to find last occurrence of x
    public static int lastOccurrence(int[] arr, int x) {
        int low = 0, high = arr.length - 1, result = -1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] == x) {
                result = mid;
                low = mid + 1; // keep searching in right part
            } else if (arr[mid] < x) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return result;
    }

    // Main function to count occurrences
    public static int countOccurrences(int[] arr, int x) {
        int first = firstOccurrence(arr, x);
        int last = lastOccurrence(arr, x);

        if (first == -1) return 0; // x not found
        return last - first + 1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 2, 3, 4, 5};
        int x = 2;

        int count = countOccurrences(arr, x);
        System.out.println("Count of " + x + " is: " + count);
    }
}
