package DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;


public class PrintingLongestIncreasingSubSeq {
    public static void main(String[] args) {
        int []arr = {10, 10, 10};
        ArrayList<ArrayList<Integer>> dp = new ArrayList<>();
        // int [][]dp = new int[arr.length][arr.length+1]; // HOW NEGATIVE INDEXING IS SOLVED IS SHOWN HERE. SECOND PART IS TAKEN ONE EXTRA SIZE. USED LATER
        // for(int []row: dp){
        //     Arrays.fill(row, -1);
        // }
        ArrayList<Integer> ans = longest(arr, 0, -1, dp);
        System.out.println((ans));
    }

    public static ArrayList<Integer> longest(int []arr, int i, int prev, ArrayList<ArrayList<Integer>> dp){
        ArrayList<Integer> list = new ArrayList<>();
        if(i>arr.length-1){
            return list;
        }

        if(dp.get(i).get(prev+1) != 0){
            return dp.get(i);
        }

        // if(dp[i][prev+1] != -1){  // USED HERE. ONE +1 INDEX IS PROVIDED EARLIER AND USED HERE.
        //     list.add(dp[i][prev+1]);
        //     return list;
        // }

        // int pick = 0;
        // int notpick = 0;
        if(prev == -1 || arr[prev]<arr[i]){
            list.add(arr[i]);
            ArrayList<Integer> temp = longest(arr, i+1, i, dp);
            list.addAll(temp);
        }
            ArrayList<Integer> temp = new ArrayList<>();
            temp.addAll(longest(arr, i+1, prev, dp));
        
            if(list.size() > temp.size()){
                return list;
            }

        return temp;
    
    }
}
