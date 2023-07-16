package MazeAndBacktracking;

import java.util.Arrays;

public class BacktrackingWithPathListed {
    public static void main(String[] args) {
        boolean [][]board = {
            {true, true, true},
            {true, true, true},
            {true, true, true},
        };
        int [][] matrix = new int[board.length][board[0].length];
        Backtracking("", 0, 0, board, matrix , 1);
    }

    static void Backtracking(String p, int r, int c, boolean [][] maze, int[][] matrix,int steps){
        if(r==maze.length-1 && c == maze[0].length-1 ){
            System.out.println(p);
            matrix[r][c] = steps;
            for (int[] arr : matrix) {
                System.out.println(Arrays.toString(arr));
            }
                
            
            
            System.out.println();
            return;
        }

        if(maze[r][c] == false){
            return;
        }

        

        maze[r][c]=false;
        matrix[r][c]=steps;

        if(r>0){
            Backtracking(p + "U", r-1, c, maze,matrix, steps + 1);
        }
        if(c>0){
            Backtracking(p + "L", r, c-1, maze,matrix, steps + 1);
        }
        if(r<maze.length-1){
            Backtracking(p+ "D", r+1, c, maze,matrix, steps + 1);
        }
        if(c<maze[0].length-1){
            Backtracking(p+"R", r, c+1, maze,matrix, steps + 1);
        }

        maze[r][c] = true;
        matrix[r][c] = 0;
        
        
    }
}
