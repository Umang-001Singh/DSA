package StacksAndQueues;

import java.time.Year;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;
import java.util.logging.Handler;

public class RobotCollision {
    public static void main(String[] args) {
        int[] pos = {3, 5, 2, 6};
        int[] health = {10, 10, 15, 12};
        String dirc = "RLRL";
        List<Integer> list = collisions(pos, health, dirc);
        System.out.println(list);
    }

    public static List<Integer> collisions(int[] pos, int[] health, String dirc){
        Pair[] arr = new Pair[pos.length];
        for(int i = 0;i<pos.length;i++){
            // arr[i].pos = pos[i];
            // arr[i].health =  health[i];
            // arr[i].dirc = dirc.charAt(i);
            arr[i] = new Pair(pos[i], health[i], dirc.charAt(i));
        }
        Arrays.sort(arr);
        
        Stack<Pair> stack = new Stack<>();
        for(int i = 0;i<arr.length;i++){
            while(!stack.isEmpty() && stack.peek().dirc == 'R' && arr[i].dirc == 'L'){
                int diff = stack.peek().health - arr[i].health;
                
                if(diff > 0){
                    arr[i] = new Pair(-1, 0, 'Y');
                    stack.peek().health = diff;
                }
                else if(diff < 0){
                    stack.pop();
                    arr[i].health = Math.abs(diff);
                }
                else{
                    stack.pop();
                    arr[i] = new Pair(-1, 0, 'Y');
                }
            }

            if(arr[i].pos != -1){
                stack.push(arr[i]);
            }
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        while(!stack.isEmpty()){
            Pair temp = stack.pop();
            map.put(temp.pos, temp.health);
        }
        List<Integer> list = new ArrayList<>();
        for(int i = 0;i<pos.length;i++){
            if(map.containsKey(pos[i])){
                list.add(map.get(pos[i]));
            }
        }
        
        return list;
    }

    static class Pair implements Comparable<Pair>{
        int pos;
        int health;
        char dirc;
        
        Pair(int Pos, int Health, char Dirc){
            this.pos = Pos;
            this.health = Health;
            this.dirc = Dirc;
        }
        @Override
        public int compareTo(Pair obj){
            return this.pos - obj.pos;
        }
    }
}
