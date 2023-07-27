package DynamicProgramming;

import java.util.Arrays;

public class Triangle {
    public static void main(String[] args) {
        int [][]arr = {{1},
                        {2,3},
                        {3,6,7},
                        {8,9,6,10}};
        int row = arr.length;
        int col = row;
        int ans = helper(arr, row-1, col-1);
        System.out.println(ans);
    }

    public static int helper(int [][]arr, int r, int c){
    //     int Merit = Integer.MAX_VALUE;
    //     int [][]dp = new int[r+1][c+1];
    //     for(int []row: dp){
    //         Arrays.fill(row, -1);
    //     }
        
    //     for(int i=r;i>=0;i--){
    //         int val = min(arr, r, i, dp);
    //         Merit = Math.min(Merit, val);
    //     }
    //     return Merit;

        int Merit = Integer.MAX_VALUE;
        int [][]dp = new int[r+1][c+1];
        for(int []row:dp){
            Arrays.fill(row, -1);
        }
        int val = min(arr, 0, 0, dp);
        Merit = Math.min(val, Merit);
        return Merit;
    }

    // public static int min(int [][]arr, int row, int col, int [][]dp){
    //     if(row == 0 && col ==0){
    //         return arr[row][col];
    //     }

    //     if(col>row || col<0 ||row<0){
    //         return Integer.MAX_VALUE;
    //     }

    //     if(dp[row][col] != -1){
    //         return dp[row][col];
    //     }

    //     int dia = min(arr, row-1, col-1, dp);
    //     int down = min(arr, row-1, col, dp);

    //     int value = arr[row][col] + Math.min(dia, down);

    //     return  value;
    // }

    public static int min(int [][]arr, int row, int col, int [][]dp){
        if(row == arr.length-1 && col<=row){
            return arr[row][col];
        }

        if(col>row){
            return Integer.MAX_VALUE;
        }

        if(dp[row][col] != -1){
            return dp[row][col];
        }

        int dia = min(arr, row+1, col+1, dp);
        int down = min(arr, row+1, col, dp);

        int value = arr[row][col] + Math.min(dia, down);

        return dp[row][col] = value;
    }
}
