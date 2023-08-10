package Graphs;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class PrimsAlgorithm {
    public static void main(String[] args) {
        // int[][] edges =  {{0, 1, 3},
        //                 {1, 3, 3},
        //                 {1, 5, 10},
        //                 {2, 4, 6},
        //                 {2, 6, 9},
        //                 {3, 6, 8},
        //                 {4, 5, 6}};
        int [][]edges = {{0, 1, 5}};
        int V = 2;
        int ans = Prims(V, edges);
        System.out.println(ans);
    }

    public static int Prims(int V, int [][]edges){
        ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<>();
        for(int i = 0;i<V;i++){ //focus on the number of times loop is running
            adj.add(new ArrayList<ArrayList<Integer>>());
        }

        for(int i = 0;i<edges.length;i++){ //focus on the number of times loop is running
            int u = edges[i][0];
            int v = edges[i][1];
            int wt = edges[i][2];

            ArrayList<Integer> temp1 = new ArrayList<>();
            ArrayList<Integer> temp2 = new ArrayList<>();

            temp1.add(v);
            temp1.add(wt);

            temp2.add(u);
            temp2.add(wt);

            adj.get(u).add(temp1);
            adj.get(v).add(temp2);
        }

        int []vis = new int[V];
        int ans = MST(adj, 0, V, vis);
        return ans;
    }

    public static int MST(ArrayList<ArrayList<ArrayList<Integer>>> adj, int src, int V, int[] vis){
        int sum = 0;
        // ArrayList<Node> list = new ArrayList<>();

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(0, src, -1));
        // vis[src] = 1;

        while(!pq.isEmpty()){
            int wt = pq.peek().first;
            int node = pq.peek().second;
            int parent = pq.peek().third;
            pq.remove();
            
            // if(parent != -1 && vis[node] == 0){
            //     // list.add(new Node(parent, node));
            //     sum += wt;
            // }

            if(vis[node] == 0){
                sum += wt;
                vis[node] = 1;
                for(int i = 0;i<adj.get(node).size();i++){
                    int adWt = adj.get(node).get(i).get(1);
                    int adEd = adj.get(node).get(i).get(0);
                    if(vis[adEd] == 0){
                        pq.add(new Pair(adWt, adEd, node));
                    }
                }
                }
            }
            return sum;
        }
        

    

    // static class Node{
    //     int parent;
    //     int node;
    //     Node(int _parent, int _node){
    //         this.parent = _parent;
    //         this.node = _node;
    //     }
    // }

    static class Pair implements Comparable<Pair>{
        int first;
        int second;
        int third;
        Pair(int _first, int _second, int _third){
            this.first = _first;
            this.second = _second;
            this.third = _third;
        }

        @Override
        public int compareTo(Pair p){
            return this.first - p.first;
        }
    }
}
