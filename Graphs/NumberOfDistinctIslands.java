package Graphs;

import java.util.ArrayList;
import java.util.HashSet;

public class NumberOfDistinctIslands {
    public static void main(String[] args) {
        
    }

    public static int number(int [][]grid){
        int [][]vis = new int[grid.length][grid[0].length];
        HashSet<ArrayList<String>> ans = new HashSet<>();
        for(int i = 0;i<grid.length;i++){
            for(int j = 0;j<grid[0].length;j++){
                if(vis[i][j] == 0 && grid[i][j] == 1){
                    ArrayList<String> list = new ArrayList<>();
                    islands(grid, vis, i, j, 0, 0, list);
                    ans.add(list);
                }
            }
        }
        return ans.size();
    }

    public static void islands(int [][]grid, int [][]vis, int row, int col, int row0, int col0, ArrayList<String> list){
        int frow = row - row0;
        int fcol = col - col0;
        String r = Integer.toString(frow);
        String c = Integer.toString(fcol);
        list.add(r + " " + c);

        vis[row][col] = 1;

        int []drow = {0, 1, 0, -1};
        int []dcol = {1, 0, -1, 0};

        for(int i = 0;i<4;i++){
            int newr = row + drow[i];
            int newc = col + dcol[i];
            if(newr>=0 && newr<grid.length && newc>=0 && newc<grid[0].length && vis[newr][newc] == 0 && grid[newr][newc] == 1){
                islands(grid, vis, newr, newc, row, col, list);
            }
        }
    }
}
