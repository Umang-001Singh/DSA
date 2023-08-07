package Graphs;

import java.util.ArrayList;

public class BipartiteGraphsDFS {
    public static void main(String[] args) {

    }

    public static boolean bipartite(ArrayList<ArrayList<Integer>> adj, int []colors, int node, int prev){
        colors[node] = 1 - prev;
        for(int it: adj.get(node)){
                if(colors[it] == -1){
                    if(bipartite(adj, colors, it, 1-prev)==false){
                        return false;
                    }
                }
                else if(colors[it] == colors[node]){
                    return false;
                }
        }

        return true;
    }
}
