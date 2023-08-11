package Greedy;

import java.util.PriorityQueue;

public class MinPlatforms {
    public static void main(String[] args) {
        int []arrival = {900, 1100, 1235};
        int []dep = {1000, 1200, 1900};
        int ans = findPlatform(arrival, dep, arrival.length);
        System.out.println(ans);
    }

    public static int findPlatform(int []arrival, int []dep, int N){
        int ans = max(arrival, dep);
        return ans;
    }

    public static int max(int []arrival, int []dep){
        PriorityQueue<Platforms> pq = new PriorityQueue<>();
        for(int i = 0;i<arrival.length;i++){
            pq.add(new Platforms(dep[i], arrival[i]));
        }

        
        
        PriorityQueue<Integer> d = new PriorityQueue<>();
        int limit = (int)1e9;
        int count = 0;
        while(!pq.isEmpty()){
            int s = pq.peek().start;
            int e = pq.peek().end;
            pq.remove();

            if(s <= limit){
                count++;
                if(limit > e){
                    d.add(limit);
                    limit = e;
                }
                else{
                    d.add(e);
                }
            }
            else{
                d.add(e);
                limit = d.poll();
            }
        }
        return count;
    }

    static class Platforms implements Comparable<Platforms>{
        int end;
        int start;
        
        Platforms(int _end, int _start){
            this.end = _end;
            this.start = _start;
            
        }

        @Override
        public int compareTo(Platforms p){
            return this.start - p.start;
        }
    }
}
