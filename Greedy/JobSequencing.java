package Greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class JobSequencing {
    public static void main(String[] args) {
        int [][]jobs = {{1, 2, 100}, {2 ,1, 19}, {3, 2, 27}, {4, 1, 25}, {5, 1, 15}};
        int []ans = new int[2];
        ans =JobScheduling(jobs, 5);
        
        System.out.println(Arrays.toString(ans));
        
    }

    public static int[] JobScheduling(int [][]arr, int N){
        PriorityQueue<Member> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for(int i = 0;i<arr.length;i++){
            pq.add(new Member(arr[i][2], arr[i][1], arr[i][0]));
        }

            int count = 0;
            int sum = 0;
            int []jobs = new int[N];
            Arrays.fill(jobs, -1);
            while(!pq.isEmpty()){
                int p = pq.peek().profit;
                int l = pq.peek().limit;
                int id = pq.peek().id;
                pq.remove();

                for(int i = l-1;i>=0;i--){
                    if(jobs[i] == -1){
                        jobs[i] = id;
                        sum = sum + p;
                        count++;
                        break;
                    }
                }
            }
            int []ans = {count, sum};
        return ans;
    }

    static class Job {
        int id, profit, deadline;
        Job(int x, int y, int z){
            this.id = x;
            this.deadline = y;
            this.profit = z; 
        }
    }

    static class Member implements Comparable<Member>{
        int profit;
        int limit;
        int id;

        Member(int _profit, int  _limit, int _id){
            this.profit = _profit;
            this.limit = _limit;
            this.id = _id;
        }

        @Override
        public int compareTo(Member p){
            return this.profit - p.profit;
        }
    }

}
