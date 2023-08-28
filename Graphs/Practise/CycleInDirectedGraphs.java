package Graphs.Practise;

import java.util.ArrayList;

public class CycleInDirectedGraphs {
    public static void main(String[] args) {
        int[] s = {1, 2, 3, 3, 4, 5, 7};
        int[] e = {2, 3, 4, 7, 5, 6, 5};
        int V = 7;
        int E = 7;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V + 1; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            int start = s[i];
            int end = e[i];
            adj.get(start).add(end);
        }

        System.out.println(adj);
        int[] vis = new int[V+1];
        int[] path = new int[V+1];
        int ans = -1;
        for(int i = 1;i<=V;i++){
            ans = cycle(adj, vis, path, i);
            if(ans == 1){
                
                break;
            }
        }
        System.out.println(ans);
    }

    public static int cycle(ArrayList<ArrayList<Integer>> adj, int[] vis, int[] path, int node){
        vis[node] = 1;
        path[node] = 1;
        
        for(Integer it: adj.get(node)){
            if(vis[it] == 0){
                cycle(adj, vis, path, it);
            }
            else if(path[node] == path[it] ){
                return 1;
            }
        }
        path[node] = 0;
        return 0;
    }
}
