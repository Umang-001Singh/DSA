package Graphs;

import java.util.*;

public class Representation {
    public static void main(String[] args) {
        int n = 3, m = 3;
        int adj[][] = new int[n+1][n+1];

        //edge 1--2
        adj[1][2] = 1;
        adj[2][1] = 1;

        //edge 2--3
        adj[2][3] = 1;
        adj[3][2] = 1;

        //edge 1--3
        adj[1][3] = 1;
        adj[3][1] = 1;

        //using adjcency list
        ArrayList<Pair<Integer, Integer>> list = new Pair<Integer, Integer>();
        for(int i = 0;i<=n;i++){
            list.add(new ArrayList<>());
        }

        // list.get(1).add(2);
        // list.get(2).add(1);

        // list.get(2).add(3);
        // list.get(3).add(2);

        // list.get(1).add(3);
        // list.get(3).add(1);

        //printing all the edges

        // for(int i = 0;i<=n;i++){
        //     for(int j = 0;j<list.get(i).size();j++){
        //         System.out.print(list.get(i).get(j) + " ");
        //     }
        //     System.out.println();
        // }

        //for directed graphs
        list.get(1).add(2);
        list.get(2).add(3);
        list.get(1).add(3);
    }
}
