package DynamicProgramming;

import java.util.Arrays;

public class NinjaTraining {
    public static void main(String[] args) {
        int [][]arr = {{10, 40, 70},{20, 50, 80},{30, 60 ,90}};
        int N = 3;
        int [][]dp = new int[arr.length][N+1];
        for(int [] row:dp){
            Arrays.fill(row, -1);
        }
        int ans = merit(arr, 3, 2, dp);
        System.out.println(ans);
    }

    public static int merit(int [][]arr, int last, int n, int [][]dp){
        // MEMOIZATION
        // TC = O(N)
        // SC = O(N) + O(N * 4)
        // if(n==0){
        //     int maxi = 0;
        //     for(int i = 0;i<3;i++){
        //         if(i!=last){
        //             maxi = Math.max(maxi, arr[n][i]);
        //         }
        //     }
        //     return maxi;
        // }

        // if(dp[n][last] != -1){
        //     return dp[n][last];
        // }
        
        // int Merit = 0;
        // for(int i = 0;i<3;i++){
        //     if(i!=last){
        //         int maxi = arr[n][i] + merit(arr, i, n-1, dp);
        //         Merit = Math.max(Merit ,maxi);
        //     }
        // }
        
        // return dp[n][last] = Merit;

    // TABULATION METHOD:-
    // TC = O(N)
    // SC = O(N*4)

    for(int i = 0;i<3;i++){
        dp[0][i] = arr[0][i];
    }

    int Merit = 0;
    for(int i = 1;i<=n;i++){
        for(int j = 0;j<3;j++){
            int maxi = 0;
            for(int z = 0;z<3;z++){
                
                if(j!=z){
                    
                    maxi = Math.max(maxi, arr[i][j] + dp[i-1][z]);
                }
            }
            Merit = Math.max(Merit, maxi);
            dp[i][j] = maxi;
        }
        
    }
    
    // for(int i = 0;i<3;i++){
    //     Merit = Math.max(Merit, arr[n][i]);
    // }
    return Merit;

    // TABULATION + SPACE OPTIMIZATION:-
        

    }

    

}
