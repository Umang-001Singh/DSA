package Graphs.Practise;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Bfs {
    public static void main(String[] args) {
        int V = 8;
        int E = 8;
        int[] s = {1, 1, 2, 2, 6, 6, 4 ,7};
        int[] e = {2, 6, 3, 4, 7, 8, 5, 5};
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0;i<V+1; i++){
            adj.add(new ArrayList<>());
        }

        for(int i = 0;i<E;i++){
            int start = s[i];
            int end = e[i];
            adj.get(start).add(end);
            adj.get(end).add(start);
        }

        System.out.println(adj);
        breadth(adj, V, E);
    }

    public static void breadth(ArrayList<ArrayList<Integer>> adj, int v, int e){
        ArrayList<Integer> bfs = new ArrayList<>();
        int[] vis = new int[v+1];
        Queue<Integer> q = new LinkedList<>();
        vis[6] = 1;
        q.add(6);

        while(!q.isEmpty()){
            int ver = q.poll();
            bfs.add(ver);

            for(Integer it: adj.get(ver)){
                if(vis[it] == 0){
                    vis[it] = 1;
                    q.add(it);
                }
            }
        }
        System.out.println(bfs);
    }
}
