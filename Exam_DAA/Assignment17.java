package Exam_DAA;

public class Assignment17 {

    // Returns minimum cost to reach (m, n) from (0, 0)
    public static int minCostPath(int[][] cost, int m, int n) {
        int rows = cost.length;
        int cols = cost[0].length;

        int[][] dp = new int[rows][cols];
        dp[0][0] = cost[0][0];

        // Initialize first column
        for (int i = 1; i <= m; i++) {
            dp[i][0] = dp[i - 1][0] + cost[i][0];
        }

        // Initialize first row
        for (int j = 1; j <= n; j++) {
            dp[0][j] = dp[0][j - 1] + cost[0][j];
        }

        // Fill the rest of dp table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = cost[i][j] + Math.min(
                        dp[i - 1][j],
                        Math.min(dp[i][j - 1], dp[i - 1][j - 1])
                );
            }
        }

        return dp[m][n];
    }

    public static void main(String[] args) {
        int[][] cost = {
            {1, 2, 3},
            {4, 8, 2},
            {1, 5, 3}
        };
        int m = 2, n = 2;

        int result = minCostPath(cost, m, n);
        System.out.println("Minimum cost to reach (" + m + ", " + n + ") is: " + result);
    }
}
