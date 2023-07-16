package BinarySearch;

public class SearchElementInInfiniteArray {
    public static void main(String[] args) {
        int[] arr = {3, 5, 7, 9, 10, 90, 100, 120, 130, 140};

        int target =7;
        int ans = 0;
        ans = Search(arr, target);
        System.out.println(ans);
    }

    static int Search(int[] arr, int target) {
        int start = 0;
        int end = 1;
        int newStart = 0;
        int ansI;
       while(target>arr[end]){
            newStart = end + 1;
            end = end + (end - start + 1) * 2;
            start = newStart;
        }
        ansI=AscBs(arr,target,start,end);
        return ansI;
    }


    public static int AscBs(int[] arr, int target, int start, int end) {

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (target < arr[mid]) {
                end = mid - 1;
            } else if (target > arr[mid]) {
                start = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}