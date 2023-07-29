package DynamicProgramming;

import java.util.Arrays;

public class EditDistance {
    public static void main(String[] args) {
        String text1 = "intention";
        String text2 = "execution";
        int [][]dp = new int[text1.length()+1][text2.length()+1];
        for(int []row: dp){
            Arrays.fill(row, -1);
        }
        int ans = steps(text1, text2, text1.length(), text2.length(), dp);
        System.out.println(ans);
    }

    public static int steps(String str1, String str2, int i, int j, int [][]dp){

        // if(i<0 && j<0){
        //     return 0;
        // } 
        // if(i<0){
        //     return j+1;
        // }
        // if(j<0){
        //     return i+1;
        // }

        // if(dp[i][j] != -1){
        //     return dp[i][j];
        // }

        // if(str1.charAt(i) == str2.charAt(j)){
        //     return dp[i][j] = steps(str1, str2, i-1, j-1, dp);
        // }
        
        //     int rem = steps(str1, str2, i-1, j, dp);
        //     int rep = steps(str1, str2, i-1, j-1, dp);
        //     int ins = steps(str1, str2, i, j-1, dp);

        //     return dp[i][j] = 1 + Math.min(rep, Math.min(rem, ins));

        // SHIFTING 1 INDEX TO RIGHT
        // if(i==0 && j==0){
        //     return 0;
        // } 
        // if(i==0){
        //     return j;
        // }
        // if(j==0){
        //     return i;
        // }

        // if(dp[i][j] != -1){
        //     return dp[i][j];
        // }

        // if(str1.charAt(i-1) == str2.charAt(j-1)){
        //     return dp[i][j] = steps(str1, str2, i-1, j-1, dp);
        // }
        
        //     int rem = steps(str1, str2, i-1, j, dp);
        //     int rep = steps(str1, str2, i-1, j-1, dp);
        //     int ins = steps(str1, str2, i, j-1, dp);

        //     return dp[i][j] = 1 + Math.min(rep, Math.min(rem, ins));
        
        // TABULATION
        dp[0][0] = 0;
        for(int row = 1;row<=i;row++){
            dp[row][0] = row; 
        }

        for(int col = 1;col<=j;col++){
            dp[0][col] = col;
        }

        for(int row=1;row<=i;row++){
            for(int col = 1;col<=j;col++){
                if(str1.charAt(row-1) == str2.charAt(col-1)){
                    dp[row][col] = dp[row-1][col-1];
                }
                else{
                    int rem = dp[row-1][col];
                    int rep = dp[row-1][col-1];
                    int ins = dp[row][col-1];

                    dp[row][col] = 1 + Math.min(rep, Math.min(rem, ins));
                }
                
            
            }
        }
        return dp[i][j];
    }
}
