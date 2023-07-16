package BinarySearch;

public class FloorOfANo {
    public static void main(String [] args){
        int []arr={2,3,5,6,7,11,12,15,19};
        int target=10;
        int ans=floor(arr,target);
        System.out.println(ans);
    }
    static int floor(int []arr, int target){
        int start =0;
        int end =arr.length -1;
        int mid=0;
        while(start<=end){
            mid=start +(end-start)/2;
            if(target<arr[mid]){
                end=mid-1;
            }
            else if(target>arr[mid]){
                start=mid+1;
            }

            else
                return arr[mid];
        }
        if(target>arr[mid]){
            return arr[mid];
        }
            else if(target<arr[0]){
                return -1;
            }
            else
                return arr[mid-1];
        }
    }

