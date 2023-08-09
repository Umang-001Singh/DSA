package Graphs;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class DijstrasAlgorithmUsingPQ {
    public static void main(String[] args) {
        
    }

    public static int[] shortest(ArrayList<ArrayList<ArrayList<Integer>>> adj, int V, int S){
        int []dis = new int[V];
        for(int i = 0;i<V;i++){
            dis[i] = (int)1e9;
        }

        int []ans = new int[V];
        ans = bfs(adj, V, dis, S);
        return ans;
    }

    public static int[] bfs(ArrayList<ArrayList<ArrayList<Integer>>> adj, int V, int[] dis, int S){
        dis[S] = 0;
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(0, S));

        while(!pq.isEmpty()){
            int wt = pq.peek().first;
            int node = pq.peek().second;
            pq.remove();

            for(int i = 0;i<adj.get(node).size();i++){
                int nwt = adj.get(node).get(i).get(1);
                int nnode = adj.get(node).get(i).get(0);
                
                if(dis[nnode] > dis[node] + nwt){
                    dis[nnode] = dis[node] + nwt;
                    pq.add(new Pair(nwt, nnode));
                }
            }
        }

        for(int i = 0;i<dis.length;i++){
            if(dis[i] == (int)1e9){
                dis[i] = -1;
            }
        }
        return dis;
    }

    static class Pair implements Comparable<Pair>{
        int first;
        int second;

        Pair(int _first, int _second){
            this.first = _first;
            this.second = _second;
        }

        @Override
        public int compareTo(Pair p){
            return this.first - p.first;
        }
    }
}
