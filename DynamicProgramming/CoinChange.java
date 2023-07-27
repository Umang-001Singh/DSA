package DynamicProgramming;

import java.util.Arrays;

public class CoinChange {
    public static void main(String[] args) {
        int []arr = {2, 2, 3};
        int target = 5;
        int [][]dp = new int[arr.length][target+1];
        for(int []r: dp){
            Arrays.fill(r, -1);
        }

        int ans = ways(arr, arr.length-1, target, dp);
        System.out.println(ans);
    }

    public static int ways(int []arr, int ind,int target, int [][]dp){
        // MEMOIZATION 
        // if(ind == 0){
        //     if(target % arr[0] == 0){
        //     return 1;
        // }
        // else{
        //     return 0;
        // }
        // }

        // if(ind<0){
        //     return 0;
        // }

        // if(dp[ind][target] != -1){
        //     return dp[ind][target];
        // }

        // int pick = 0;
        // if(arr[ind] <= target){
        //     pick = ways(arr, ind, target-arr[ind], dp);
        // }

        // int notpick = ways(arr, ind-1, target, dp);

        // int value = pick + notpick;

        // return dp[ind][target] = value;

        // TABULATION

        // dp[0][0] = 0;
        for(int i = 0;i<target + 1;i++){
            
            if(target%arr[0]==0){
                dp[0][i] = 1;
            }
            
            else{
                dp[0][i] = 0;
            }
        }

        for(int i = 1;i<=ind;i++){
            for(int j = 0;j<=target;j++){
                int pick = 0;
                
                if(arr[i] <= j){
                    pick = dp[i][j-arr[i]];
                }

                int notpick = dp[i-1][j];

                int value = pick + notpick;

                dp[i][j] = value;
                }
        }
        return dp[ind][target];
    }
}
