package Methods;
import java.util.Scanner;

public class Pallindorme {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num1 = in.nextInt();
        System.out.println(pallindrome(num1));
    }

    static boolean pallindrome(int i) {
        int original = i;
        double rem = 0;
        double sum = 0;
        double count = 0;
        while (i > 0) {
            i = i / 10;
            count++;
        }
        count=count-1;
            i=original;
             while(i>0){
                 rem=i%10;
           i=i/10;
          sum=sum+(rem*(Math.pow(10,count)));
          count--;
         }
         if(sum==original)
             return true;
         return false;
         }

    }

