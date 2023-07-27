package DynamicProgramming;

import java.util.Arrays;

public class SubsetEqualsK {
    public static void main(String[] args) {
        int []arr = {-1, -1, 1};
        int target = 0;
        int k = target;
        int [][]dp = new int[arr.length][target + 1];
        for(int []row: dp){
            Arrays.fill(row, Integer.MIN_VALUE);
        }
        int ans = count(arr, arr.length-1, target,k,dp);
        System.out.println(ans);
    }

    public static int count(int []arr,int ind, int target,int k,int [][]dp){
        // FOR CONTIGOUS SUBSEQUENCE
        if(target == 0 && k!=0){
            return 1;
        }

        if(ind == 0){
            if(arr[ind] >= 0 && target==arr[ind]){
                return 1;
            }
            else if(arr[ind] < 0 && target==arr[ind]){
                return 1;
            }
            else{
                return 0;
            }
        }

        if(dp[ind][target] != Integer.MIN_VALUE){
            return dp[ind][target];
        }

        int take = 0;
        int nottake = 0;
        if(arr[ind] <= target){
            int ntarget = 0;
            if(arr[ind] <0){
                ntarget = target + Math.abs(arr[ind]);
            }
            else{
                ntarget = target - arr[ind];
            }
            take = count(arr, ind-1,ntarget,k,dp);
        }

        if(k == target){
            nottake = count(arr, ind-1, target, k,dp);
        }
        


        int FinCount = take + nottake;

        return dp[ind][target] = FinCount;
        
    }
}
