package Arrays;

class Solution {
    public static void main(String[] args) {
        int[] nums={555,901,482,1771};
        int Ans= findNumbers(nums);
        System.out.println(Ans);
    }
    static int findNumbers(int[] nums) {
        int ans=0;
    for(int i=0; i<nums.length;i++){//If vector is given instead of array, use nums.size(); to get the size of the vector.
        int num=nums[i];
        int count=0;
        while(num>0){
            num=num/10;
            count++;
        }
        if(count %2==0){
            ans++;
        }
    }

return ans;
    }
}
