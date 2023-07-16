package Recursion;

public class BinarySearch {
    public static void main(String [] args){
        int [] arr={1,2,3,4,55,66,78};
        int target=78;
        System.out.println(binarysearch(arr, 0, arr.length-1,target));

    }

    static int binarysearch(int [] arr, int start, int end, int target){
        if(start>end){
            return -1;
        }

        int mid=start+(end-start)/2;
        if(arr[mid]==target){
            return mid;
        }

        if(arr[mid]<target){
            return binarysearch(arr, mid+1,arr.length-1,target);
        }
        else{
            return binarysearch(arr, 0, mid-1, target);
        }

    }
}
