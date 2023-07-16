package MazeAndBacktracking;


import java.util.ArrayList;



public class Backtracing {
    public static void main(String[] args) {
        boolean [][]board = {
            {true, true, true},
            {true, true, true},
            {true, true, true},
        };
        ArrayList<String> ans = AllPaths("", 0, 0, board);
        System.out.println(ans);
        
    }

    static ArrayList<String> AllPaths(String p, int r, int c, boolean [][] maze){
        if(r == maze.length-1 && c == maze[0].length-1){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }

        if(maze[r][c]==false){
            ArrayList<String> list = new ArrayList<>();
            return list;
        }

        ArrayList<String> down = new ArrayList<>();
        ArrayList<String> right = new ArrayList<>();
        ArrayList<String> up = new ArrayList<>();
        ArrayList<String> left = new ArrayList<>();

        maze[r][c] = false;
        // ArrayList<String> diagonal = new ArrayList<>();

        if(r>0){
            up = AllPaths(p + "U", r-1, c, maze);
        }
        if(c>0){
            left = AllPaths(p + "L", r, c-1, maze);
        }
        if(r<maze.length-1){
            down = AllPaths(p+ "D", r+1, c, maze);
        }
        if(c<maze[0].length-1){
            right = AllPaths(p+"R", r, c+1, maze);
        }
        maze[r][c]=true;

        down.addAll(right);
        down.addAll(left);
        down.addAll(up);
        
        return down;
    }
}
