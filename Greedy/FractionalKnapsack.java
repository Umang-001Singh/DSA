package Greedy;

import java.util.Comparator;
import java.util.PriorityQueue;

public class FractionalKnapsack {
    public static void main(String[] args) {
        int []val = {60, 100, 120};
        int []weight = {10, 20, 30};
        double ans = knapsack(50, val, weight, 3);
        // double ans = (2/3 * 120);
        System.out.println(ans);
    }

    public static double knapsack(int W, int []val, int[] weight, int n){
        double ans = fractional(W, val, weight);
        return ans;
    }

    public static double fractional(int W, int []val, int []weight){
        double value = 0;
        int remWt = W;
        PriorityQueue<Member> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for(int i = 0;i<val.length;i++){
            int v = val[i];
            int w = weight[i];
            double vperwt = v/w;
            pq.add(new Member(vperwt, v, w));
        }

        while(!pq.isEmpty()){
            int v = pq.peek().value;
            int wt = pq.peek().wt;
            pq.remove();

            if(remWt >= wt){
                value = value + v;
                remWt = remWt - wt;
            }
            else{
                
                double frac = (v/wt * remWt);
                value = value + frac;
                remWt = 0;
            }
        }
        return value;
    }

    // class Item {
    //     int value, weight;
    //     Item(int x, int y){
    //         this.value = x;
    //         this.weight = y;
    //     }
    // }

    static class Member implements Comparable<Member>{
        double vperwt;
        int value;
        int wt;

        Member(double _vperwt, int _value, int _wt){
            this.vperwt = _vperwt;
            this.value = _value;
            this.wt= _wt;
        }

        @Override
        public int compareTo(Member p){
            return Double.compare(this.vperwt, p.vperwt);
        }
    }
}
