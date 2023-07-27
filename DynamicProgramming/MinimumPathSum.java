package DynamicProgramming;

import java.util.Arrays;

public class MinimumPathSum {
    public static void main(String[] args) {
        int [][]grid = {{1,3,1},
                        {1,5,1},
                        {4,2,1}};

                        // [[0,2,2,6,4,1,6,2,9,9,5,8,4,4],
                        // [0,3,6,4,5,5,9,7,8,3,9,9,5,4],
                        // [6,9,0,7,2,2,5,6,3,1,0,4,2,5],
                        // [3,8,2,3,2,8,8,7,5,9,6,3,4,5],
                        // [4,0,1,3,9,2,0,1,6,7,9,2,8,9],
                        // [6,2,7,9,0,9,5,2,7,5,1,4,4,7],
                        // [9,8,3,3,0,6,8,0,8,8,3,5,7,3],
                        // [7,7,4,5,9,1,5,0,2,2,2,1,7,4],
                        // [5,1,3,4,1,6,0,4,3,8,4,3,9,9],
                        // [0,6,4,9,4,1,5,5,4,2,5,7,4,0],
                        // [0,1,6,6,4,9,2,7,8,2,1,3,3,7],
                        // [8,4,9,9,2,3,8,6,6,5,4,1,7,9]]

        int row = grid.length;
        int col = grid[0].length;
        int [][]dp = new int[row][col];
        for(int []r: dp){
            Arrays.fill(r, -1);
        }
        int ans = minPath(grid, row-1, col-1, dp);
        System.out.println(ans);
    }

    public static int minPath(int [][]arr, int row, int col, int [][]dp){
        // MEMOIZATION METHOD
        // if(row == 0 && col == 0){
        //     return arr[row][col];
        // }

        // if(row<0 || col<0){
        //     return Integer.MAX_VALUE;
        // }

        // if(dp[row][col] != -1){
        //     return dp[row][col];
        // }

        // int down = minPath(arr, row-1, col, dp);
        // int right = minPath(arr, row, col-1, dp);

        // int value = arr[row][col] + Math.min(down, right);
        
            
        
        
        // return dp[row][col] = value;

        // TABULATION METHOD
        
        // for(int i = 0;i<=row;i++){
        //     int down = 0;
        //     int right = 0;
        //     for(int j = 0;j<=col;j++){
        //         if(i==0 && j ==0 ){
        //             dp[0][0] = arr[0][0];
        //         }
        //         else{
        //             if(i>0){
        //                 down = dp[i-1][j];
        //             }
        //             else{
        //                 down = Integer.MAX_VALUE;
        //             }
        //             if(j>0){
        //                 right = dp[i][j-1];
        //             }
        //             else{
        //                 right = Integer.MAX_VALUE;
        //             }
        //         }
        //         dp[i][j] = arr[i][j] + Math.min(right, down);

        //     }
        // }
        // return dp[row][col];

        // SPACE OPTIMIZATION

        int []temp = new int[col+1];
        for(int i=0;i<=row;i++){
            int []pres = new int[col+1];
            int down = 0;
            int right = 0;
            for(int j = 0;j<=col;j++){
                if(i==0 && j ==0 ){
                    dp[0][0] = arr[0][0];
                }
                else{
                    if(i>0){
                        down = temp[j];
                    }
                    else{
                        down = Integer.MAX_VALUE;
                    }

                    if(j>0){
                        right = pres[j-1];
                    }
                    else{
                        right = Integer.MAX_VALUE;
                    }
                }
                pres[j] = arr[i][j] + Math.min(down, right);
                
            }
            temp = pres;
        }
        return temp[col];
    }
}
