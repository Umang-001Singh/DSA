package Arrays;

import java.util.ArrayList;

public class FactorsOptimised {
    public static void main(String[] args) {
        factors(20);
    }

    static void factors(int n){
        double x= n;
        ArrayList<Integer> list= new ArrayList<Integer>(5);
        for(int i=1;i<=Math.sqrt(x);i++){
            if(n%i==0){
                if(n/i==i){
                    System.out.print(i+" ");
                }
                else{
                    System.out.print(i+" ");
                    list.add(n/i);
                }
            }
        }

        for(int i=list.size()-1;i>=0;i--){
            System.out.print(list.get(i)+" ");
        }
    }
}
