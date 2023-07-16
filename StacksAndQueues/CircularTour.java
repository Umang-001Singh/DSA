package StacksAndQueues;

import java.util.Stack;

public class CircularTour {
    public static void main(String[] args) {
        int [] petrol = {6,3,7};
        int [] distance = {4,6,3};
        System.out.println(tour(petrol, distance));
    }

    public static int tour(int []petrol,int[] distance){
        Stack<Integer> stack = new Stack<>();
        int diff;
	// Your code here	
    for(int i = 0;i<distance.length;i++){
        
        if(petrol[i]>distance[i]){
            int j = i;
            int broken = 0;
            do{
                if(stack.isEmpty()){
                    diff = petrol[j] - distance[j];
                }
                else{
                    diff = petrol[j] + stack.pop() - distance[j];
                }
                if(diff < 0){
                    broken = 1;
                    break;
                }
                else{
                    stack.push(diff);
                }
                
                if(j == petrol.length - 1){
                    j=0;
                }
                else{
                    j++;
                }
            }while(j!=i);
            if(broken == 0){
                return i;
            }
            
        }
    }
    return -1;
    }
}
