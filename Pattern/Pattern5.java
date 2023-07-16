package Pattern;

public class Pattern5 {
    public static void main(String [] args){
        int n=5;
        pattern5(5);

    }

    static void pattern5(int n){
        for(int row=1;row<=(2*n-1);row++){
            if(row <= 5) {
                for (int col = 1; col <= row; col++) {
                    System.out.print("*" + " ");
                }
            }
            else{
                for(int col=1;col<=5-(row-5);col++){
                    System.out.print("*"+" ");
                }
            }
            System.out.println();
        }
    }
}
