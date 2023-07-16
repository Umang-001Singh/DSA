package BinarySearch;

public class RotatedBS1stApproach {
public static void main (String [] args){
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

    static int SearchPivot(int []nums){
        int start =0;
        int end=nums.length-1;
        int mid = start+(end-start)/2;
        int midR=mid;
        int midL=mid;
        if(nums[0]<nums[midR]){
        while(midR<nums.length-1 && midR>0){
            if(nums[midR]>nums[midR+1] && nums[midR]>nums[midR-1]){
                return midR;
            }
            midR++;
        }}
        if(nums[0]>nums[midL]){
        while(midL>0 && midL<nums.length-1){
            if(nums[midL]>nums[midL+1]&& nums[midL]>nums[midL-1]){
                return midL;
            }
            midL--;
        }}
        if(nums.length ==1){
            return 0;
        }

        if(nums[0]>nums[1]){
            return 0;
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
