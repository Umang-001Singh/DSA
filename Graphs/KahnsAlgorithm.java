package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class KahnsAlgorithm {
    public static void main(String[] args) {
        
    }

    public static int[] kahns(ArrayList<ArrayList<Integer>> adj, int V){
        int []ans = new int[V];
        int []indeg = new int[V];
        ans = bfs(adj, indeg, V);
        return ans;
    }

    public static int[] bfs(ArrayList<ArrayList<Integer>> adj, int[] indeg, int V){
        for(int i = 0;i<V;i++){
            for(int it: adj.get(i)){
                indeg[it]++; 
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0;i<V;i++){
            if(indeg[i] == 0){
                q.add(i);
            }
        }

        int []ans = new int[V];
        int i = 0;
        while(!q.isEmpty()){
            int node = q.poll();
            ans[i++] = node;
            for(int it: adj.get(node)){
                indeg[it]--;
                if(indeg[it] == 0){
                    q.add(it);
                }
            }
        }
        return ans;
    }
}
