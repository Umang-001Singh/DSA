package Graphs;

import java.util.ArrayList;

public class DetectCycleInUndirectedGraphDFS {
    public static void main(String[] args) {
        
    }

    public static boolean cycleCheck(int []vis, int node, int parent, ArrayList<ArrayList<Integer>> adj){
        vis[node] = 1;

        for(int it: adj.get(node)){
            if(vis[it] == 0){
                vis[it] = 1;
                boolean ans = cycleCheck(vis, it, node, adj);
                if(ans == true){
                    return true;
                }
            }
            else if(it != parent){
                return true;
            }
        }
        return false;
    }
}
