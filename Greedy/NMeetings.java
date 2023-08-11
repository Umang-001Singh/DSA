package Greedy;

import java.util.PriorityQueue;

public class NMeetings {
    public static void main(String[] args) {
        int []start = {1, 3, 0, 5, 8, 5};
        int []end = {2, 4, 6, 7, 9, 9};
        int ans = maxMeetings(start, end, start.length);
        System.out.println(ans);
    }

    public static int maxMeetings(int []start, int []end, int N){
        int ans = max(start, end);
        return ans;
    }

    public static int max(int []start, int []end){
        PriorityQueue<Meet> pq = new PriorityQueue<>();
        for(int i = 0;i<start.length;i++){
            pq.add(new Meet(end[i], start[i], start[i] - end[i]));
        }

        int count = 0;
        int limit = 0;
        while(!pq.isEmpty()){
            int e = pq.peek().end;
            int s = pq.peek().start;
            pq.remove();
            if(s > limit){
                count++;
                limit = e;
            }
            
        }
        return count;
    }

    static class Meet implements Comparable<Meet>{
        int end;
        int start;
        int time;
        Meet(int _end, int _start, int _time){
            this.end = _end;
            this.start = _start;
            this.time = _time;
        }

        @Override
        public int compareTo(Meet p){
            return this.end - p.end;
        }
    }
}
