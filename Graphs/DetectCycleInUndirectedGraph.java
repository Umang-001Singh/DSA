package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class DetectCycleInUndirectedGraph {
    public static void main(String[] args) {
        
    }

    public static boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj){
        for(int i = 0;i<V;i++){
            if(cycleCheck(V, adj, i)){
                return true;
            }
        }
        return false;
    }

    public static boolean cycleCheck(int V, ArrayList<ArrayList<Integer>> adj, int node){
        int []vis = new int[V];
        vis[node] = 1;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(node, -1));

        while(!q.isEmpty()){
            int n = q.peek().Node;
            int parent = q.peek().Parent;
            q.remove();

            for(int it: adj.get(n)){
                if(vis[it] == 0){
                    vis[it] = 1;
                    q.add(new Pair(it, n));
                }
                else if(it != parent){
                    return true;
                }
            }
        }
        return false;
    }

    static class Pair{
        int Node;
        int Parent;
        Pair(int node, int parent){
            this.Node = node;
            this.Parent = parent;
        }
    }
}
