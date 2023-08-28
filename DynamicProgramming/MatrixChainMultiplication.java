package DynamicProgramming;

import java.util.Arrays;

public class MatrixChainMultiplication {
    public static void main(String[] args) {
        int N = 5;
        int[] arr = {40, 20, 30, 10, 30};
        int[][] dp = new int[N][N];
        for(int[] row: dp){
            Arrays.fill(row, -1);
        }
        int ans = multiplication(arr, 1, N-1, dp);
        System.out.println(ans);
    }

    public static int multiplication(int[] arr, int i, int j, int[][] dp){
        if(i == j){
            return 0;
        }

        if(dp[i][j] != -1){
            return dp[i][j];
        }

        int min = Integer.MAX_VALUE;
        for(int k = i;k<j;k++){
            int steps = multiplication(arr, i, k, dp) + multiplication(arr, k+1, j, dp) + arr[i-1] * arr[k] * arr[j];
            min = Math.min(min, steps);
        }
        return dp[i][j] = min;

        // if(i == j)
        // return 0;
            
        // if(dp[i][j]!=-1)
        //     return dp[i][j];
        
        // int mini = Integer.MAX_VALUE;
        
        // // partioning loop
        // for(int k = i; k<= j-1; k++){
            
        // int ans = multiplication(arr,i,k,dp) + multiplication(arr, k+1,j,dp) + arr[i-1]*arr[k]*arr[j];
            
        // mini = Math.min(mini,ans);
            
        // }
        
        // return mini;
    }
}
