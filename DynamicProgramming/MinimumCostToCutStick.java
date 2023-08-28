package DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class MinimumCostToCutStick {
    public static void main(String[] args) {
        int n = 7;
        int[] arr = {1, 3, 4, 7};
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0;i<arr.length;i++){
            list.add(arr[i]);
        }
        list.add(0, 0);
        list.add(n);
        Collections.sort(list);
        System.out.println(list);
        int[][] dp = new int[n+1][n+1];
        for(int[] row: dp){
            Arrays.fill(row, -1);
        }
        int ans  = cuts(list, 1, arr.length, dp);
        System.out.println(ans);
    }

    public static int cuts(ArrayList<Integer> list, int i, int j, int[][] dp){
        if(i>j){
            return 0;
        }

        int mini = Integer.MAX_VALUE;

        for(int ind = i;ind<=j;ind++){
            int cost = list.get(j+1) - list.get(i-1) + cuts(list, i, ind - 1, dp) + cuts(list, ind+1, j, dp);
            mini = Math.min(mini, cost);
        }

        return mini;
    }
}
