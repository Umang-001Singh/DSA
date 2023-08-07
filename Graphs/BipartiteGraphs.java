package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BipartiteGraphs {
    public static void main(String[] args) {
        
    }

    public static boolean bipartite(ArrayList<ArrayList<Integer>> adj, int []colors, int node){
        colors[node] = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        colors[node] = 0;

        while(!q.isEmpty()){
            int col = q.peek();
            q.remove();

            for(int it: adj.get(col)){
                if(colors[it] == -1){
                    colors[it] = 1 - colors[col];
                    q.add(it);
                }
                else if(colors[it] == colors[col]){
                    return false;
                }
            }
        }
        return true;
    }
}
