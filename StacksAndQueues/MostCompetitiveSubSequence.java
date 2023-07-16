package StacksAndQueues;

import java.util.Arrays;
import java.util.Stack;

public class MostCompetitiveSubSequence {
    public static void main(String[] args) {
        int []nums = {3,5,2,6};
        System.out.println(Arrays.toString(MostCompetitive(nums, 2)));
    }

    public static int[] MostCompetitive(int []nums,int k){
        Stack<Integer> stack = new Stack<>();
        for(int i = 0;i<nums.length;i++){
            
            while(!stack.isEmpty() && nums[i]<nums[stack.peek()] && nums.length - i + stack.size()>k){
                stack.pop();
            }
            if(stack.size() <k){
                stack.push(i);
            }
        }

        int []ans = new int[stack.size()];
        int i = ans.length - 1;
        while(!stack.isEmpty()){
            ans[i] = nums[stack.pop()];
            i--;
        }
        return ans;
    }
}
