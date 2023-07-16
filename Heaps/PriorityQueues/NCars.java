package Heaps.PriorityQueues;


import java.util.Comparator;
import java.util.PriorityQueue;

public class NCars {
    static class Points implements Comparable<Points>{ //REQUIRED IN PRIORITY QUEUE TO PUT POINTS IN ASCENDING OR DESCENDING ORDER. 
        int x;                                         // FOR DESCENDING ORDER IT WILL BE: PriorityQuere<Points> pq = new PriorityQueue<>(Comparator.reverseOrder());
        int y;
        int dist;

        Points(int x, int y, int dist){ 
            this.x = x;
            this.y = y;
            this.dist = dist;
        }

        @Override
        public int compareTo(Points p){
            return this.dist - p.dist;
        }

        
    }

    public static void main(String[] args) {
        int [][]points = {{3,3},{5,-1},{-2,4}};
        int k = 2;

        PriorityQueue<Points> pq = new PriorityQueue<>();
        for(int i = 0;i<points.length;i++){
            int distSq = points[i][0]*points[i][0] + points[i][1] * points[i][1];
            pq.add(new Points(points[i][0], points[i][1], distSq));
        }

        int [][]ans = new int[k][2];
        
        for(int i = 0;i<k;i++){
            Points obj = pq.remove();
            
            
            ans[i][0] = obj.x;
            ans[i][1] = obj.y;
        }
        for(int i = 0;i<ans.length;i++){
            for(int j = 0;j<2;j++){
                System.out.print(ans[i][j] + " ");
            }
        }
    }

    
}
