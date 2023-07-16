package Methods;
import java.util.Scanner;

public class PrimeNo {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        System.out.println(isPrime(num));
    }

    static boolean isPrime(int n) {
        int factor = 0;
        for (int i = 1; i <= n / 2; i++) {//Condition can be changed to Math.sqrt(n) for better time complexity
            if (n % i == 0) {
                factor++;
            }
        }
        if (factor == 1) {
            return true;//If return is encounterd the statement is exucuted and the program is ended.
        }
            return false;

    }
}

