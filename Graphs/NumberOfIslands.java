package Graphs;

import java.util.ArrayList;

public class NumberOfIslands {
    public static void main(String[] args) {
        // char [][]grid = {{'1', '1', '0', '1', '1'},
        //                 {'1', '0', '0', '0', '0'},
        //                 {'0', '0', '0', '0', '1'},
        //                 {'1', '1', '0', '1', '1'}};
        char [][]grid = {{'0', '1'},
                        {'1', '0'},
                        {'1', '1'},
                        {'1', '0'}};
        int ans = number(grid);
        System.out.println(ans);
    }

    public static int number(char [][]grid){
        int [][]vis = new int[grid.length][grid[0].length];
        ArrayList<ArrayList<String>> ans = new ArrayList<>();
        for(int i = 0;i<grid.length;i++){
            for(int j = 0;j<grid[0].length;j++){
                if(vis[i][j] == 0 && grid[i][j] == '1'){
                    ArrayList<String> list = new ArrayList<>();
                    islands(grid, vis, i, j, list);
                    ans.add(list);
                }
            }
        }
        return ans.size();
    }

    public static void islands(char [][]grid, int [][]vis, int row, int col, ArrayList<String> list){
        String r = Integer.toString(row);
        String c = Integer.toString(col);

        list.add(r + " " + c);
        vis[row][col] = 1;

        int []drow = {0, 1, 0, -1, -1, 1, -1, 1};
        int []dcol = {1, 0, -1, 0, 1, 1, -1, -1};

        for(int i = 0;i<8;i++){
            int nrow = row + drow[i];
            int ncol = col + dcol[i];
            if(nrow>=0 && nrow<grid.length && ncol>=0 && ncol<grid[0].length && vis[nrow][ncol] == 0 && grid[nrow][ncol] == '1'){
                islands(grid, vis, nrow, ncol, list);
            }
        }
    }
}
