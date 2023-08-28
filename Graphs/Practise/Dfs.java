package Graphs.Practise;

import java.util.ArrayList;

public class Dfs {
    public static void main(String[] args) {
        int V = 8;
        int E = 8;
        int[] s = {1, 1, 2, 2, 3, 3, 4, 8};
        int[] e = {2, 3, 5, 6, 4, 7, 8, 7};
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
        ArrayList<Integer> ans = new ArrayList<>();
        dfs(adj, ans, new int[V+1], 1);
        System.out.println(ans);
    }

    public static void dfs(ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> ans, int[] vis, int ver){
        vis[ver] = 1;
        ans.add(ver);

        for(Integer it: adj.get(ver)){
            if(vis[it] == 0){
                dfs(adj, ans, vis, it);
            }
        }
        return;
    }
}
