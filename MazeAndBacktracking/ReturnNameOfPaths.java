package MazeAndBacktracking;

import java.util.ArrayList;

public class ReturnNameOfPaths {
    public static void main(String[] args) {
        // ArrayList<String> ans = Paths("", 3,3);
        ArrayList<String> ans = PathsWithDiagonals("", 3,3);
        System.out.println(ans);

    }

    // static ArrayList<String> Paths(String p, int r, int c){
    //     if(r ==1 && c ==1){
    //         ArrayList<String> list = new ArrayList<>();
    //         list.add(p);
    //         return list;
    //     }

        
    //     ArrayList<String> down = new ArrayList<>();
    //     ArrayList<String> right = new ArrayList<>();
    //     if(r !=1 && c!=1){
    //         down = Paths(p + "D", r-1,c);
    //         right = Paths(p + "R", r, c-1);
    //     }
    //     else if(r !=1 && c==1){
    //         down = Paths(p + "D",r-1, c);
    //     }
    //     else{
    //         right = Paths(p + "R",r,c-1);
    //     }
    //     down.addAll(right);
    //     return down;
    // }


    //IF DIAGONALS ARE ALLOWED

    static ArrayList<String> PathsWithDiagonals(String p, int r, int c){
        if(r ==1 && c ==1){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }

        
        ArrayList<String> down = new ArrayList<>();
        ArrayList<String> right = new ArrayList<>();
        ArrayList<String> diagonal = new ArrayList<>();
        if(r !=1 && c!=1){
            diagonal = PathsWithDiagonals(p+ "d", r-1, c-1);
            down = PathsWithDiagonals(p + "D", r-1,c);
            right = PathsWithDiagonals(p + "R", r, c-1);
        }
        else if(r !=1 && c==1){
            down = PathsWithDiagonals(p + "D",r-1, c);
        }
        else{
            right = PathsWithDiagonals(p + "R",r,c-1);
        }
        down.addAll(right);
        down.addAll(diagonal);
        return down;
    }
}
