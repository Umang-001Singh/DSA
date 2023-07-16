package Pattern;

public class Pattern28 {
    public static void main(String[] args) {
        int n=5;
        pattern28(5);

    }

    static void pattern28(int n) {
        for (int row = 1; row <= (2 * n - 1); row++) {
            if (row <= n) {
                int NoofSpaces = n - row;
                for (int s = 1; s <= NoofSpaces; s++) {
                    System.out.print(" ");
                }
                for (int col = 1; col <= row; col++) {
                    System.out.print("*" + " ");
                }
            } else {
                int NoofSpaces = row - n;
                for (int s = 1; s <= NoofSpaces; s++) {
                    System.out.print(" ");
                }
                for (int col = 1; col <= (2 * n - row); col++) {
                    System.out.print("*" + " ");
                }
            }
            System.out.println();
        }
    }
}
