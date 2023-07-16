package Recursion;

public class SumDigits {
    public static void main(String[] args) {
        System.out.println(prod(1342));
    }

   static int sumdigits(int n){
        if(n==0){
            return 0;
        }
        int rem=n%10;
        n=n/10;
        return rem+sumdigits(n);
    }

    static int prod(int n){
        if(n%10==n){
            return n;
        }
        int rem=n%10;
        n=n/10;
        return rem*prod(n);
    }



}
