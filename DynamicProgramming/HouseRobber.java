package DynamicProgramming;

import java.util.Arrays;

public class HouseRobber {
    public static void main(String[] args) {
        int []arr = {2,1};
        int []dp = new int[arr.length];
        Arrays.fill(dp, Integer.MAX_VALUE);
        int ans = sum(arr, arr.length -1,  dp);
        System.out.println(ans);
    }
    
    public static int sum(int []arr, int n,  int []dp){
        // MEMOIZATION METHOD
        // TIME COMPLEXITY = O(n)
        // SC = O(N) + O(N)
        // if(n == 0){
        //     return arr[0];
        // }

        // if(n<0){
        //     return 0;
        // }

        // if(dp[n] != Integer.MAX_VALUE){
        //     return dp[n]; 
        // }

        // int pick = arr[n] + sum(arr, n-2, dp);
        // int notpick = 0 + sum(arr, n-1, dp);

        // int Sum = 0;
        // Sum =  Math.max(pick, notpick);
        // dp[n] = Sum;

        // return Sum;

        // TABULATION METHOD
        // TC = O(n)
        // SC = O(n)
        // IN THIS METHOD THERE IS NO USE OF n. THE METHOD ARGUMENTS ARE NOT USED SO AS TO USE IN BOTH APPROACHES.
        dp[0] = arr[0];
        int neg = 0; //FOR (n<0) CASE
        int pick = 0;
        int notpick = 0;

        for(int i = 1;i<arr.length;i++){
            pick = arr[i];
            if(i-2>=0){
                pick+=dp[i-2];
            }
            else{
                pick+=neg;
            }
            notpick = 0 + dp[i-1]; //FROM 0 INDEX CANNOT GO TO -1, BECAUSE BASE CONDITION IS MENTIONED TO TACKLE THAT SITUATION
            

            dp[i] = Math.max(notpick, pick);
        }
        return dp[n];

        // TABULATION + SPACE OPTIMIZATION
        
        // int prev = arr[0];
        // int prev2 = 0;
        // for(int i = 1;i<arr.length;i++){
        //     int pick = arr[i];
        //     if(i-2>=0){
        //         pick+=prev;
        //     }
        //     else{
        //         pick+=prev2;
        //     }
        //     int notpick = 0 + prev;

        //     int curi = Math.max(pick, notpick);
        //     prev2 = prev;
        //     prev = curi;
        // }
        // return prev; 
    }
}
