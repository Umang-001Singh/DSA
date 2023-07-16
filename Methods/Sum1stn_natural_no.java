package Methods;

import java.util.Scanner;

public class Sum1stn_natural_no {
    public static void main (String [] args){
        System.out.println("Enter n");
        Scanner in=new Scanner (System.in);
        int num=in.nextInt();
        sum(num);
    }
    static void sum(int a){
        int sum=0;
        for (int i=0;i<=a;i++){
            sum=sum+i;
        }
        System.out.println("Sum ="+sum);
    }
}
