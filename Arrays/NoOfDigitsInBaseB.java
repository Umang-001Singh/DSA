package Arrays;

public class NoOfDigitsInBaseB {
    public static void main(String [] args){
        int n=10;
        int base=2;
        System.out.println(NoOfDigits(n, base));

    }

    static int NoOfDigits(int n,int b){
        int num1=(int) (Math.log(n)/Math.log(b))+1;
        return num1;
    }
}
