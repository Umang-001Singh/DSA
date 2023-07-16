package Arrays;

import java.util.Scanner;

public class SumOfSeries {
    public static void main(String [] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the value of x and n");
        int x=sc.nextInt();
        int n=sc.nextInt();
        int fac=1;
        double sum=0;
        int pow=1;
        while(pow<=n){
            for(int i=1;i<=pow;i++){
                fac=fac*i;
            }
            if(pow%2==0){
                sum=sum-Math.pow(x,pow)/fac;
            }
            else{
                sum=sum+Math.pow(x,pow)/fac;
            }
            pow++;
        }
        System.out.println(sum);
    }
}
