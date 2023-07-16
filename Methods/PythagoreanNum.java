package Methods;
import java.util.Scanner;

public class PythagoreanNum {
    public static void main(String [] args){
        Scanner in=new Scanner(System.in);
        System.out.println("Enter three numbers");
        int num1=in.nextInt();
        int num2=in.nextInt();
        int num3=in.nextInt();
        System.out.println(pythogorean(num1,num2,num3));
    }

    static boolean pythogorean(int a, int b, int c){
        if((a*a)==(b*b+c*c)){
            return true;
        }
        else if(b*b==a*a+c*c)
            return true;
        else if(c*c==a*a+b*b)
            return true;
        else
            return false;
    }
}
