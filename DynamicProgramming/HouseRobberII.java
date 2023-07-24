package DynamicProgramming;

import java.util.Arrays;

public class HouseRobberII {
    public static void main(String[] args) {
        int []arr = {1,3,2,1};
        int []dp = new int[arr.length];
        Arrays.fill(dp, Integer.MAX_VALUE);
        int ans = sum(arr, dp, arr.length-1);
        System.out.println(ans);
    }

    public static int sum(int []arr, int []dp,int n){
        //FOR ANSWER EXCLUDING LAST ELEMENT
        int last = exlast(arr, dp, n-1);

        //FOR ANSWER EXCLUDING FIRST ELEMENT
        int first = exfirst(arr, dp ,n);

        if(first>last){
            return first;
        }
        return last;
    }

    public static int exlast(int []arr, int []dp, int l){
        if(l==0){
            return arr[0];
        }

        if(l<0){
            return 0;
        }

        if(dp[l] != Integer.MAX_VALUE){
            return dp[l];
        }

        int pick = arr[l] + exlast(arr, dp, l-2);
        int notpick = 0 + exlast(arr, dp, l-1);

        dp[l] = Math.max(pick, notpick);

        return dp[l];
    }

    public static int exfirst(int []arr, int []dp, int f){
        if(f==1){
            return arr[1];
        }

        if(f<1){
            return 0;
        }

        if(dp[f] != Integer.MAX_VALUE){
            return dp[f];
        }

        int pick = arr[f] + exfirst(arr, dp, f-2);
        int notpick = 0 + exfirst(arr, dp, f-1);

        dp[f] = Math.max(pick, notpick);
        return dp[f];
    }
}
