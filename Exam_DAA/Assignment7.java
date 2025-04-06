package Exam_DAA;

import java.util.*;

public class Assignment7 {

    static class Result {
        int min, secondMin;
        int max, secondMax;

        Result(int min, int secondMin, int max, int secondMax) {
            this.min = min;
            this.secondMin = secondMin;
            this.max = max;
            this.secondMax = secondMax;
        }
    }

    public static Result findSecondMinMax(int[] arr, int left, int right) {
        if (right - left == 1) {
            int min = Math.min(arr[left], arr[right]);
            int max = Math.max(arr[left], arr[right]);
            return new Result(min, max, max, min);
        }

        if (left == right) {
            return new Result(arr[left], Integer.MAX_VALUE, arr[left], Integer.MIN_VALUE);
        }

        int mid = (left + right) / 2;
        Result leftRes = findSecondMinMax(arr, left, mid);
        Result rightRes = findSecondMinMax(arr, mid + 1, right);

        // Get smallest and second smallest
        int[] minArr = {leftRes.min, leftRes.secondMin, rightRes.min, rightRes.secondMin};
        Arrays.sort(minArr);
        int min = minArr[0], secondMin = Integer.MAX_VALUE;
        for (int val : minArr) {
            if (val > min) {
                secondMin = val;
                break;
            }
        }

        // Get largest and second largest
        int[] maxArr = {leftRes.max, leftRes.secondMax, rightRes.max, rightRes.secondMax};
        Arrays.sort(maxArr);
        int max = maxArr[3], secondMax = Integer.MIN_VALUE;
        for (int i = 2; i >= 0; i--) {
            if (maxArr[i] < max) {
                secondMax = maxArr[i];
                break;
            }
        }

        return new Result(min, secondMin, max, secondMax);
    }

    public static void main(String[] args) {
        int[] arr = {12, 3, 5, 7, 19, 4, 8};
        int n = arr.length;

        Result result = findSecondMinMax(arr, 0, n - 1);

        System.out.println("Second Smallest: " + result.secondMin);
        System.out.println("Second Largest: " + result.secondMax);
    }
}

