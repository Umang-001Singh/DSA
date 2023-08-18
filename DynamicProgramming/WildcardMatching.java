package DynamicProgramming;

import java.util.Arrays;

public class WildcardMatching {
    public static void main(String[] args) {
        String text1 = "*";
        String text2 = "aa";
        int [][]dp = new int[text1.length()+1][text2.length()+1];
        for(int []row: dp){
            Arrays.fill(row, -1);
        }
        int ans = wildcard(text1, text2, text1.length(), text2.length(), dp);
        System.out.println(ans);
    }

    public static int wildcard(String str1, String str2, int i, int j, int [][]dp){
        // WITH INDEXING 1
        // if(i==0 && j==0){
        //     return 1;
        // }

        // if(i==0 && j>0){
        //     return 0;
        // }

        // if(j==0 && i>0){
        //     for(int k = 1;k<=i;k++){
        //         if(str1.charAt(k-1) != '*'){
        //             return 0;
        //         }
        //     }
        //     return 1;
        // }

        // if(dp[i][j] != -1){
        //     return dp[i][j];
        // }

        // if((str1.charAt(i-1) == str2.charAt(j-1)) || str1.charAt(i-1) == '?'){
        //     return dp[i][j] = wildcard(str1, str2, i-1, j-1, dp);
        // }

        // if(str1.charAt(i-1) == '*'){
        //     return dp[i][j] = wildcard(str1, str2, i-1, j, dp) | wildcard(str1, str2, i, j-1, dp);
        // }

        // return dp[i][j] = 0;

        // WITH INDEXING 0

        // if(i<0 && j<0){
        //     return 1;
        // }

        // if(i<0 && j>=0){
        //     return 0;
        // }

        // if(j<0 && i>=0){
        //     for(int k = 0;k<=i;k++){
        //         if(str1.charAt(k) != '*'){
        //             return 0;
        //         }
        //     }
        //     return 1;
        // }

        // if(dp[i][j] != -1){
        //     return dp[i][j];
        // }

        // if((str1.charAt(i) == str2.charAt(j)) || str1.charAt(i) == '?'){
        //     return dp[i][j] = wildcard(str1, str2, i-1, j-1, dp);
        // }

        // if(str1.charAt(i) == '*'){
        //     return dp[i][j] = wildcard(str1, str2, i-1, j, dp) | wildcard(str1, str2, i, j-1, dp);
        // }

        // return dp[i][j] = 0;

        // TABULATION

        dp[0][0] = 1;

		for(int col = 1;col<=str2.length();col++){
			dp[0][col] = 0;
		}

		for(int row = 1;row<=str1.length();row++){
			int flag = 1;
			for(int k = 1;k<=row;k++){
                if(str1.charAt(k-1) != '*'){
                    flag = 0;
					break;
                }
			}
			dp[row][0] = flag;
		}

		for(int row = 1;row<=str1.length();row++){
			for(int col = 1;col<=str2.length();col++){
				if( str1.charAt(row-1) == str2.charAt(col-1) || str1.charAt(row-1) == '?'){
					dp[row][col] = dp[row-1][col-1];
				}
				
				else if(str1.charAt(row-1) == '*'){
					dp[row][col] = dp[row-1][col] | dp[row][col-1];
				}
				else{
					dp[row][col] = 0;
				}
			}
		}
		return dp[i][j];
    }
}
