package Pattern;

public class Pattern30 {
    public static void main(String [] args){
        int n=5;
        pattern30(n);

    }

    static void pattern30(int n){
        for(int row=1;row<=n;row++){
            int NoofSpaces=n-row;
            for(int s=1;s<=NoofSpaces;s++){
                System.out.print(" ");
            }
            for(int col=1;col<=2*row-1;col++){
                if(col<=row){
                    System.out.print(row-col+1);
                }
                else{
                    System.out.print(col-row+1);
                }
            }
            System.out.println();
        }
    }
}
