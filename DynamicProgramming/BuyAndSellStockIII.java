package DynamicProgramming;

import java.util.Arrays;

public class BuyAndSellStockIII {
    public static void main(String[] args) {
        int []prices = {3, 3, 5, 0, 0, 3, 1, 4};
        int [][][]dp = new int[prices.length+1][2][3];
        for(int [][]row: dp){
            for(int []r: row){
                Arrays.fill(r, 0);
            }
        }
        int ans = profit(prices, 0, 1, 2, dp);
        System.out.println(ans);
    }

    public static int profit(int []arr, int i, int op, int c, int [][][]dp){
        // int cost = 0;
        // if(i>arr.length-1){
        //     return 0;
        // }

        // if(c == 0){
        //     return 0;
        // }

        // if(dp[i][op][c] != -1){
        //     return dp[i][op][c];
        // }

        // if(op == 1){
        //     cost = Math.max(-arr[i] +profit(arr, i+1, 0, c, dp), 0 + profit(arr, i+1, 1, c, dp));
        // }
        // else{
        //     cost = Math.max(arr[i] + profit(arr, i+1, 1, c-1, dp), 0 + profit(arr, i+1, 0, c, dp));
        // }

        // return dp[i][op][c] = cost;
        
        for(int col = 0;col<=op;col++){
            for(int dep = 0;dep<=c;dep++){
                dp[arr.length][col][dep] = 0;
            }
        }

        for(int row = 0;row<=arr.length;row++){
            for(int col = 0;col<=op;col++){
                dp[row][col][0] = 0;
            }
        }

        for(int row = arr.length-1;row>=0;row--){
            int cost = 0;

            for(int col = 0;col<=op;col++){
                for(int dep = 1;dep<=c;dep++){
                    if(col == 1){
                        cost = Math.max(-arr[row] + dp[row+1][0][dep], 0 + dp[row+1][1][dep]);
                    }
                    else{
                        cost = Math.max(arr[row] + dp[row+1][1][dep-1], 0 + dp[row+1][0][dep]);
                    }

                    dp[row][col][dep] = cost;
                }
            }
        }
        return dp[i][op][c];



    }
}
