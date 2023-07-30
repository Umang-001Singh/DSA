package DynamicProgramming;

import java.util.Arrays;

public class BuyAndSellStockII {
    public static void main(String[] args) {
        int []prices = {7, 1, 5, 3, 6, 4};
        int [][]dp = new int[prices.length+1][2];
        for(int []row: dp){
            Arrays.fill(row, -1);
        }
        int ans = profit(prices, 0, 1, dp);
        System.out.println(ans);
    }

    public static int profit(int []prices,int i, int option, int [][]dp){
        // int cost = 0;

        // if(i>prices.length-1){
        //     return 0;
        // }

        // if(dp[i][option] != -1){
        //     return dp[i][option];
        // }

        // if(option == 1){
        //     cost = Math.max(-prices[i] + profit(prices, i+1, 0,dp), 0 + profit(prices, i+1, 1, dp));
        // }
        // else{
        //     cost = Math.max(prices[i] + profit(prices, i+1, 1, dp), 0 + profit(prices, i+1, 0, dp)); 
        // }
        // return dp[i][option] = cost;

        // TABULATION

        for(int col = 1;col>=0;col--){
            dp[prices.length][col] = 0;
        }

        for(int row = prices.length-1;row>=0;row--){
            int cost =0;
            for(int c = 1;c>=0;c--){
                if(c == 1){
                    cost = Math.max(-prices[row] + dp[row+1][0], 0 + dp[row+1][1]);
                }
                else{
                    cost = Math.max(prices[row] + dp[row+1][1], 0 + dp[row+1][0]); 
                }
                dp[row][c] = cost;
            }
        }
        return dp[i][option];
    }
}
