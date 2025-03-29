package Searching.LinearSearch;

public class Leetcode1295 {
    static boolean evenDigit(int num){
        if(num == 0){
            return false;
        }
        int count = 0;
        while(num > 0){
            count++;
            num = num/10;
        }
        return count%2 == 0;
    }

    static int findNumbers(int[] nums){
        int count = 0;
        for(int num : nums){
            if(evenDigit(num)){
                count++;
            }
        }
        return count;
    }


    public static void main(String[] args) {
        int[] arr = {12,345,2,6,7896};
        int answer = findNumbers(arr);
        System.out.println(answer);
    }
}
