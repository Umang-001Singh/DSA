package DynamicProgramming;

import java.util.Arrays;

public class FrogJumpWithKDistance {
    public static void main(String[] args) {
        int []arr = {30,10,60,10,60,50};
        int []dp = new int[arr.length];
        Arrays.fill(dp, Integer.MAX_VALUE);
        int ans = energy(arr, dp, arr.length-1, 2);
        System.out.println(ans);
    }

    public static int energy(int []arr, int []dp, int n,int k){
        // MEMOIZATION METHOD
        // TIME COMPLEXITY = O(n*k)
        // SPACE COMPLEXITY = O(n) + O(n)
        // if(n==0){
        //     return 0;
        // }
        // if(dp[n] != Integer.MAX_VALUE){
        //     return dp[n];
        // }
        // int minVal = Integer.MAX_VALUE;
        
        //     for(int j = 1;j<=k;j++){
        //         if(n-j>=0){
        //             int jump = energy(arr, dp, n-j,k) + Math.abs(arr[n] - arr[n-j]);
        //             minVal = Math.min(minVal, jump);
        //         }
        //     }
        //     dp[n] = minVal;
        
        // return dp[n];

        //TABULAION METHOD 
        // TIME COMPLEXITY = O(n*k)
        // SPACE COMPLEXITY = O(n) 
        dp[0] = 0;
        for(int i = 1;i<=n;i++){
            int minVal = Integer.MAX_VALUE; 
            for(int j = 1;j<=k;j++){
                if(i-j>=0){
                    int jump = energy(arr, dp, i-j, k) + Math.abs(arr[i] - arr[i-j]);
                    minVal = Math.min(minVal, jump);
                }
            }
            dp[n] = minVal;
        }
        return dp[n];
    }
}
