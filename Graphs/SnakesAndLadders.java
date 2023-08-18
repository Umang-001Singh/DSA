package Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class SnakesAndLadders {
    public static void main(String[] args) {
        int N =8;
        int[] arr = {3, 22, 5, 8, 11, 26, 20, 29, 
            17, 4, 19, 7, 27, 1, 21, 9};
        ArrayList<Integer> ans = snakeAndLadder(arr, N);
        System.out.println(ans);
    }

    public static ArrayList<Integer> snakeAndLadder(int[] arr, int N){
        int[] matrix = new int[30];
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i<arr.length;i+=2){
            map.put(arr[i], arr[i+1]);
        }
        System.out.println(map);
        for(int i = 0;i<30;i++){
            if(map.containsKey(i+1)){
                matrix[i] = map.get(i+1)-1;
            }
            else{
                matrix[i] = -1;
            }
        }
        System.out.println(Arrays.toString(matrix));
        ArrayList<Integer> ans = minThrow(30, matrix);
        return ans;
    }

    public static ArrayList<Integer> minThrow(int N, int[] matrix){
        int[] visited = new int[matrix.length];
        System.out.println(Arrays.toString(visited));
        qEntry qe = new qEntry();
        qe.ver = 0;
        qe.dis = 0;
        qe.snakes = 0;
        qe.ladders = 0;
        visited[0] = 1;
        System.out.println(Arrays.toString(visited));
        Queue<qEntry> q = new LinkedList<>();
        q.add(qe);
        
        while(!q.isEmpty()){
            qe = q.poll();
            System.out.println(qe.ver);
            System.out.println(qe.dis);
            int v = qe.ver;
            // q.remove();
            if(qe.ver == N-1){
                break;
            }

            for(int i = v+1;i<=v+6 && i<=N-1;i++){
                
                if(visited[i] == 0){
                    qEntry a =new qEntry();

                    visited[i] = 1;
                    System.out.println(Arrays.toString(visited));
                    a.dis = qe.dis + 1;
                    if(matrix[i] != -1){
                        if(matrix[i] > i){
                            a.ladders = qe.ladders + 1;
                        }
                        else{
                            a.snakes = qe.snakes + 1;
                        }
                        a.ver = matrix[i];
                    }
                    else{
                        a.ladders = qe.ladders;
                        a.snakes = qe.snakes;
                        a.ver = i;
                    }
                    
                    q.add(a);
                }
            }
        }
        ArrayList<Integer> list = new ArrayList<>();
        list.add(qe.dis);
        list.add(qe.ladders);
        list.add(qe.snakes);
        return list;
    }

    static class qEntry{
        int ver;
        int dis;
        int ladders;
        int snakes;
    }
}
