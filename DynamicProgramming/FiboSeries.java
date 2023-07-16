package DynamicProgramming;

import java.util.Arrays;

public class FiboSeries {
    public static void main(String[] args) {
        int n = 8;
        int []arr = new int[n+1];
        Arrays.fill(arr, -1); 
        System.out.println(fibo(arr, n));
    }

    public static int fibo(int []dp, int n){
    // METHOD 1:- USING MEMOIZATION
    //     if(n<=1){
    //         return n;
    //     }

    //     if(dp[n] != -1){
    //         return dp[n];
    //     }

    //     return dp[n] = fibo(dp, n-1) + fibo(dp, n-2);
    // } 

    // METHOD 2:- USING TABULATION
    // dp[0] = 0;
    // dp[1] = 1;
    // for(int i = 2;i<=n;i++){
    //     dp[i]= dp[i-1] + dp[i-2];
    // }
    // return dp[n];

    // SPACE OPTIMIZATION IN METHOD 2:-
    int prev = 1;
    int prev2 = 0;
    for(int i = 2;i<=n;i++){
        int curi = prev + prev2;
        prev2 = prev;
        prev = curi;
    }
    return prev;
}
}