package Graphs.Practise;

import java.net.Inet4Address;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class KahnsAlgo {
    public static void main(String[] args) {
        int V = 6;
        int E = 6;
        int[] s = {2, 3, 4, 4, 5, 5};
        int[] e = {3, 1, 0, 1, 0, 2};
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V ; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            int start = s[i];
            int end = e[i];
            adj.get(start).add(end);
        }

        System.out.println(adj);
        ArrayList<Integer> ans = cycle(adj, V, E);
        System.out.println(ans);
    }

    public static ArrayList<Integer> cycle(ArrayList<ArrayList<Integer>> adj, int V, int E){
        int[] indeg = new int[V];
        for (int i = 0; i < adj.size(); i++) {
            for(Integer it: adj.get(i)){
                indeg[it]++;
            }
        }
        // int[] vis = new int[V];

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < indeg.length; i++) {
            if(indeg[i] == 0){
                q.add(i);
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        while(!q.isEmpty()){
            int node = q.poll();
            ans.add(node);
            for(Integer it:adj.get(node)){
                indeg[it]--;
                if(indeg[it] == 0){
                    q.add(it);
                }
            }
        }
        return ans;
    }
}
