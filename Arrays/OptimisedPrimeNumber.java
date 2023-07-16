package Arrays;
import java.util.Scanner;

public class OptimisedPrimeNumber {
public static void main (String [] args){
    Scanner in=new Scanner(System.in);
    System.out.println("Enter a number");
    int a=in.nextInt();
    int c=0;
    for(int i=1;i<=Math.sqrt(a);i++){
        if(a%i==0){
            c++;
        }
    }
    if(c==1){
        System.out.println("Entered number is prime");
    }
    else
        System.out.println("Entered number is composite");


}
}
