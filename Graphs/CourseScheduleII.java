package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CourseScheduleII {
    public static void main(String[] args) {
        
    }

    static int[] course(int n, int m, ArrayList<ArrayList<Integer>> prerequisites) 
    {
        int []ans = new int[n];
        ans = toposort(prerequisites, n);
        return ans;
    }

    public static int[] toposort(ArrayList<ArrayList<Integer>> pre, int V){
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for(int i = 0;i<pre.size();i++){
            adj.get(pre.get(i).get(1)).add(pre.get(i).get(0));
        }

        Queue<Integer> q = new LinkedList<>();
        int []indeg = new int[V];

        for(int i = 0;i<V;i++){
            for(int it: adj.get(i)){
                indeg[it]++;
            }
        }

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
        
        if(ans.size() == V){
            int []arr = new int[V];
            for(int i = 0;i<V;i++){
                arr[i] = ans.get(i);
            }
            return arr;
        }
        int []arr1 = {};
        return arr1;
    }
}
