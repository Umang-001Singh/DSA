package DynamicProgramming;

import java.util.Arrays;

public class LongestIncreaingSubSeq {
    public static void main(String[] args) {
        int []arr = {10, 9, 2, 5, 3, 7, 101, 18};
        int [][]dp = new int[arr.length][arr.length+1]; // HOW NEGATIVE INDEXING IS SOLVED IS SHOWN HERE. SECOND PART IS TAKEN ONE EXTRA SIZE. USED LATER
        for(int []row: dp){
            Arrays.fill(row, -1);
        }
        int ans = longest(arr, 0, -1, dp);
        System.out.println(ans);
    }

    public static int longest(int []arr, int i, int prev, int [][]dp){
        if(i>arr.length-1){
            return 0;
        }

        if(dp[i][prev+1] != -1){  // USED HERE. ONE +1 INDEX IS PROVIDED EARLIER AND USED HERE.
            return dp[i][prev+1];
        }

        int pick = 0;
        int notpick = 0;
        if(prev == -1 || arr[prev]<arr[i]){
            pick = 1 + longest(arr, i+1, i, dp);
        }
        
            notpick = 0 + longest(arr, i + 1, prev, dp);
        

        return dp[i][prev+1] = Math.max(pick, notpick);
    }
}
