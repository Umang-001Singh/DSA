package StacksAndQueues;

import java.util.Stack;

public class CelebrityProblem {
    public static void main(String[] args) {
        int [][]M ={{0,0,0,0,0},{1,0,0,0,0},{1,0,0,0,0},{1,0,0,0,0},{1,0,0,0,0}};
        int n = M.length;
        System.out.println(celebrity(M, n));
    }

    public static int celebrity(int [][]M, int n){

        //TIME COMPLEXITY IS O(n) AND SPACE COMPLEXITY IS O(n) .
        Stack<Integer> stack = new Stack<>();
            int pos = 0;
            
            for(int i = 0;i<M.length;i++){
                pos = 0;
                for(int j = 0;j<M[i].length;j++){
                    if(M[i][j] == 1){
                        pos = 1;
                    }
                }
                if(pos == 0){
                    stack.push(i);
                }
            }
            
            if(stack.size() != 1){
                return -1;
            }
            
            pos = 0;
            int []arr = new int[M.length];
            int j = stack.peek();
            for(int i = 0;i<M.length;i++){
                if(i!=j && M[i][j] == 1){
                    arr[i] = 0;
                }
                else if(i!=j && M[i][j] == 0){
                    arr[i] = 1;
                }
                else{
                    
                }

                
            }
            
            for(int i = 0;i<arr.length;i++){
                if(arr[i] == 1){
                    return -1;
                }
            }
            return stack.peek();
    }
}
