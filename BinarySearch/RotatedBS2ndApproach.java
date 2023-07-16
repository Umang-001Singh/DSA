package BinarySearch;

public class RotatedBS2ndApproach {
    public static void main(String[] args) {
        int [] nums={2,3,5,7 ,0,1};
        int target=1;
        int pivot=SearchPivot(nums);
        int ans=0;
        if(pivot==-1){
            ans=BinarySearch(nums,target,0,nums.length-1);
        }
        else{
            if(target < nums[0]){
                ans=BinarySearch(nums, target, pivot+1, nums.length-1);
            }
            if(target>nums[0]){
                ans=BinarySearch(nums, target, 0, pivot -1);
            }
            if(target == nums[pivot]){
                ans=pivot;
            }
        }
        System.out.println(ans);

    }

    static int SearchPivot(int []arr){
        int start=0;
        int end= arr.length -1;
        while(start<=end){
            int mid= start + (end-start )/2;
            if(mid<end && arr[mid]>arr[mid+1]){
                return mid;
            }
            if(mid>start && arr[mid]<arr[mid-1]){
                return mid-1;
            }
            if(arr[start]<arr[mid]){
                start= mid+1;
            }
            if(arr[start]>arr[mid]){
                end=mid-1;
            }
        }
        return -1;
    }

    static int BinarySearch(int[] arr, int target, int start,int end){

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
