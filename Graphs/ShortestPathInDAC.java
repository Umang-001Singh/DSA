package Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class ShortestPathInDAC {
    public static void main(String[] args) {
        int [][]edge = {{0, 2, 6}, {0, 3, 7}, {0, 4, 9}, {0, 6, 8}, {0, 7, 6}, {1, 2, 6},{1, 3, 7}, {1, 5, 10}, {1, 6, 1}, {1, 7, 4}, {2, 3, 3}, {2, 6, 10}, {2, 8, 8}, {2, 9, 10},{3, 5, 3}, {3, 6, 10}, {3, 7, 5}, {5, 6, 9}, {5, 7, 7}, {6, 7, 7}, {6, 8, 8}, {6, 9, 8}, {7, 9, 1}, {8, 9, 6}};
        int N = 10;
        int M = 24;
        int []ans = new int[N];
        ans = shortest(edge, M, N, 0);
        // ans = {0 , -1, 6, 7, 9, 10, 8, 6, 14, 7};
        System.out.println(Arrays.toString(ans));
    }

    public static int[] shortest(int [][]edges, int M, int N, int src){
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i = 0;i<N;i++){
            // ArrayList<Pair> temp = new ArrayList<Pair>();
            // adj.add(temp);
            adj.add(new ArrayList<Pair>());
        }

        for(int i = 0;i<M;i++){
            int parent = edges[i][0];
            int node = edges[i][1];
            int wt = edges[i][2];
            adj.get(parent).add(new Pair(node, wt));
        }

        int []vis = new int[N];
        Stack<Integer> st = new Stack<>();
        for(int i = 0;i<N;i++){
            if(vis[i] == 0){
                topo(adj, vis, i, st);
            }
        }

        int []dis = new int[N];
        for(int i = 0;i<N;i++){
            dis[i] = (int)(1e9);
        }
        // Arrays.fill(dis, Integer.MAX_VALUE);
        dis[src] = 0;
        
        while(!st.isEmpty()){
            int node = st.peek();
            st.pop();

            for(int i = 0;i<adj.get(node).size();i++){
                int v = adj.get(node).get(i).first;
                int wt = adj.get(node).get(i).second;

                if(dis[v] > (dis[node] + wt)){
                    dis[v] = dis[node] + wt;
                }
            }
        }
        for(int i = 0;i<N;i++){
            if(dis[i] == 1e9){
                dis[i] = -1;
            }
        }
        return dis;
    }

    public static void topo(ArrayList<ArrayList<Pair>> adj, int[] vis, int node, Stack<Integer> st ){
        vis[node] = 1;

        for(int i = 0;i<adj.get(node).size();i++){
            int v = adj.get(node).get(i).first;
            if(vis[v] == 0){
                topo(adj, vis, v, st);
            }
        }
        st.add(node);
        return;
    }

    static class Pair{
        int first;
        int second;
        Pair(int _node, int _wt){
            this.first = _node;
            this.second = _wt;
        }
    }
}
