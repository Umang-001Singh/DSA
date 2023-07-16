package DynamicProgramming;

import java.util.Arrays;

public class FrogJumpStairs {
    public static void main(String[] args) {
        int []arr = {30,10,60,10,60,50};
        int []dp = new int[arr.length+1];
        Arrays.fill(dp, Integer.MAX_VALUE);

        System.out.println(energy(arr, dp, arr.length-1));

    }

    public static int energy(int []arr,int []dp, int n){ //HERE n REPRESENTS INDEX VALUE.
        // if(n == 0){
        //     return 0;
        // }
        // if(dp[n] != Integer.MAX_VALUE){
        //     return dp[n];
        // }
        // int left = energy(arr,dp, n-1) + Math.abs(arr[n] - arr[n-1]);
        // int right = 0;
        // if(n>1){
        // right = energy(arr, dp, n-2)+ Math.abs(arr[n] -arr[n-2]);
        // }

        // dp[n] = Math.min(left, right);
        // return dp[n];

        // METHOD 2:- TABULATION
        dp[0] =0;
        for (int i = 1; i <=n; i++) {
            int left = dp[i-1] + Math.abs(arr[i] - arr[i-1]);
            int right =0;
            if(i>1){
                right = dp[i-2] + Math.abs(arr[i] - arr[i-2]);

            }

            dp[i] = Math.min(left,right);
            
        }

        return dp[n];
    }
}
