package Arrays;

public class MatrixDiagonalSum {
    public int diagonalSum(int[][] mat) {
        int sum=0;
        int length=mat.length -1;
        for(int i=0;i<mat.length;i++){
            sum=sum+mat[i][i]+mat[i][length-i];
        }
        if(mat.length%2==0)
            return sum;
        else
            return sum-mat[length/2][length/2];
    }
}