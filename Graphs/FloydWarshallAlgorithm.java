package Graphs;

public class FloydWarshallAlgorithm {
    public static void main(String[] args) {
        
    }

    public static void floydWarshall(int [][]matrix){
        int n = matrix.length;
        for(int i = 0;i<n;i++){
            for(int j = 0;j<n;j++){
                if(matrix[i][j] == -1){
                    matrix[i][j] = (int)1e9; 
                }
            }
        }

        
        matrix = shortest(matrix, n);

        for(int i = 0;i<n;i++){
            for(int j = 0;j<n;j++){
                if(matrix[i][j] == (int)1e9){
                    matrix[i][j] = -1;
                }
            }
        }
    }

    public static int[][] shortest(int [][]matrix, int n){
        for(int k = 0;k<n;k++){
            for(int i = 0;i<n;i++){
                for(int j = 0;j<n;j++){
                    matrix[i][j] = Math.min(matrix[i][j], matrix[i][k] + matrix[k][j]);
                }
            }
        }

        // For negative cycle
        // for(int i = 0;i<n;i++){
        //     if(matrix[i][i] < 0){
        //         System.out.println("Negative Cycle Matrix");
        //         break;
        //     }
        // }

        return matrix;
    }
}
