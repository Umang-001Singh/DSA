package DynamicProgramming;

import java.util.Arrays;

public class LongestCommonSubsequence {
    public static void main(String[] args) {
        String text1 = "abc";
        String text2 = "def";
        // int [][]dp = new int[text1.length()][text2.length()];
        
        // FOR 1 RIGHT SHIFTING
        int [][]dp = new int[text1.length()+1][text2.length()+1];
        for(int []row: dp){
            Arrays.fill(row, -1);
        }
        // int ans = longest(text1, text2, text1.length()-1, text2.length()-1, dp);
        
        // FOR 1 RIGHT SHIFTING 
        int ans = longest(text1, text2, text1.length(), text2.length(), dp);
        System.out.println(ans);
    }

    public static int longest(String text1, String text2, int i, int j, int [][]dp){
        // if(i<0 || j<0){
        //     return 0;
        // }

        // if(dp[i][j] != -1){
        //     return dp[i][j];
        // }

        // if(text1.charAt(i) == text2.charAt(j)){
        //     return dp[i][j] = 1 + longest(text1, text2, i-1, j-1, dp);
        // }

        // return dp[i][j] = Math.max(longest(text1, text2, i-1, j, dp), longest(text1, text2, i, j-1, dp));

        // AFTER 1 RIGHT SHIFTING

        // if(i==0 || j==0){
        //     return 0;
        // }

        // if(dp[i][j] != -1){
        //     return dp[i][j];
        // }

        // if(text1.charAt(i-1) == text2.charAt(j-1)){
        //     return dp[i][j] = 1 + longest(text1, text2, i-1, j-1, dp);
        // }

        // return dp[i][j] = Math.max(longest(text1, text2, i-1, j, dp), longest(text1, text2, i, j-1, dp));

        // TABULATION DONE BY USING 1 RIGHT SHIFTING MEMOIZATION CODE

        for(int first = 0;first<=text1.length();first++){
            dp[first][0] = 0;
        }

        for(int sec = 0;sec<=text2.length();sec++){
            dp[0][sec] = 0;
        }

        for(int first = 1;first<=text1.length();first++){
            for(int sec = 1;sec<=text2.length();sec++){
                if(text1.charAt(first-1) == text2.charAt(sec-1)){
                    dp[first][sec] = 1 + dp[first-1][sec-1];
                }
                else{
                dp[first][sec] = Math.max(dp[first-1][sec], dp[first][sec-1]);

                }
            }

            }
        

        return dp[i][j];



    }
}
