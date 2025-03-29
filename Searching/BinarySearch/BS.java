package Searching.BinarySearch;

public class BS {
    static void binarySearch(int[] arr,int num){
        int start = 0;
        int end = arr.length - 1;
        int mid;
        boolean found = false;
        while(start <= end){
            mid = (start+end)/2;
            if(arr[mid] == num){
                System.out.printf("The number %d is at position : %d.",num,mid);
                found = true;
                break;
            }
            else{
                if(arr[mid] > num){
                    end = mid - 1;
                }
                else if(arr[mid] < num){
                    start = mid + 1;
                }
            }
        }
        if(!found){
            System.out.printf("The number %d is not in the array.",num);
        }
    }

    public static void main(String[] args) {
        int[] arr_1 = {1,2,3,4,5,6,7,8,9};
        binarySearch(arr_1,9);
    }
}
