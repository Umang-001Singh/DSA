package Strings;

import java.util.ArrayList;

public class PossibleCombinationsInDiceToGetANumber {
    public static void main(String[] args) {
        ArrayList<String> ans = Combinations("", 7 );
        System.out.println(ans);
    }

    static ArrayList<String> Combinations(String p, int up){
        if(up == 0){
        ArrayList<String> list = new ArrayList<>();
        list.add(p);
        return list;
        }
        
        ArrayList<String> ans = new ArrayList<>();
        int target = up;
        for (int i = 1; i <= target && i<= 6; i++) {
            ans.addAll(Combinations(p + i, target -i ));
        }
        return ans;
    }
}
