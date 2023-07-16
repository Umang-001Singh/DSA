package Arrays;

import java.util.Arrays;

class TransposeofMatrix {
    public static void main(String [] args){
         int [][]arr={{1,2,3},{4,5,6}};
        int r=arr.length;
        int c=arr[0].length;
        int ans[][] = new int[c][r];
        ans=Trans(arr);
        System.out.print(Arrays.toString(ans));

    }

        static int[][] Trans(int [][]arr){
           int  [][] trans=new int[arr[0].length][arr.length];
           for(int i=0;i<arr.length;i++){
               for(int j=0;j<arr[0].length;j++){
                   trans[j][i]=arr[i][j];
               }
           }
           return trans;
        }


    }

