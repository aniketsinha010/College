
import java.util.Arrays;
import java.util.ArrayList;

public class Main2 {

    static ArrayList<int[]> findSum(int[] arr,int target){
        ArrayList<int[]> list = new ArrayList<>();
        int start = 0;
        int end = arr.length-1;
        while(start < end){
            int currentSum = arr[start] + arr[end];
            if(currentSum == target){
                list.add(new int[]{arr[start],arr[end]});
                start++;
                end--;
            }
            else if(currentSum < target){
                start++;
            }
            else end--;
        }
        return list;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9};
        int target = 10;
        ArrayList<int[]> answer = findSum(arr,target);
        for(int[] pairs : answer){
            System.out.println(Arrays.toString(pairs));
        }
    }
}