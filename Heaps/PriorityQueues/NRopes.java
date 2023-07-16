package Heaps.PriorityQueues;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class NRopes {
    public static void main(String[] args) {
        int []arr = {2,3,3,4,6};
        System.out.println(cost(arr));
    }

    public static int cost(int []arr){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0;i<arr.length;i++){
            pq.add(arr[i]);
        }

        int sum = 0;
        // int sub = pq.peek();
        
        ArrayList<Integer> list = new ArrayList<>();
        while(!pq.isEmpty() && pq.size()>1){
            int first = pq.poll();
            int second = pq.poll();
            sum = first + second;
            pq.add(sum);
            list.add(sum);
        }

        int cost = 0;
        for(int i = 0;i<list.size();i++){
            cost = cost + list.get(i);
        }
        
        return cost;
    }
}
