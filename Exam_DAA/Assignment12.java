package Exam_DAA;

public class Assignment12 {

    // Function to print optimal parenthesization
    static void printParenthesis(int[][] s, int i, int j, char[] name) {
        if (i == j) {
            System.out.print(name[0]++);
            return;
        }

        System.out.print("(");
        printParenthesis(s, i, s[i][j], name);
        printParenthesis(s, s[i][j] + 1, j, name);
        System.out.print(")");
    }

    public static void matrixChainOrder(int[] p) {
        int n = p.length - 1;
        int[][] m = new int[n + 1][n + 1];
        int[][] s = new int[n + 1][n + 1];

        for (int l = 2; l <= n; l++) { // l is the chain length
            for (int i = 1; i <= n - l + 1; i++) {
                int j = i + l - 1;
                m[i][j] = Integer.MAX_VALUE;

                for (int k = i; k < j; k++) {
                    int cost = m[i][k] + m[k + 1][j] + p[i - 1] * p[k] * p[j];

                    if (cost < m[i][j]) {
                        m[i][j] = cost;
                        s[i][j] = k;
                    }
                }
            }
        }

        System.out.println("Minimum number of multiplications: " + m[1][n]);
        System.out.print("Optimal Parenthesization: ");
        printParenthesis(s, 1, n, new char[]{'A'});
        System.out.println();
    }

    public static void main(String[] args) {
        int[] dimensions = {40, 20, 30, 10, 30};
        matrixChainOrder(dimensions);
    }
}
