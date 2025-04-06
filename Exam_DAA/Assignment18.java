package Exam_DAA;

import java.util.Arrays;

public class Assignment18 {

    public static int minCoins(int[] coins, int V) {
        int[] dp = new int[V + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0; // Base case

        for (int i = 1; i <= V; i++) {
            for (int coin : coins) {
                if (i >= coin && dp[i - coin] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }

        return dp[V] == Integer.MAX_VALUE ? -1 : dp[V];
    }

    public static void main(String[] args) {
        int[] coins = {1, 3, 5}; // Coin denominations
        int V = 11;              // Target value

        int result = minCoins(coins, V);
        if (result != -1) {
            System.out.println("Minimum number of coins to make Rs." + V + " is: " + result);
        } else {
            System.out.println("Not possible to make Rs." + V + " with given coins.");
        }
    }
}
