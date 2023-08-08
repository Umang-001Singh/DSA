package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class DetectCycleInDirectedGraphsKahnsAlgorithm {
    public static void main(String[] args) {
        
    }

    public static boolean kahns(ArrayList<ArrayList<Integer>> adj, int V){
        boolean ans = toposort(adj, V);
        return ans;
    }

    public static boolean toposort(ArrayList<ArrayList<Integer>> adj, int V){
        int []indeg = new int[V];
        for(int i = 0;i<V;i++){
            for(int it: adj.get(i)){
                indeg[it]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i = 0;i<V;i++){
            if(indeg[i] == 0){
                q.add(i);
            }
        }

        ArrayList<Integer> ans = new ArrayList<>();
        while(!q.isEmpty()){
            int node = q.poll();
            ans.add(node);

            for(int it: adj.get(node)){
                indeg[it]--;
                if(indeg[it] == 0){
                    q.add(it);
                }
            }
        }

        if(ans.size() == V-1){
            return false;
        }
        return true;
    }
}
