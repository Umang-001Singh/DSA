package DynamicProgramming;

import java.util.Arrays;

public class KnapSack {
    public static void main(String[] args) {
        int []val = {1, 2, 3};
        int []wt = {4, 5, 1};
        int cap = 3;
        int [][]dp = new int[val.length][cap + 1];
        for(int []r: dp){
            Arrays.fill(r, -1);
        }

        int ans = maxValue(val, wt, val.length-1, cap, dp);
        System.out.println(ans);
    }

    public static int maxValue(int []val, int []wt, int ind,int remWt, int [][]dp){
        // MEMOIZATION METHOD
        // if(remWt < 0){
        //     return 0;
        // }

        // if(ind == 0){
        //     if( wt[0]<=remWt){
        //         return val[0];
        //     }
        //     else{
        //         return 0;
        //     }
        // }

        // if(dp[ind][remWt] != -1){
        //     return dp[ind][remWt];
        // }
        // int pick = 0;
        // if(wt[ind] <= remWt){
        //     pick = val[ind] + maxValue(val, wt, ind-1, remWt-wt[ind],dp);
        // }
        // int notpick = 0 + maxValue(val, wt, ind-1, remWt, dp);

        // int value = Math.max(pick, notpick);

        // return dp[ind][remWt] = value;

        // TABULATION METHOD
        dp[0][0] = 0;
        for(int i = 1;i<remWt+1;i++){
            if(wt[0] <= i){
                dp[0][i] = val[0];
            }
            else{
                dp[0][i] = 0;
            }
        }

        for(int i = 1;i<val.length;i++){
            // int pick = 0;
            // int notpick = 0;
            for(int rem = 0;rem <=remWt; rem++){
                int pick = 0;
                if(wt[i] <= rem){
                    pick = val[i] + dp[i-1][rem-wt[i]];
                }
                int notpick = 0 + dp[i-1][rem];

                int value = Math.max(pick, notpick);

                dp[i][rem] = value;
            }

            
        }

        return dp[ind][remWt];
    }
}
