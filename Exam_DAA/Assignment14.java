package Exam_DAA;

import java.util.*;

class Job {
    String id;
    int deadline;
    int profit;

    Job(String id, int deadline, int profit) {
        this.id = id;
        this.deadline = deadline;
        this.profit = profit;
    }
}

public class Assignment14 {

    // Function to schedule jobs to maximize profit
    public static void jobSequencing(Job[] jobs) {
        // Step 1: Sort jobs by decreasing profit
        Arrays.sort(jobs, (a, b) -> b.profit - a.profit);

        int n = jobs.length;

        // Step 2: Find max deadline to size time slots
        int maxDeadline = 0;
        for (Job job : jobs) {
            maxDeadline = Math.max(maxDeadline, job.deadline);
        }

        String[] schedule = new String[maxDeadline + 1]; // 1-indexed
        boolean[] slotTaken = new boolean[maxDeadline + 1];

        int totalProfit = 0;

        for (Job job : jobs) {
            // Try to schedule the job at the latest available slot before its deadline
            for (int t = job.deadline; t > 0; t--) {
                if (!slotTaken[t]) {
                    schedule[t] = job.id;
                    slotTaken[t] = true;
                    totalProfit += job.profit;
                    break;
                }
            }
        }

        System.out.println("Job sequence for max profit:");
        for (int i = 1; i <= maxDeadline; i++) {
            if (slotTaken[i]) {
                System.out.print(schedule[i] + " ");
            }
        }
        System.out.println("\nTotal Profit: " + totalProfit);
    }

    public static void main(String[] args) {
        Job[] jobs = {
            new Job("a", 2, 100),
            new Job("b", 1, 19),
            new Job("c", 2, 27),
            new Job("d", 1, 25),
            new Job("e", 3, 15)
        };

        jobSequencing(jobs);
    }
}
