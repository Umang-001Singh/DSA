package Methods;

import java.util.Scanner;

public class SumTwoNumbers {
    public static void main(String[] args) {
    for(int i=1;i<=2;i++)
        sum();
        int ans=sum2();
        System.out.println(ans);
        int ans1= sum3(1,10);
        System.out.println(ans1);
    }

    public static int sum3(int a, int b) {
        int sum=a+b;
        return sum;

    }

    public static void sum(){
        Scanner in=new Scanner(System.in);

        System.out.println("Enter number 1:");
        int num1= in.nextInt();
        System.out.println("Enter number 2:");
        int num2 =in.nextInt();
        int sum=num2+num1;
        System.out.println("The sum ="+sum);


    }
    public static int sum2(){
        Scanner in=new Scanner(System.in);

        System.out.println("Enter number 1:");
        int num1= in.nextInt();
        System.out.println("Enter number 2:");
        int num2 =in.nextInt();
        int sum=num2+num1;
        return sum;

    }
}
