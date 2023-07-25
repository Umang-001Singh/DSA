package DynamicProgramming;

import java.util.Arrays;

public class UniquePaths {
    public static void main(String[] args) {
        int m = 3;
        int n = 7;
        int [][]dp = new int[m][n];
        for(int []row: dp){
            Arrays.fill(row, 0);
        }
        int ans = paths(m-1, n-1, dp);
        System.out.println(ans);

    }

    public static int paths(int row, int col, int [][]dp){
        // MEMOIZATION METHOD
        // if(row == 0 && col == 0){
        //     return 1;
        // }

        // if(row<0 || col<0){
        //     return 0;
        // }

        // if(dp[row][col] != -1){
        //     return dp[row][col];
        // }

        // int down = paths(row-1, col,dp);
        // int right = paths(row, col -1,dp);

        // return dp[row][col] = down + right;

        // TABULATION METHOD

        
        for(int Row = 0;Row<=row;Row++){
            int down = 0 , right = 0;
            for(int Col=0;Col<=col;Col++){
                if(Row == 0 && Col == 0){
                    dp[0][0]= 1;
                }
                else{

                
                if(Row-1>=0){
                    down = dp[Row-1][Col];
                }
                if(Col -1 >=0){
                    right = dp[Row][Col-1];
                }
                dp[Row][Col]= down + right;
            }
            }
        }
        return dp[row][col];
    }
}
