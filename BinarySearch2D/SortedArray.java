package BinarySearch2D;

import java.util.Arrays;

public class SortedArray {
    public static void main(String []args){
        int [][]arr={
                {1,3}
        };
        System.out.println(Arrays.toString(Search(arr,3)));

    }

    static int[] Search(int [][] arr, int target) {

        if(arr[0].length==1 && arr.length==1) {
            if (arr[0][0] == target) {
                return new int[]{0, 0};
            } else {
                return new int[]{-1, -1};
            }
        }
        int r = 0;
        int a=0;
        int c = arr.length - 1;


        while (r < arr.length) {
            if (arr[r][arr[0].length-1] >= target) {
                a = r ;
                break;
            }
            r++;
        }
        int start = 0;
        int end = arr[0].length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (target < arr[a][mid]) {
                end = mid - 1;
            } else if (target > arr[a][mid]) {
                start = mid + 1;
            } else {
                return new int[]{r , mid};
            }
        }
        return new int[]{-1,-1};
    }
}
