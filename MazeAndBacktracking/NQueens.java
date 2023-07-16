package MazeAndBacktracking;

public class NQueens {
    public static void main(String[] args) {
        int n = 4;
        boolean [][] board = new boolean[n][n];
        int count = queens(0, board);
        System.out.println(count);
    }

    static int queens(int r, boolean [][] board){
        if(r>board.length-1){
            display(board);
            System.out.println();
            return 1; 
        }

        int count = 0;
        //STARTING TO CHECK THE VALIDITY OF POSITION WITH COL =0 AND ROW = r + 1
        for(int col = 0; col < board.length; col++){
            if(isSafe(r, col, board)){                                  
                board[r][col] = true;
                count = count + queens(r+1,board);
                board[r][col]=false;
            }
            
        }
        return count;
        
    }

    private static boolean isSafe(int r, int col, boolean[][] board) {
        //CHECK FOR SAFETY IN VETICAL DIRECTION
        for(int i=0;i<r;i++){
            if(board[i][col]){
                return false;
            }
        }

        //CHECK FOR SAFETY IN LEFT DIRECTION
        int p = Math.min(r, col);
        for (int i = 0; i <= p; i++) {
            if(board[r-i][col-i]){
                return false;
            }
            
        }

        //CHECK FOR SAFETY IN RIGHT DIRECTION
        int  q= Math.min(r, board.length - col -1);
        for (int i = 0; i <= q; i++) {
            if(board[r-i][col+i]){
                return false;
            }
        }

        return true;
    }

    private static void display(boolean[][] board) {
        for (boolean[] arr : board) { //FOR EACH ROW OF MATRIX board HAVING DATA TYPE boolean 
            for (boolean element : arr) { //FOR EACH ELEMENT OF 1-D ARRAY arr HAVING DATA TYPE boolean
                if(element == true){
                    System.out.print("Q");
                }
                else{
                    System.out.print("X");
                }
            }
            System.out.println();
        }
        
    }

}
