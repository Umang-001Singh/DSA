package DynamicProgramming;

import java.util.Arrays;

public class LongestCommonSubstring {
    public static void main(String[] args) {
        String text1 = "abb";
        String text2 = "bba";
        int [][]dp = new int[text1.length()+1][text2.length()+1];
        for(int []row: dp){
            Arrays.fill(row, -1);
        }
        int ans = longest(text1, text2, text1.length(), text2.length(), dp);
        System.out.println(ans);
    }

    public static int longest(String text1, String text2, int i, int j, int [][]dp){
        for(int first = 0;first<=text1.length();first++){
            dp[first][0] = 0;
        }

        for(int sec = 0;sec<=text2.length();sec++){
            dp[0][sec] = 0;
        }
        int ans = 0;
        for(int first = 1;first<=text1.length();first++){
            for(int sec = 1; sec<=text2.length();sec++){
                if(text1.charAt(first-1) == text2.charAt(sec-1)){
                    dp[first][sec] = 1 + dp[first-1][sec-1];
                    ans = Math.max(ans, dp[first][sec]);
                }
                else{
                    dp[first][sec] = 0;
                }
            }
        }
        return ans;
    }
}
