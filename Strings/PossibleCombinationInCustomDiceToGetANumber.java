package Strings;

import java.util.ArrayList;

public class PossibleCombinationInCustomDiceToGetANumber {
    public static void main(String[] args) {
        ArrayList<String> ans = CustomCombinations("", 9, 7);
        System.out.println(ans);
    }

    static ArrayList<String> CustomCombinations(String p, int target, int faces){
        if(target ==0){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }

        ArrayList<String> ans = new ArrayList<>();
        for (int i = 1; i <= faces && i<= target; i++) {
            ans.addAll(CustomCombinations(p + i, target - i, faces));
        }
        return ans;
    }
}
