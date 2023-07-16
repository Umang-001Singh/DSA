package StacksAndQueues;
import java.util.*;

public class pattern132 {
    public static void main(String[] args) {
        int []nums ={1,2,3,4,-4,-3,-5,-1};
        boolean ans = pattern(nums);
        System.out.println(ans);
        
    }

    public static boolean pattern(int []nums){
        if(nums.length < 3){
            return false;
        }

        Stack<Integer> first = new Stack<>();
        Stack<Integer> second = new Stack<>();

        for(int i = 0;i<nums.length;i++){
            if(first.isEmpty() || nums[i]<nums[first.peek()]){
                first.push(i);

                if(i > 0){
                    int j = i+1;
                    int count = 0;
                    while(j<nums.length){
                        if(!second.isEmpty() && nums[j]>nums[first.peek()]){
                            second.push(j);
                            count = 1;
                            break;
                        }
                        j++;
                    }
                    if(count == 0){
                        first.pop();
                    }
                }
            }

            if(second.isEmpty() || (nums[i]>nums[second.peek()] && nums[i]>nums[first.peek()])){
                second.push(i);
            }
            if(nums[i]>nums[first.peek()] && nums[i]<nums[second.peek()]){
                return true;
            }
            else{

            }

        }
        return false;
    }
}
