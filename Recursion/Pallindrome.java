package Recursion;

public class Pallindrome {
    public static void main(String[] args) {
        int n=11;
       int ans= reverse2(n);
        pallindrome(n, ans);

    }

    private static void pallindrome(int n, int ans) {
        if(n==ans) {
            System.out.println("True");
        }
        else{
            System.out.println("False");
        }
    }

       /* static int sum=0;
    static void reverse(int n){

        if(n==0){
            return ;
        }
        int rem=n%10;
        n=n/10;
        sum = sum*10+rem;
        reverse(n);
    } */

    static int reverse2(int n){
        int digit=(int)(Math.log10(n))+1;
        return helper(n, digit);
    }

    private static int helper(int n, int digit) {
        if(n%10==n){
            return n;
        }
        int rem=n%10;
        return rem*(int)(Math.pow(10,digit-1))+ helper(n/10, digit-1);
    }
}
