package Recursion;

import static Recursion.PatternReversedTriangle.Triangle;

public class PatternNormalTriangle {
    public static void main(String[] args) {
        Triangle(4,0);
    }

    /*static int Triangle(int r, int c, int limit){
        if(r>limit){
            return 0;
        }
        if(c<r){
            System.out.print("*");
            return Triangle(r, c+1, limit);
        }
        else{
            System.out.println();
            return Triangle(r+1, 0, limit);
        }
    }*/

    static void Triangle(int r, int c){
        if(r==0){
            return;
        }

        if(c<r){
            Triangle(r, c+1);
            System.out.print("*");
        }
        else{
            Triangle(r-1,0);
            System.out.println();
        }
    }
}
