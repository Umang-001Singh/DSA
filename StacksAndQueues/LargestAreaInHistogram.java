package StacksAndQueues;

import java.util.Stack;

public class LargestAreaInHistogram {
    public static void main(String[] args) {
        int [] heights = {2, 1, 5, 6, 2, 3};
        int ans = Area(heights);

        System.out.println(ans);
    }

    private static int Area(int [] heights){

        // O(n^2) APPROACH
        
        // Stack<Integer> stack = new Stack<>();
        // stack.push(0);        
        // int len = heights.length;

        // for(int i = len - 1;i>=0;i--){
        //     int j = i;
        //     int Area = 0;
        //     while(j<=len - 1){
        //         if(heights[i]<=heights[j]){
        //         Area = Area + heights[i];
        //         j++;
        //         }
        //         else{
        //             break;
        //         }
        //     }

        //     j = i - 1;
        //     while(j>=0){
        //         if(heights[i]<=heights[j]){
        //             Area = Area + heights[i];
        //             j--;
        //         }
        //         else{
        //             break;
        //         }
        //     }

        //     int PrevVal = stack.peek();
        //     if(Area >= PrevVal){
        //         stack.push(Area);
        //     }
        // }
        // int ans = stack.pop();
        // return ans;

        //O(n) APPROACH 

        if((heights.length == 0)|| (heights == null)){
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        int MaxArea = 0;
        int Area = 0;
        int i = 0;
        
        while(i<heights.length){
            if(stack.isEmpty() || heights[i]>=heights[stack.peek()]){
                stack.push(i);
                i++;
            }
            else{
                

                // Area = getArea(heights,i,stack);
                int p = stack.pop();
                int val = heights[p];
                int w = 0;
                if(stack.isEmpty()){
                    w = i;
                }
                else{
                    w = i - stack.peek() - 1;
                }
                Area = val*w;
            }
            if(Area > MaxArea){
                MaxArea = Area;
            }
        }

        while(!stack.isEmpty()){
            // Area = getArea(heights,i,stack);
            int p = stack.pop();
                int val = heights[p];
                int w = 0;
                if(stack.isEmpty()){
                    w = i;
                }
                else{
                    w = i - stack.peek() - 1;
                }
                Area = val*w;
            if(Area>MaxArea){
                MaxArea = Area;
            }
        }
        return MaxArea;
    }
}
