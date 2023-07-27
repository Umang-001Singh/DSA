package DynamicProgramming;

import java.util.Arrays;

public class MinimumFallingSum {
    public static void main(String[] args) {
        int [][]arr = {{82,81},
                        {69,33}};
        int ans = helper(arr);
        System.out.println(ans);
    }

    public static int helper(int [][]arr){
        int row = arr.length;
        int col = arr[0].length;
        int [][]dp = new int[row][col];
        for(int []r: dp){
            Arrays.fill(r, Integer.MAX_VALUE);
        }

        int Merit = Integer.MAX_VALUE;
        int ans = 0;
        for(int i=0;i<arr[0].length;i++){
            ans = minSum(arr, 0, i, dp);
            Merit = Math.min(ans, Merit);

        }
        return Merit;
        
    }

    public static int minSum(int [][]arr, int row, int col, int [][]dp){
        // MEMOIZATION METHOD
        // if(row == arr.length-1 && col>=0 && col<=arr[row].length-1){
        //     return arr[row][col];
        // }

        // if(row>arr.length-1 || col<0 || col>arr[0].length-1){
        //     return Integer.MAX_VALUE;
        // }

        // if(dp[row][col] != Integer.MAX_VALUE){
        //     return dp[row][col];
        // }

        // int rightd = minSum(arr, row+1, col+1, dp);
        // int down = minSum(arr, row+1, col, dp);
        // int leftd = minSum(arr, row+1, col-1, dp);

        // int value = arr[row][col] + Math.min(rightd, Math.min(down, leftd));

        // return dp[row][col] = value;

        // TABULATION METHOD

        for(int i = 0;i<arr[0].length;i++){
            dp[arr.length-1][i] = arr[arr.length-1][i];
        }

        for(int i = arr.length-2;i>=0;i--){
            int rightd = 0;
            int down = 0;
            int leftd = 0;
            for(int j = 0;j<=arr[0].length-1;j++){
                if(j+1>arr[0].length-1){
                    rightd = Integer.MAX_VALUE;
                }
                else{
                rightd = dp[i+1][j+1];

                }

                
                down = dp[i+1][j];

                
                if(j-1<0){
                leftd = Integer.MAX_VALUE;

                }
                else{
                    leftd = dp[i+1][j-1];
                }

                int value = arr[i][j] + Math.min(down, Math.min(rightd, leftd));
                dp[i][j] = value;
            }
        }

        return dp[row][col];
    }
}
