package Graphs;

import java.util.ArrayList;
import java.util.Arrays;



public class CityAttractions {
    public static void main(String[] args) {
        int n = 5;
        int m = 6;
        int max_time = 70;
        int[] u = {4, 1, 0, 4, 2, 2};
        int[] v = {3, 4, 3, 0, 3, 0};
        int[] t = {20, 15, 40, 10, 100, 10};
        int[] beauty = {30, 80, 100, 50, 50};
        int ans = cityAttractions(n, m, max_time, u, v, beauty, t);
        System.out.println(ans);
    }

    public static int cityAttractions(int n, int m, int max_time, int[] u, int[] v, int[] beauty, int[] time){
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        int[] vis = new int[n];
        Arrays.fill(vis, -1);
        for(int i = 0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        for(int i = 0;i<u.length;i++){
            int node = u[i];
            int next = v[i];
            int val_next = beauty[next];
            int val_node = beauty[node];
            int t = time[i];
            adj.get(node).add(new Pair(next, val_next, t));
            adj.get(next).add(new Pair(node, val_node, t));
        }
        // int max = 0;
        int ans = maxBeauty(adj, vis, max_time, 0, beauty);
        return ans;
    }

    public static int maxBeauty(ArrayList<ArrayList<Pair>> adj, int []vis, int max_time, int node, int[] beauty){
        vis[node] = 1;
        // int score = 0;
        // score += beauty[node];
        int max = 0;

        for (int i = 0; i < adj.get(node).size(); i++) {
            int ans = 0;
            int n = adj.get(node).get(i).node;
            if(max_time>= 2*adj.get(node).get(i).time && vis[n] == -1){
                ans =  maxBeauty(adj, vis, max_time - 2*adj.get(node).get(i).time, n, beauty);
            }
            max = Math.max(max, ans);
        }
        vis[node] = 0;
        return max + beauty[node];
    }

    static class Pair{
        int node;
        int val;
        int time;
        Pair(int _node, int _val, int _time){
            this.node = _node;
            this.val = _val;
            this.time = _time;
        }
    }
}
