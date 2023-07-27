package DynamicProgramming;

import java.util.Arrays;

public class RodCutting {
    public static void main(String[] args) {
        int []val = {3,5,8,9,10,17,17,20};
        int N = 8;
        int [][]dp = new int[val.length][N+1];
        for(int []row: dp){
            Arrays.fill(row, -1);
        }
        int ans = maxValue(val, val.length-1, N, dp);
        System.out.println(ans);
    }

    public static int maxValue(int []arr, int ind, int remLen, int [][]dp){
        // if(remLen == 0){
        //     return 0;
        // }

        // if(ind<0){
        //     return 0;
        // }

        // if(dp[ind][remLen] != -1){
        //     return dp[ind][remLen];
        // }

        // int pick = 0;
        // if(ind+1 <= remLen){
        //     pick = arr[ind] + maxValue(arr, ind, remLen-(ind + 1), dp);
        // }

        // int notpick = 0 + maxValue(arr, ind-1, remLen, dp);

        // int value = Math.max(pick, notpick);
        // return dp[ind][remLen] = value;

        // TABULATION
        dp[0][0] = 0;
        for(int i = 1;i<=remLen;i++){
            dp[0][i] = i*arr[0];
        }

        for(int i = 1;i<arr.length;i++){
            for(int j = 0;j<=remLen;j++){
                int pick = 0;
                if((i+1) <= j){
                    pick = arr[i] + dp[i][j-(i+1)];
                }

                int notpick = 0 + dp[i-1][j];

                int value = Math.max(pick, notpick);
                dp[i][j] = value;
            }
        }
        return dp[ind][remLen];
    }
}
