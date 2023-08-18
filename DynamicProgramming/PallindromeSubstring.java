package DynamicProgramming;

import java.util.Arrays;

public class PallindromeSubstring {
    public static void main(String[] args) {
        String text1 = "122333456";
        String text2 = "";
        for(int i = text1.length()-1;i>=0;i--){
            text2+=text1.charAt(i);
        }
        String [][]dp = new String[text1.length()+1][text2.length()+1];
        for(String []row: dp){
            Arrays.fill(row, "");
        }
        String ans = longest(text1, text2, text1.length(), text2.length(), dp);
        System.out.println(ans);
    }

    public static String longest(String text1, String text2, int i, int j, String [][]dp){
        for(int f = 0;f<=text1.length();f++){
            dp[f][0] = "";
        }

        for(int s = 0;s<=text2.length();s++){
            dp[0][s] = "";
        }

        String ans = "";

        for(int f = 1;f<=text1.length();f++){
            for(int s = 1;s<=text2.length();s++){
                if(text1.charAt(f-1) == text2.charAt(s-1)){
                    dp[f][s] = text1.charAt(f-1) + dp[f-1][s-1];
                    
                }
                else{
                    dp[f][s] = "";
                }
            }
        }
        for(int r = 1;r<=dp.length-1;r++){
            for(int c = 1;c<=dp[0].length-1;c++){
                String temp = dp[r][c];
                if(ispallindrome(temp)){
                    if(ans.length()<temp.length()){
                        ans = temp;
                    }
                }
            }

        }
        return ans;
    }

    public static boolean ispallindrome(String text){
        // if(text == ""){
        //     return true;
        // }
        if(text.length()==1){
            return true;
        }
        

        int j = text.length()-1;
        for(int i = 0;i<text.length()/2;i++){
            if(text.charAt(j) != text.charAt(i)){
                return false;
            }
            j--;
        }
        return true;
    }
}
