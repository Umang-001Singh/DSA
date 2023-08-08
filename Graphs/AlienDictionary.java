package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class AlienDictionary {
    public static void main(String[] args) {
        String []dict = {"baa",
                        "abcd",
                        "abca",
                        "cab",
                        "cad"};
        String ans = dictionary(dict, 5, 4);
        System.out.println(ans);
    }

    public static String dictionary(String []dict, int n, int k){
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0;i<k;i++){
            adj.add(new ArrayList<>());
        }

        for(int i = 0;i<n-1;i++){
            String first = dict[i];
            String second = dict[i+1];
            int len = Math.min(first.length(), second.length());

            for(int j = 0;j<len;j++){
                if(first.charAt(j) != second.charAt(j)){
                    adj.get(first.charAt(j) - 'a').add(second.charAt(j) - 'a');
                    break;
                }
                
            }
        }

        String ans = toposort(adj, n, k);
        return ans;
    }

    public static String toposort(ArrayList<ArrayList<Integer>> adj, int n, int k){
        int []indeg = new int[k];

        for(int i = 0;i<k;i++){
            for(int it: adj.get(i)){
                indeg[it]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();

        for(int i = 0;i<indeg.length;i++){
            if(indeg[i] == 0){
                q.add(i);
            }
        }

        ArrayList<Integer> list = new ArrayList<>();
        while(!q.isEmpty()){
            int node = q.poll();
            list.add(node);

            for(int it: adj.get(node)){
                indeg[it]--;
                if(indeg[it] == 0){
                    q.add(it);
                }
            }
        }

        String ans = "";
        for(int i = 0;i<list.size();i++){
            int num = list.get(i) + 'a';
            char temp = (char)num;
            ans = ans + temp;
        }
        return ans;
    }
}
