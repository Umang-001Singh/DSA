package Methods;
import java.util.Scanner;

public class PrimeNobt2num {
    public static void main(String []args){
        Scanner in=new Scanner(System.in);
        System.out.println("Enter lower limit and upper limit");
        double num1=in.nextInt();
        double num2=in.nextInt();
        prime(num1,num2);
    }
    static void prime(double a, double b){
       while(a<b){
            int count=0;
            for (int j=1;j<=Math.sqrt(a);j++){
                if(a%j==0){
                    count++;
                }
            }
                if(count == 1){
                    System.out.print(a+" ");
                }
                a++;
       }

    }
}
