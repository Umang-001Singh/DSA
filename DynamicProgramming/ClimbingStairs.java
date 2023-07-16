package DynamicProgramming;

public class ClimbingStairs {
    public static void main(String[] args) {
        int n = 4;
        System.out.println(climb(n));
    }

    public static int climb(int n){
        if(n==0){
            return 1;
        }
        if(n==1){
            return 1;
        }
        int left = climb(n-1);
        int right = climb(n-2);

        return left + right;
    }
}
