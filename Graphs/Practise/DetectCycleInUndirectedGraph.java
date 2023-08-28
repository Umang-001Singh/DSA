package Graphs.Practise;

import java.util.ArrayList;

public class DetectCycleInUndirectedGraph {
    public static void main(String[] args) {
        int V = 7;
        int E = 7;
        int[] s = {1, 1, 2, 5, 7, 6, 3};
        int[] e = {2, 3, 5, 7, 6, 3, 4};
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0;i<V+1;i++){
            adj.add(new ArrayList<>());
        }

        for(int i = 0;i<E;i++){
            int start = s[i];
            int end = e[i];
            adj.get(start).add(end);
            adj.get(end).add(start);
        }

        System.out.println(adj);
        boolean ans = cycle(adj, new int[V+1], -1, 1);
        System.out.println(ans);
    }

    public static boolean cycle(ArrayList<ArrayList<Integer>> adj, int[] vis, int parent, int node){
        vis[node] = 1;

        for(Integer it: adj.get(node)){
            if(vis[it] == 0){
                return cycle(adj, vis, node, it);
            }
            else if(it != parent){
                return true;
            }
        }
        return false;
    }
}
