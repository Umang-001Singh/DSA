package StacksAndQueues;

import java.util.Arrays;
import java.util.Stack;

public class StockSpanProblem {
    public static void main(String[] args) {
        int []price = {10,4,5,90,120,80};
        System.out.println(Arrays.toString(stock(price, price.length)));
    }

    public static int[] stock(int []price, int n){

        //THIS SOLUTION HAS TIME COMPLEXITY IN WORST CASE AS O(n^2) AND AUXILARY SPACE COMPLEXITY OF O(n)

        // int []cirQueue = new int[n];
        // for(int i = 0; i<price.length; i++){
        //     cirQueue[i] = price[i];
        // }
        
        // int front = 0;
        // int end = cirQueue.length - 1;
        
        // Stack<Integer> stack = new Stack<>();
        // int count;
        
        // for(int i = price.length - 1;i>=0;i--){
        //     count = 0;
        //     end = i;
        //     while(end>=front && price[i]>=cirQueue[end]  ){
        //         count++;
        //         end = end - 1;
        //     }
        //     stack.push(count);
        
        // }
        
        // int []ans = new int[n];
        // int i =0;
        // while(!stack.isEmpty()){
        //     ans[i] = stack.pop();
        //     i++;
        // }
        // return ans;


        //THIS SOLUTION HAS TIME COMPELXITY OF O(n) AND AUXILARY SPACE COMPLEXITY OF O(n). BETTER CODE .

        Stack<Integer> stack = new Stack<>();
        int [] ans = new int[price.length];
        stack.push(0);
        ans[0] = 1;
        
        for(int i = 1;i<price.length;i++){
            while(!stack.isEmpty() && price[i]>=price[stack.peek()]){
                stack.pop();
            }
            
            if(stack.isEmpty()){
                ans[i] = i + 1;
            }
            else{
                ans[i] = i - stack.peek();
            }
            
            stack.push(i);
            
        }
        
        return ans;
    }
}
