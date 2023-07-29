package DynamicProgramming;

import java.util.Arrays;

public class DistinctSubSeq {
    public static void main(String[] args) {
        String text1 = "babgbag";
        String text2 = "bag";
        int [][]dp = new int[text1.length()+11][text2.length()+1];
        for(int []row: dp){
            Arrays.fill(row, -1);
        }
        int ans = distinct(text1, text2, text1.length(), text2.length(), dp);
        System.out.println(ans);
    }

    public static int distinct(String str1, String str2, int i, int j, int [][]dp){
        // if(j<0 || (j<0 && i<0)){
        //     return 1;
        // }
        
        // if(i<0){
        //     return 0;
        // }

        

        // if(dp[i][j] != -1){
        //     return dp[i][j];
        // }

        // if(str1.charAt(i) == str2.charAt(j)){
        //     return dp[i][j] = distinct(str1, str2, i-1, j-1, dp) + distinct(str1, str2, i-1, j, dp);
        // }
        
        // return dp[i][j] = distinct(str1, str2, i-1, j, dp);

        // SHIFT 1 INDEX RIGHT

        // if(j==0 || (j==0 && i==0)){
        //     return 1;
        // }
        
        // if(i==0){
        //     return 0;
        // }

        

        // if(dp[i][j] != -1){
        //     return dp[i][j];
        // }

        // if(str1.charAt(i-1) == str2.charAt(j-1)){
        //     return dp[i][j] = distinct(str1, str2, i-1, j-1, dp) + distinct(str1, str2, i-1, j, dp);
        // }
        
        // return dp[i][j] = distinct(str1, str2, i-1, j, dp);


        // TABULATION
        dp[0][0] = 1;
        for(int row = 1;row<=i;row++){
            dp[row][0] = 1;
        }

        for(int col = 1;col<=j;col++){
            dp[0][col] = 0;
        }

        for(int row = 1;row<=i;row++){
            for(int col = 1;col<=j;col++){
                if(str1.charAt(row-1) == str2.charAt(col-1)){
                    dp[row][col] = dp[row-1][col-1] + dp[row-1][col];
                }
                else{
                dp[row][col] = dp[row-1][col];

                }
                
            }
        }

        return dp[i][j];
    }
}
