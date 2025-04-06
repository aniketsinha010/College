package Exam_DAA;

import java.util.Arrays;

public class Assignment20 {

    static int tsp(int[][] graph) {
        int n = graph.length;
        int VISITED_ALL = (1 << n) - 1; // All cities visited
        int[][] dp = new int[1 << n][n];

        for (int[] row : dp) Arrays.fill(row, -1);

        return tspHelper(1, 0, graph, dp, n, VISITED_ALL);
    }

    // mask = visited cities, pos = current city
    static int tspHelper(int mask, int pos, int[][] graph, int[][] dp, int n, int VISITED_ALL) {
        if (mask == VISITED_ALL) {
            return graph[pos][0]; // return to start
        }

        if (dp[mask][pos] != -1) return dp[mask][pos];

        int min = Integer.MAX_VALUE;
        for (int city = 0; city < n; city++) {
            // If not visited
            if ((mask & (1 << city)) == 0) {
                int newCost = graph[pos][city] + tspHelper(mask | (1 << city), city, graph, dp, n, VISITED_ALL);
                min = Math.min(min, newCost);
            }
        }

        dp[mask][pos] = min;
        return min;
    }

    public static void main(String[] args) {
        int[][] graph = {
            {0, 10, 15, 20},
            {10, 0, 35, 25},
            {15, 35, 0, 30},
            {20, 25, 30, 0}
        };

        int minTourCost = tsp(graph);
        System.out.println("Minimum cost of TSP tour: " + minTourCost);
    }
}
