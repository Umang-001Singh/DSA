package MazeAndBacktracking;

public class NKnights {
    public static void main(String[] args) {
        int n = 4;
        boolean [][] board = new boolean[n][n];
        knights(0, 0, board, n);
    }

    static void knights(int r, int col, boolean [][] board, int target){
        if(target == 0){
            display(board);
            System.out.println();
            return;
        }

        if(r==board.length-1 && col==board.length){
            return;                       //WHEN r BECOMES GREATER THAN n-1 THEN THE return WILL BE ACTIVATED AND THE POINTER GOES TO SECOND CONDITION
        }                                                                                                                             

        if(col== board[0].length  ) {     //PUTTING THIS CONDITON HERE, AS THIS INCREASES THE r IF col IS GREATER THAN board.length-1
            knights(r+1, 0, board, target);             //SECOND CONDITION, POINTER ARRIVES HERE
            return;                                            // TO PREVENT FURTHUR OPERATION, return  IS PLACED HERE
        }
        if(isSafe(board,r, col)){           
            board[r][col] = true;
            knights(r, col + 1, board, target-1);
            board[r][col] = false;
        }
        knights(r, col + 1, board, target);
        
    }

    private static boolean isSafe(boolean[][] board,int r, int col) {
        if(isValid(board, r-2, col-1)){
            if(board[r-2][col-1]){
                return false;
            }
        }
        
        if(isValid(board, r-2, col+1)){
            if(board[r-2][col+1]){
                return false;
            }
        }

        if(isValid(board, r-1, col-2)){
            if(board[r-1][col-2]){
                return false;
            }
        }

        if(isValid(board, r-1, col+2)){
            if(board[r-1][col+2]){
                return false;
            }
        }
        return true;
    }

    private static boolean isValid(boolean[][] board, int r, int col) {
        if(r<board.length && r>=0 && col<board[0].length && col>=0){
            return true;
        }
        return false;
    }

    private static void display(boolean[][] board) {
        for (boolean[] arr : board) {
            for (boolean element : arr) {
                if(element == true){
                    System.out.print("K");
                }
                else{
                    System.out.print("X");
                }
            }
            System.out.println();
            
        }
        
    }
}
