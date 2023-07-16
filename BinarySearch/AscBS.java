package BinarySearch;

public class AscBS {
    public static void main (String [] args){
        int [] arr={2,3,5,6,6,11,12,15,19};
        int target=19;
        int ans=AscBs(arr,target);
        System.out.println(ans);
    }

static int AscBs(int [] arr, int target){
        int start=0;
        int end=arr.length-1;
        while(start<=end){
            int mid=start +(end-start)/2;
            if(target<arr[mid]){
                end=mid-1;
            }
            else if(target>arr[mid]){
                start=mid +1;
            }
            else{
                return mid;
            }
        }
        return -1;

}

}
