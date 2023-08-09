package Graphs;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class BellmanFordAlogrithm {
    public static void main(String[] args) {
        
    }

    public static int[] shortest(ArrayList<ArrayList<Integer>> edges, int V, int S){
        int []dis = new int[V];
        for(int i = 0;i<V;i++){
            dis[i] = (int)1e8;
        }
        int []ans = new int[V];
        ans = bellmanford(edges, dis, S);
        return ans;
    }

    public static int[] bellmanford(ArrayList<ArrayList<Integer>> adj, int[] dis, int S){
        dis[S] = 0;

        for(int i = 0;i<dis.length-1;i++){
            for(ArrayList<Integer> it: adj){
                int parent = it.get(0);
                int node = it.get(1);
                int wt = it.get(2);

                if(dis[node] > dis[parent] + wt){
                    dis[node] = dis[parent] + wt;
                }
            }
        }

        //for Nth iteration to check for negative cycle
        for(ArrayList<Integer> it: adj){
            int parent = it.get(0);
            int node = it.get(1);
            int wt = it.get(2);

            if(dis[node] > dis[parent] + wt){
                int[] temp = new int[1];
                Arrays.fill(temp, -1);
                return temp; 
            }
        }
        return dis;
    }
}
