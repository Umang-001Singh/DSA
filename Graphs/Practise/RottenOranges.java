package Graphs.Practise;

import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {
    public static void main(String[] args) {
        int[][] arr = {{2, 1, 1}, {1, 1, 0}, {0, 1, 1}};
        int ans = oranges(arr);
        System.out.println(ans);
    }

    public static int oranges(int[][] arr){
        Queue<Pair> q = new LinkedList<>();
        int fresh = 0;
        int[][] vis = new int[arr.length][arr.length];
        for(int i = 0;i<arr.length;i++){
            for(int j = 0;j<arr.length;j++){
                if(arr[i][j] == 2){
                    q.add(new Pair(i, j, 0));
                    vis[i][j] = 1;
                }
                else if(arr[i][j] == 1){
                    fresh++;
                }
                else{
                    vis[i][j] = 0;
                }

            }
        }
        int[] drow = {0, 1, 0, -1};
        int[] dcol = {-1, 0, 1, 0};
        int maxTime = 0;
        int count = 0;
        while(!q.isEmpty()){
            Pair temp = q.poll();
            int row = temp.x;
            int col = temp.y;
            int time = temp.time;
            maxTime = Math.max(maxTime, time);
            for(int i = 0;i<drow.length;i++){
                int r = row + drow[i];
                int c = col + dcol[i];
                if(r >=0 && r<arr.length && c>=0 && c<arr.length && arr[r][c] == 1 && vis[r][c] == 0){
                    q.add(new Pair(r, c, time + 1));
                    vis[r][c] = 2;
                    count++;
                }
            }
        }
        if(count != fresh){
            return -1;
        }
        return maxTime;

    }

    static class Pair{
        int x;
        int y;
        int time;
        Pair(int X, int Y, int Time){
            this.x = X;
            this.y = Y;
            this.time = Time;
        }
    }
}
