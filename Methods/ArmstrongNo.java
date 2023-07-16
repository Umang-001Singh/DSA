package Methods;
//Print all the three digit Armstrong number.

public class ArmstrongNo {
    public static void main(String[] args) {
    for(int i=100;i<1000;i++){
        if(armstrong(i)){
            System.out.println(i+" ");
        }
    }
    }
    static boolean armstrong(int n){
    int sum=0;
    int originalval=n;
    int rem=0;
    while(n>0){
        rem=n%10;
        n=n/10;
        sum = sum +(rem*rem*rem);
    }
    if (sum==originalval)
        return true;
    return false;
    }
}







