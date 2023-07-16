package BinarySearch;




//Incorrect Solution





import java.util.Arrays;

public class FirstLastPosition1 {
    public static void main(String[] args) {
        int []nums={2,2};
        int target = 2;
        int []ans;
        ans=FirstLastPosition(nums, target);
        System.out.println(Arrays.toString(ans));

    }

    static int [] FirstLastPosition(int [] nums, int target){
        int []ans={-1,-1};
        int start=0;
        int end=nums.length-1;
        while(start<=end){
            int mid=start + (end-start)/2;
            if(target<nums[mid]){
                end=mid-1;
            }
            else if(target>nums[mid]){
                start=mid+1;
            }
            else {
                int midI=mid;
                if(mid!=0){
                    while(target==nums[midI]){
                        midI--;
                    }
                    ans[0]=midI;
                }
                if(mid==0){
                    ans[0]=mid;
                }
                midI=mid;
                if(midI!=(nums.length-1)){
                    while(target == nums[midI]){
                        midI++;
                    }
                    ans[1]=midI;
                }
                if(mid==(nums.length-1)){
                    ans[1]=mid;
                }
                return ans;
            }
        }
        return ans;
    }
}
