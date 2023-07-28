package DynamicProgramming;

import java.util.Arrays;

public class PrintLCS {
    public static void main(String[] args) {
        String text1 = "abcde";
        String text2 = "abc";
        String [][]dp = new String[text1.length()+1][text2.length()+1];
        for(String []row: dp){
            Arrays.fill(row, "");
        }

        String ans = longest(text1, text2, text1.length(), text2.length(), dp);
        String finalans = "";
        for(int i = ans.length()-1;i>=0;i--){
            finalans = finalans + ans.charAt(i);
        }
        System.out.println(finalans);
    }

    public static String longest(String text1, String text2, int i, int j, String [][]dp){
        if(i==0 || j==0){
            return "";
        }

        if(text1.charAt(i-1) == text2.charAt(j-1)){
            return dp[i][j] = text1.charAt(i-1) + longest(text1, text2, i-1, j-1, dp);
        }

        if(dp[i][j] != ""){
            return dp[i][j];
        }

        String first = longest(text1, text2, i-1, j, dp);
        String sec = longest(text1, text2, i, j-1, dp);

        if(first.length()<sec.length()){
            return dp[i][j] = sec;
        }
        
        return dp[i][j] = first;
    }
}

        
