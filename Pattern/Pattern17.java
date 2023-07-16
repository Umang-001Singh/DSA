package Pattern;

public class Pattern17 {
    public static void main(String [] args){
        int n=4;
        pattern17(n);

    }

    static void pattern17(int n){
        for(int row=1;row<=2*n-1;row++){
            if (row <= n) {
                int NoofSpaces = n - row;
                for (int s = 1; s <= NoofSpaces; s++) {
                    System.out.print(" ");
                }

                for (int col = row; col >= 1; col--) {
                    System.out.print(col);
                }

                for (int col = 2; col <= row; col++) {
                    System.out.print(col);
                }
            }
            else {
                for (int s = 1; s <= row - n; s++) {
                    System.out.print(" ");

                }

                for (int col = 2 * n - row; col >= 1; col--) {
                    System.out.print(col);
                }

                for (int col = 2; col <= 2 * n - row; col++) {
                    System.out.print(col);
                }
            }
            System.out.println();
        }
    }
}
