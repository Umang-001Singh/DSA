package Recursion;

public class PatternReversedTriangle {
    public static void main(String[] args) {
        Triangle(4,0);
    }

    static int Triangle(int r, int c){
        if(r == 0){
            return 0;
        }
        if(c<r){
            System.out.print("*");
            return Triangle(r, c+1);
        }
        else{
            System.out.println();
            return Triangle(r-1, 0);
        }
    }
}
