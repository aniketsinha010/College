package Exam_DAA;



public class Assignment9 {

    // Utility function to get median of a single sorted array
    public static double getMedian(int[] arr, int start, int end) {
        int length = end - start + 1;
        int mid = start + (length / 2);

        if (length % 2 == 0) {
            return (arr[mid - 1] + arr[mid]) / 2.0;
        } else {
            return arr[mid];
        }
    }

    public static double findMedianUtil(int[] A, int[] B, int startA, int endA, int startB, int endB) {
        if (endA - startA == 1) {
            // Only two elements left in each array
            int[] merged = {
                    Math.min(A[startA], B[startB]),
                    Math.max(A[startA], B[startB]),
                    Math.min(A[endA], B[endB]),
                    Math.max(A[endA], B[endB])
            };
            java.util.Arrays.sort(merged);
            return (merged[1] + merged[2]) / 2.0;
        }

        double m1 = getMedian(A, startA, endA);
        double m2 = getMedian(B, startB, endB);

        int len = endA - startA + 1;

        if (m1 == m2) return m1;

        if (m1 < m2) {
            return findMedianUtil(A, B, startA + len / 2, endA, startB, startB + len / 2);
        } else {
            return findMedianUtil(A, B, startA, startA + len / 2, startB + len / 2, endB);
        }
    }

    public static double findMedian(int[] A, int[] B) {
        int n = A.length;
        return findMedianUtil(A, B, 0, n - 1, 0, n - 1);
    }

    public static void main(String[] args) {
        int[] A = {1, 12, 15, 26, 38};
        int[] B = {2, 13, 17, 30, 45};

        double median = findMedian(A, B);
        System.out.println("Median of merged arrays: " + median);
    }
}
