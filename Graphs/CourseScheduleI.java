package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CourseScheduleI {
    public static void main(String[] args) {
        int [][]pre = {{1,0},
                        {2, 1},
                        {3, 2}};
        boolean ans = course(pre, 4);
        System.out.println(ans);
    }

    public static boolean course(int [][]pre, int V){
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for(int i = 0;i<pre.length;i++){
            adj.get(pre[i][0]).add(pre[i][1]);
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
            return true;
        }
        return false;
    }
}
