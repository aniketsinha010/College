package Exam_DAA;

import java.util.Arrays;

public class Assignment16 {

    // Add padding to make odd-sized matrices even
    static int[][] padMatrix(int[][] matrix, int size) {
        int[][] padded = new int[size + 1][size + 1];
        for (int i = 0; i < size; i++)
            System.arraycopy(matrix[i], 0, padded[i], 0, size);
        return padded;
    }

    static int[][] trimMatrix(int[][] matrix, int size) {
        int[][] trimmed = new int[size][size];
        for (int i = 0; i < size; i++)
            System.arraycopy(matrix[i], 0, trimmed[i], 0, size);
        return trimmed;
    }

    static int[][] add(int[][] A, int[][] B) {
        int n = A.length;
        int[][] result = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                result[i][j] = A[i][j] + B[i][j];
        return result;
    }

    static int[][] subtract(int[][] A, int[][] B) {
        int n = A.length;
        int[][] result = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                result[i][j] = A[i][j] - B[i][j];
        return result;
    }

    static int[][] strassen(int[][] A, int[][] B) {
        int n = A.length;

        // Base case
        if (n == 1) {
            int[][] C = {{A[0][0] * B[0][0]}};
            return C;
        }

        int mid = n / 2;

        // Partition matrices into quadrants
        int[][] A11 = new int[mid][mid], A12 = new int[mid][mid], A21 = new int[mid][mid], A22 = new int[mid][mid];
        int[][] B11 = new int[mid][mid], B12 = new int[mid][mid], B21 = new int[mid][mid], B22 = new int[mid][mid];

        for (int i = 0; i < mid; i++) {
            for (int j = 0; j < mid; j++) {
                A11[i][j] = A[i][j];
                A12[i][j] = A[i][j + mid];
                A21[i][j] = A[i + mid][j];
                A22[i][j] = A[i + mid][j + mid];

                B11[i][j] = B[i][j];
                B12[i][j] = B[i][j + mid];
                B21[i][j] = B[i + mid][j];
                B22[i][j] = B[i + mid][j + mid];
            }
        }

        // Strassen's 7 matrix products
        int[][] M1 = strassen(add(A11, A22), add(B11, B22));
        int[][] M2 = strassen(add(A21, A22), B11);
        int[][] M3 = strassen(A11, subtract(B12, B22));
        int[][] M4 = strassen(A22, subtract(B21, B11));
        int[][] M5 = strassen(add(A11, A12), B22);
        int[][] M6 = strassen(subtract(A21, A11), add(B11, B12));
        int[][] M7 = strassen(subtract(A12, A22), add(B21, B22));

        // Combine results into one matrix
        int[][] C = new int[n][n];
        for (int i = 0; i < mid; i++) {
            for (int j = 0; j < mid; j++) {
                C[i][j] = M1[i][j] + M4[i][j] - M5[i][j] + M7[i][j];
                C[i][j + mid] = M3[i][j] + M5[i][j];
                C[i + mid][j] = M2[i][j] + M4[i][j];
                C[i + mid][j + mid] = M1[i][j] - M2[i][j] + M3[i][j] + M6[i][j];
            }
        }

        return C;
    }

    public static void main(String[] args) {
        int[][] A = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        int[][] B = {
            {9, 8, 7},
            {6, 5, 4},
            {3, 2, 1}
        };

        int n = A.length;

        // Pad matrices if size is odd
        boolean padded = false;
        if (n % 2 != 0) {
            A = padMatrix(A, n);
            B = padMatrix(B, n);
            padded = true;
            n += 1;
        }

        int[][] C = strassen(A, B);

        if (padded) {
            C = trimMatrix(C, n - 1);
        }

        System.out.println("Product matrix:");
        for (int[] row : C) {
            System.out.println(Arrays.toString(row));
        }
    }
}
