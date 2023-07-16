package Pattern;

public class Pattern31 {
    public static void main(String [] args){
        int n=4;
        pattern31(n);

    }

    static void pattern31(int n){
        for(int row=1; row<=2*n-1;row++) {
            for(int col=1;col<=2*n-1;col++) {
                {
                System.out.print(Math.max(Math.max(n-(row-1),n-(2*n-1-row)),Math.max(n-(col-1),n-(2*n-1-col)))+" ");
                }
            }
            System.out.println();
        }

        }
    }

