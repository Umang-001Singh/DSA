package Graphs;

import java.util.ArrayList;

public class DetectCycleInDirectedGraphs {
    public static void main(String[] args) {
        
    }

    public static boolean isCyclic(ArrayList<ArrayList<Integer>> adj, int V){
        int []vis = new int[V];
        int []path = new int[V];
        for(int i = 0;i<V;i++){
            if(vis[i] == 0){
                if(dfs(adj, vis, path, i) == true){
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean dfs(ArrayList<ArrayList<Integer>> adj, int []vis, int []path, int node){
        vis[node] = 1;
        path[node] = 1;

        for(int it: adj.get(node)){
            if(vis[it] == 0){
                if(dfs(adj, vis, path, it) == true){
                    return true;
                }
            }
            else if(path[it] == path[node]){
                return true;
            }
        }
        path[node] = 0;
        return false;
    }
}
