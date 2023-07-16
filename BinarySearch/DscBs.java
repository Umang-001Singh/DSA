package BinarySearch;

public class DscBs {
    public static void main(String [] args){
        int [] arr={25,19,16,15,10,9,5,3,2,-2};
        int target=-2;
        int ans=DscBs(arr, target);
        System.out.println(ans);

    }

    static int DscBs(int [] arr, int target){
        int start=0;
        int end=arr.length-1;
        while(start<=end){
            int mid = start + (end-start)/2;
            if(target<arr[mid]){
                start=mid+1;
            }
            else if( target > arr[mid]){
                end=mid-1;
            }
            else {
                return mid;
            }
        }
        return -1;
    }
}
