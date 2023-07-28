package DynamicProgramming;

import java.util.Arrays;

public class PallindromicSubsequence {
    public static void main(String[] args) {
        String text1 = "bbbab";
        String text2 = "";
        for(int i = text1.length()-1;i>=0;i--){
            text2 += text1.charAt(i);
        }
        int [][]dp = new int[text1.length()+1][text2.length()+1];
        for(int []row: dp){
            Arrays.fill(row, -1);
        }
        int ans = longest(text1, text2, text1.length(), text2.length(), dp);
        System.out.println(ans);
    }

    public static int longest(String text1, String text2, int i, int j, int [][]dp){
        if(i == 0 || j ==0){
            return 0; 
        }

        if(dp[i][j] != -1){
            return dp[i][j];
        }

        if(text1.charAt(i-1) == text2.charAt(j-1)){
            return dp[i][j] = 1 + longest(text1, text2, i-1, j-1, dp);
        }

        return dp[i][j] = Math.max(longest(text1, text2, i-1, j, dp), longest(text1, text2, i, j-1, dp));
    }
}
