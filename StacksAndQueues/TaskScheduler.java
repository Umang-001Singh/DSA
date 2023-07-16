package StacksAndQueues;

import java.util.Stack;

public class TaskScheduler {
    public static void main(String[] args) {
        char []tasks ={'A','A','A','B','B','B'}; 
        int n = 2;
        System.out.println(task(tasks, n));   
    }

    public static int  task(char [] tasks, int n){
        Stack<Integer> stack = new Stack<>();
        int i =0;
        int time = 0;
        for(int ch = 0;ch<tasks.length;ch++){
            i++;
            time++;
            if(i==n && ch!=tasks.length-1){
                i =0;
                time++;
            }
            stack.push(time);
        }

        return stack.pop();
    }
}
