package Arrays;

public class MagicNo {
    public static void main(String [] args){
        int n=10;
        System.out.println(magicno(n));

    }

    static int magicno(int n){
        int n1=n|0;int sum=0;
        for(int i=1;i<=n1;i++){
            int last=n&1;
            sum+=(int) (last*(Math.pow(5,i)));
            n=n >> 1;
        }
        return sum;
    }
}
