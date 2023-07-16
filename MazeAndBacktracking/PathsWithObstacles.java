package MazeAndBacktracking;

import java.util.ArrayList;

public class PathsWithObstacles {
    public static void main(String[] args) {
        ArrayList<String> ans = Paths("", 3,3);
        System.out.println(ans);
        boolean [][]board = {
            {true, true, true},
            {true, false, true},
            {true, true, true},
        };
        ArrayList<String> ans1 = PathRestrictions("",0,0,board);
        System.out.println(ans1);
    }

    //TAKING INDEX FROM 0 TO ARRAY LENGTH
    static ArrayList<String> Paths(String p, int r, int c){
        if(r ==1 && c==1){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }

        if(r ==2 && c ==2){
            ArrayList<String> list = new ArrayList<>();
            return list;
        }

        ArrayList<String> down = new ArrayList<>();
        ArrayList<String> right = new ArrayList<>();
        ArrayList<String> diagonal = new ArrayList<>();
        if(r !=1 && c!=1){
            diagonal = Paths(p+ "d", r-1, c-1);
            down = Paths(p + "D", r-1,c);
            right = Paths(p + "R", r, c-1);
        }
        else if(r !=1 && c==1){
            down = Paths(p + "D",r-1, c);
        }
        else{
            right = Paths(p + "R",r,c-1);
        }
        down.addAll(right);
        down.addAll(diagonal);
        return down;
    }

    //USING BOOLEAN VALUE FALSE WHICH DEPICTS OBSTACLE

    static ArrayList<String> PathRestrictions(String p, int r, int c, boolean [][]maze){
        if(r== maze.length-1 && c == maze[0].length-1){
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
        ArrayList<String> diagonal = new ArrayList<>();
        if(r !=maze.length-1 && c!=maze[0].length-1){
            diagonal = PathRestrictions(p+ "d", r+1, c+1, maze);
            down = PathRestrictions(p + "D", r+1,c,maze);
            right = PathRestrictions(p + "R", r, c+1,maze);
        }
        else if(r !=maze.length-1 && c==maze[0].length-1){
            down = PathRestrictions(p + "D",r+1, c,maze);
        }
        else{
            right = PathRestrictions(p + "R",r,c+1,maze);
        }
        down.addAll(right);
        down.addAll(diagonal);
        return down;
    }
}
