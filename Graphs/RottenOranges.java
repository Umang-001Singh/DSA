package Graphs;

import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {
    public static void main(String[] args) {
        
    }

    public static int rotten(int [][]grid, int [][]vis){
        Queue<Pair> q = new LinkedList<>();
        int freshOranges = 0;
        int time = 0;
        for(int i = 0;i<grid.length;i++){
            for(int j = 0;j<grid[0].length;j++){
                if(grid[i][j] == 2){
                    q.add(new Pair(i, j, 0));
                    vis[i][j] = 2;
                }
                else{
                    vis[i][j] = 0;
                }
                if(grid[i][j] == 1){
                    freshOranges++;
                }
            }
        }

        int []drow = {-1, 0, 1, 0};
        int []dcol = {0, 1, 0, -1};
        int count = 0;

        while(!q.isEmpty()){
            int row = q.peek().row;
            int col = q.peek().col;
            int t = q.peek().tm;
            q.remove();
            time = Math.max(t,time);

            for(int i = 0;i<4;i++){
                int r = row + drow[i];
                int c = col + dcol[i];
                if(r<grid.length && r>=0 && c<grid[0].length && c>=0 && vis[r][c] == 0 && grid[r][c] == 1){
                    vis[r][c] = 2;
                    q.add(new Pair(r, c, time+1));
                    count++;
                }
            }

        }
        if(count != freshOranges){
            return -1;
        }
        return time;
    }

    static class Pair{
        int row; 
        int col;
        int tm;
        Pair(int row, int col, int tm){
            this.row = row;
            this.col = col;
            this.tm =tm;
        }
    }
}
