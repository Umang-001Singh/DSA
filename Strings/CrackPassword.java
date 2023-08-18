package Strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.print.DocFlavor.STRING;

public class CrackPassword {
    public static void main(String[] args) {
        String str = "122334566";
        String[][] dp = new String[str.length()+1][str.length()+1];
        for(String[] row:dp){
            Arrays.fill(row, "");
        }
        String rev = "";
        for(int i = str.length()-1;i>=0;i--){
            rev += str.charAt(i);
        }
        String ans = password(str, rev, dp);
        // String ans = password(str, rev, dp);
        System.out.println(ans);
    }

    public static String password(String text1, String text2, String[][] dp){
        
        for(int f = 0;f<=text1.length();f++){
            dp[f][0] = "";
        }

        for(int s = 0;s<=text2.length();s++){
            dp[0][s] = "";
        }

        // String ans = "";
        int max = 0;
        for(int f = 1;f<=text1.length();f++){
            for(int s = 1;s<=text2.length();s++){
                if(text1.charAt(f-1) == text2.charAt(s-1)){
                    dp[f][s] = text1.charAt(f-1) + dp[f-1][s-1];
                    String temp = dp[f][s];
                    max = Math.max(max, temp.length());
                }
                else{
                    dp[f][s] = "";
                }
            }
        }

        String ans = valid(text1, text2, dp, max);
        // for(String[] row: dp){
        //     System.out.println(Arrays.toString(row));
        // }
        // System.out.println(max);
        return ans;
    }

    public static String valid(String str1, String str2, String[][] dp, int max){
        List<List<String>> list = new ArrayList<>();
        for(int i = 0;i<dp.length;i++){
            List<String> temp = new ArrayList<>();
            for(int j = 0;j<dp[0].length;j++){
                String var = dp[i][j];
                if(var.length() == max){
                    temp.add(var);
                }
            }
            if(temp.size() != 0){
                list.add(temp);
            }
        }

        String ans = "";
        int count = list.size();
        // System.out.println(count);
        ans += Integer.toString(count);
        // System.out.println(ans);
        for(int i = 0;i<list.size();i++){
            ans += " ";
            String str = list.get(i).get(0);
            ans += str;
        }
        // System.out.println(ans);
        return ans;
    }
}
