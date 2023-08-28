package StacksAndQueues;

import java.util.Stack;

public class LongestValidParenthesis {
    public static void main(String[] args) {
        String s = "(()";
        int ans = longest(s);
        System.out.println(ans);
    }

    public static int longest(String s){
        int maxans = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for(int i = 0;i<s.length();i++){
            if(s.charAt(i) == '('){
                stack.push(i);
            }
            else{
                stack.pop();
                if(stack.isEmpty()){
                    stack.push(i);
                }
                else{
                    maxans = Math.max(maxans, i - stack.peek());
                }
            }
        }
        return maxans;
    }
}
