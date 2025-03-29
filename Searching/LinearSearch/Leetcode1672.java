package Searching.LinearSearch;

public class Leetcode1672 {
    static int maxWealth(int[][] accounts){
        int answer = Integer.MIN_VALUE;
        for(int row=0; row<accounts.length; row++){
            int sum = 0; // a new sum for every row...
            for(int column=0; column<accounts[row].length; column++){
                sum = sum + accounts[row][column];
            }
            if(sum > answer){
                answer = sum;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int[][] arr = {{1,5},{7,3},{3,5}};
        int answer = maxWealth(arr);
        System.out.println(answer);
    }
}
