package Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathInUndirectedGraphWithUnitDistance {
    public static void main(String[] args) {
        
    }

    public static int[] shortest(int [][]edges, int n, int m, int src){
        int []dis = new int[n];
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i = 0;i<edges.length;i++){
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }
        for(int i = 0;i<dis.length;i++){
            dis[i] = (int)1e9;
        }
        int []ans = new int[n];
        ans = bfs(adj, dis, n, src);
        return ans;
    }

    public static int[] bfs(ArrayList<ArrayList<Integer>> adj, int []dis, int n, int src){
        dis[src] = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(src);

        while(!q.isEmpty()){
            int node = q.peek();
            q.remove();

            for(int it: adj.get(node)){
                if(dis[it] > dis[node] + 1){
                    dis[it] = dis[node] + 1;
                    q.add(it);
                }
            }
        }

        for(int i = 0;i<dis.length;i++){
            if(dis[i] == 1e9){
                dis[i] = -1;
            }
        }
        return dis;
    }
}
