package DynamicProgramming;

import java.util.Arrays;

public class ShortestCommonSuperSequence {
    public static void main(String[] args) {
        String s1 = "brute";
        String s2 = "groot";
        int [][]dp = new int[s1.length()+1][s2.length()+1];
        for(int []row:dp){
            Arrays.fill(row, -1);
        }
        String ans = lcs(s1, s2, s1.length(), s2.length(), dp);
        System.out.println(ans);
    }

    public static String lcs(String s1, String s2, int i, int j, int [][]dp){
        for(int r = 0;r<=s1.length();r++){
            dp[r][0] = 0;
        }

        for(int c = 0;c<=s2.length();c++){
            dp[0][c] = 0;
        }

        for(int r = 1;r<=s1.length();r++){
            for(int c = 1;c<=s2.length();c++){
                if(s1.charAt(r-1) == s2.charAt(c-1)){
                    dp[r][c] = 1 + dp[r-1][c-1];
                }
                else{
                    dp[r][c] = Math.max(dp[r-1][c], dp[r][c-1]);
                }
            }
        }

        String temp = superseq(s1, s2, s1.length(), s2.length(), dp);
        String ans = "";
        for(int len = temp.length()-1;len>=0;len--){
            ans += temp.charAt(len);
        }        
        return ans;
    }

    public static String superseq(String s1, String s2, int i, int j, int [][]dp){
        String ans = "";
        while(i>0 && j>0){
            if(s1.charAt(i-1) == s2.charAt(j-1)){
                ans += s1.charAt(i-1);
                i--;
                j--;
            }
            else if(dp[i-1][j] > dp[i][j-1]){
                ans += s1.charAt(i-1);
                i--;
            }
            else{
                ans += s2.charAt(j-1);
                j--;
            }
        }

        while(i>0){
            ans += s1.charAt(i-1);
            i--;
        }

        while(j>0){
            ans += s2.charAt(j-1);
            j--;
        }

        return ans;
    }
}
