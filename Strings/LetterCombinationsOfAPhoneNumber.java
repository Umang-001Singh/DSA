package Strings;

import java.util.ArrayList;

public class LetterCombinationsOfAPhoneNumber {
    public static void main(String[] args) {
        // Combinations("", "234");
        ArrayList<String> ans = new ArrayList<>();
        ans = CombinationList("", "123");
        System.out.println(ans);
    }

    // static void Combinations(String p, String up){
    //     if(up.isEmpty()){
    //         System.out.println(p);
    //         return;
    //     }

        // int s=0;
        // int e=0;
        // int digit = up.charAt(0) - '0'; //WILL CONVERT CHARACTER '2' TO INTEGER VALUE
        // if(digit == 1)
        // {

        // }
        // else if(digit == 7)
        // {
        //     s= (digit -2)*3;
        //     e=(digit -1)*3;
        // }
        // else if(digit == 8){
        //     s = (digit -2)*3 +1;
        //     e = (digit -1)*3;
        // }
        // else if (digit == 9){
        //     s = (digit -2)*3 +1;
        //     e = (digit -1)*3 +1;
        // }
        // else{
        //     s=(digit -2)*3;
        //     e = (digit -1)*3-1;
        // }

    //     for (int i = s; i <= e; i++) {
        // if(e != 0)
        // {
        // char ch = (char)('a' + i);
        // ans.addAll(Combinations(p + ch, up.substring(1)));
        // }
        // else{
        //     ans.addAll(Combinations(p, up.substring(1)));
        // }
            
    //     }
    // }

    //WITH RETURN TYPE AS ARRAYLIST

    static ArrayList<String> CombinationList(String p, String up){
        if(up.isEmpty()){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        int s=0;
        int e=0;
        int digit = up.charAt(0) - '0'; //WILL CONVERT CHARACTER '2' TO INTEGER VALUE
        if(digit == 1)
        {

        }
        else if(digit == 7)
        {
            s= (digit -2)*3;
            e=(digit -1)*3;
        }
        else if(digit == 8){
            s = (digit -2)*3 +1;
            e = (digit -1)*3;
        }
        else if (digit == 9){
            s = (digit -2)*3 +1;
            e = (digit -1)*3 +1;
        }
        else{
            s=(digit -2)*3;
            e = (digit -1)*3-1;
        }

        ArrayList<String> ans = new ArrayList<>();
        for (int i = s; i <= e; i++) {
            if(e != 0)
            {
            char ch = (char)('a' + i);
            ans.addAll(CombinationList(p + ch, up.substring(1)));
            }
            else{
                ans.addAll(CombinationList(p, up.substring(1)));
            }
        }
        return ans;

    } 
}
