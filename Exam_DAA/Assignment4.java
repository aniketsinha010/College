package Exam_DAA;

public class Assignment4 {

    static int findBitonic(int[] arr){
        for(int i=1;i<arr.length-1;i++){
            if(arr[i] > arr[i-1] && arr[i] > arr[i+1]){
                return arr[i];
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] sequence = {1, 3, 8, 12, 10, 7, 5};
        int ans = findBitonic(sequence);
        System.out.println(ans);
    }
}
