package Recursion;

public class Reverse {
    public static void main(String[] args) {
        reverse(11211);
    }

    static void reverse(int n){
        if(n%10==n){
            System.out.print(n);
            return ;
        }
        int rem=n%10;
        n=n/10;
        System.out.print(rem);
        reverse(n);
    }
}
