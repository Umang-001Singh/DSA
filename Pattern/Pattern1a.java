package Pattern;

public class Pattern1a {
    public static void main(String[] args) {
        {

            for (int i = 1; i <= 5; i++) {
                  int a=5;
                for (int j = 1; j <= 5 - i; j++)
                {
                    System.out.print("x");
                }
                for (int k = 1; k <= i; k++)
                {

                    System.out.print(a);
                    a--;
                }
                System.out.println();
            }
        }
    }
}