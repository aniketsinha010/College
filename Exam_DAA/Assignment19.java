package Exam_DAA;

public class Assignment19 {

    public static boolean isSubsetSum(int[] arr, int sum) {
        int n = arr.length;
        boolean[][] dp = new boolean[n + 1][sum + 1];

        // Sum 0 is always possible with empty subset
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }

        // Fill the subset sum table
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                if (arr[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - arr[i - 1]];
                }
            }
        }

        return dp[n][sum];
    }

    public static void main(String[] args) {
        int[] arr = {3, 34, 4, 12, 5, 2};
        int sum = 9;

        if (isSubsetSum(arr, sum)) {
            System.out.println("Found a subset with given sum.");
        } else {
            System.out.println("No subset with given sum.");
        }
    }
}
