package Pattern;

public class Patten3 {
    public static void main(String [] args ){
        int lines=5;
        pattern3(lines);

    }

    static void pattern3(int n){
        for(int row=1;row<=n;row++){
            for(int col=1;col<=(n+1-row);col++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
