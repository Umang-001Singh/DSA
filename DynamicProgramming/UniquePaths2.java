package DynamicProgramming;

import java.util.Arrays;

public class UniquePaths2 {
    public static void main(String[] args) {
        int [][]grid = {{1}};
        int row = grid.length;
        int col = grid[0].length;
        int [][]dp = new int[row][col];
        for(int []r: dp){
            Arrays.fill(r, -1);
        }
        int ans = paths(grid, row-1, col-1, dp);
        System.out.println(ans);
    }

    public static int paths(int [][]arr, int row, int col, int [][]dp){
        // MEZOIZATION METHOD
        if(row == 0 && col == 0){
            if(arr[row][col] == 1){
                return 0;
            }
            return 1;
        }

        if(row <0 || col<0){
            return 0;
        }

        if(arr[row][col] == 1){
            return 0;
        }
        
        

        if(dp[row][col] != -1){
            return dp[row][col];
        }

        int down = paths(arr, row-1, col,dp);
        int right = paths(arr, row, col-1,dp);

        return dp[row][col] = down + right;
    }
}
