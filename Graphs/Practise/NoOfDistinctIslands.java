package Graphs.Practise;

import java.util.ArrayList;
import java.util.HashSet;

public class NoOfDistinctIslands {
    public static void main(String[] args) {
        int[][] grid = {{1, 1, 0, 1, 1}, {1, 0, 0, 0, 0}, {0, 0, 0, 0, 1}, {1, 1, 0, 1, 1}};
        int[][] vis = new int[grid.length][grid[0].length];
        HashSet<ArrayList<String>> ans = new HashSet<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(vis[i][j] == 0 && grid[i][j] == 1){
                    ArrayList<String> list = new ArrayList<>();
                    number(grid, vis, i, j, i, j, list);
                    ans.add(list);
                }
            }
        }
        System.out.println(ans.size());
    }

    public static void number(int[][] grid, int[][] vis, int row, int col, int row0, int col0, ArrayList<String> list){
        int newr = row - row0;
        int newc = col - col0;
        String r = Integer.toString(newr);
        String c = Integer.toString(newc);
        list.add(r + " " + c);

        vis[row][col] = 1;
        int[] drow = {0, 1, 0, -1};
        int[] dcol = {1, 0, -1, 0};
        for(int i = 0;i<dcol.length;i++){
            int nr = row + drow[i];
            int nc = col + dcol[i];
            if(nr >= 0 && nr < grid.length && nc >= 0 && nc < grid[0].length && vis[nr][nc] == 0 && grid[nr][nc] == 1){
                number(grid, vis, nr, nc, row, col, list);
            }
        }
    }
}
