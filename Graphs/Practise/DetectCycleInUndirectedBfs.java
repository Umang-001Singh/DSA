package Graphs.Practise;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class DetectCycleInUndirectedBfs {
    public static void main(String[] args) {
        int[] s = {1,  2, 5, 7, 6, 3};
        int[] e = {2,  5, 7, 6, 3, 4};
        int V = 7;
        int E = 6;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V + 1; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            int start = s[i];
            int end = e[i];
            adj.get(start).add(end);
            adj.get(end).add(start);
        }
        System.out.println(adj);
        boolean ans = false;
        for (int i = 1; i < V+1; i++) {
            if((cycle(adj, V, E, i, -1))){
                ans = true;
            }
            else{
                ans = false;
            }
        }
        System.out.println(ans);
    }

    public static boolean cycle(ArrayList<ArrayList<Integer>> adj, int V, int E, int node, int parent){
        int[] vis = new int[V + 1];
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(node, parent));
        vis[node] = 1;

        while(!q.isEmpty()){
            Pair temp = q.poll();
            int n = temp.node;
            int p = temp.parent;

            for(Integer it: adj.get(n)){
                if(vis[it] == 0){
                    vis[it] = 1;
                    q.add(new Pair(it, n));
                }
                else if(it != p){
                    return true;
                }
            }
        }
        return false;
    }

    static class Pair{
        int node;
        int parent;
        Pair(int Node, int Parent){
            this.node = Node;
            this.parent = Parent;
        }
    }
}
