package StacksAndQueues;
import java.util.*;

public class AsteroidColl {
    public static void main(String[] args) {
        int [] asteroids = {-2,2,-1,-2};
        int [] ans = asteroid(asteroids);
        System.out.println(Arrays.toString(ans));
    }
    public static int[] asteroid(int [] arr){
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> ans = new Stack<>();

        for(int i=0;i<arr.length;i++){
            stack.push(arr[i]);
        }
        
        ans.push(stack.pop());

        while(!stack.isEmpty()){
            // if((stack.peek()>0 && ans.peek()<0) || (stack.peek()<0 && ans.peek()>0)){
                
                if((!ans.isEmpty())&&(stack.peek()>=0) && (ans.peek()>=0)){
                    ans.push(stack.pop());
                }
                else if((!ans.isEmpty())&&(stack.peek()<0) && (ans.peek()<0)){
                    ans.push(stack.pop());
                }
                else if((!ans.isEmpty())&&(ans.peek()>=0)&&(stack.peek()<0)){
                    ans.push(stack.pop());
                }
                else if((!ans.isEmpty())&&(ans.peek()<0)&&(stack.peek()>=0)){
                    if(Math.abs(ans.peek())>Math.abs(stack.peek())){
                        stack.pop();
                    }
                    else if(Math.abs(ans.peek())<Math.abs(stack.peek())){
                        ans.pop();
                        // ans.push(stack.pop());
                    }
                    else{
                        stack.pop();
                        ans.pop();
                    }
                }
                else{
                    ans.push(stack.pop());
                }

                // else if((Math.abs(stack.peek()))>(Math.abs(ans.peek()))){
                //     ans.pop();
                //     ans.push(stack.pop());
                // }
                // else if((Math.abs(stack.peek()))<(Math.abs(ans.peek()))){
                //     stack.pop();
                // }
                // else if((Math.abs(stack.peek()))==(Math.abs(ans.peek()))){
                //     ans.pop();
                //     stack.pop();
                // }
                // else{

                // }
            // }
            // else{
            //     break;
            // }
        }

        // while(!stack.isEmpty()){
        //     ans.push(stack.pop());
        // }

        int  []Ans = new int[ans.size()];
        int i =0;
        while(!ans.isEmpty()){
            Ans[i] = ans.pop();
            i++;
        } 
        return Ans;  
    }
}
