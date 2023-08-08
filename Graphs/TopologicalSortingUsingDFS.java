package Graphs;

import java.util.ArrayList;
import java.util.Stack;

public class TopologicalSortingUsingDFS {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
    }

    public static int[] topoSort(ArrayList<ArrayList<Integer>> adj, int V){
        int []vis = new int[V];
        Stack<Integer> st = new Stack<>();
        for(int i = 0;i<V;i++){
            if(vis[i] == 0){
                dfs(adj, vis, i, st);
            }
        }
        int []ans = new int[st.size()];
        int i = 0;
        while(!st.isEmpty()){
            ans[i++] = st.pop();
        }
        return ans;
    }

    public static void dfs(ArrayList<ArrayList<Integer>> adj, int []vis, int node, Stack<Integer> st){
        vis[node] = 1;
        st.push(node);

        for(int it: adj.get(node)){
            if(vis[it] == 0){
                dfs(adj, vis, it, st);
            }
        }
        return;
    }
}
