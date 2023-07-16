package BinarySearch;

public class RepeatedElementsRotatedBS {
    public static void main(String[] args) {
        int [] nums={2,2,2,0,0,1};
        int [] nums1={1,2,2,2,0,1,1};
        int [] nums2={1,1,1,1,1,1,1,1,1,1,1,1,1,2,1,1,1,1,1};
        int pivot=SearchPivot(nums);
        System.out.println(pivot);
        pivot=SearchPivot(nums1);
        System.out.println(pivot);
        pivot=SearchPivot(nums2);
        System.out.println(pivot);

    }

    static int SearchPivot(int []nums){
        int start =0;
        int end=nums.length-1;
        int mid = start+(end-start)/2;
        int midR=mid;
        int midL=mid;

        while(midR>0 && midR<nums.length-1){
            if(((nums[midR-1]<nums[midR])&& (nums[midR]>nums[midR+1])) || ((nums[midR-1]==nums[midR])&& nums[midR]>nums[midR+1])){
                return midR;
            }
            midR++;
        }
        while(midL>0 && midL<nums.length-1){
            if(((nums[midL]>nums[midL-1] && nums[midL]>nums[midL+1]) || ((nums[midL-1]==nums[midL])&& (nums[midL]>nums[midL+1])))){
                return midL;
            }
            midL--;
        }
        if(nums.length ==1){
            return 0;
        }
        if(nums[0]>nums[1]){
            return 0;
        }
        return -1;
    }

}


