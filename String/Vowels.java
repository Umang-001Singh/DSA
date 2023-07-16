package String;

import java.sql.SQLOutput;
import java.util.Scanner;
import java.io.*;

public class Vowels {
    public static void main(String [] args){
        double cost= 0.0, discount= 0.0, amount_payable = 0.0;
        System.out.println("Enter the cost");
        Scanner sc = new Scanner(System.in);
        cost=sc.nextDouble();
        if(cost==20000 && cost<=30000){
            System.out.println("Discount is 10%");
            discount = 0.10*cost;
        }
        else if(cost>30000 && cost<=40000){
            System.out.println("Discount is 15%");
            discount = 0.15*cost;
        }
        else{
            System.out.println("Discount is 25%");
            discount = 0.25* cost;
        }
        amount_payable=cost - discount;
        System.out.println("Amount is:"+ amount_payable);
    }
}
