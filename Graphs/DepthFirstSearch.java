package Graphs;

import java.util.ArrayList;

public class DepthFirstSearch {
    public static void main(String[] args) {
        
    }

    public static void Dfs(ArrayList<Integer> dfs, ArrayList<ArrayList<Integer>> adj, int node, boolean []vis){
        vis[node] = true;
        dfs.add(node);

        for(Integer it: adj.get(node)){
            if(vis[it] == false){
                Dfs(dfs, adj, it, vis);
            }
        }
        return;
    }
}
