package StacksAndQueues;

import java.util.*;

public class DailyTemperatures {
    public int[] temperature(int [] temp){
        Stack<Integer> stack = new Stack<>();
        int []ans = new int[temp.length];
        int i = 0;
        while(i<temp.length){
            while(!stack.isEmpty() && temp[i]>temp[stack.peek()]){
                ans[stack.peek()] = i-stack.peek();
                stack.pop();
            }
            stack.push(i);
            i++;
        }

        while(!stack.isEmpty()){
            ans[stack.peek()] = 0;
            stack.pop();
        }
        return ans;
    }
}
