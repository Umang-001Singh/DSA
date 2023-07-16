package Recursion;

import java.util.ArrayList;
import java.util.List;

public class IterativeSubSetWithDuplicate {
    public static void main(String[] args) {
        int [] arr = {1,2,3}; //arr = {1,2,2}; COMMENTED CODE IS FOR DUPLICATE 
        List<List<Integer>> ans = SubSeq(arr);  //WITHOUT COMMENTED CODE IS FOR NON-DUPLICATE
        System.out.println(ans);   
    }

    public static List<List<Integer>> SubSeq(int [] arr){
        List<List<Integer>> outer = new ArrayList<>();
        outer.add(new ArrayList<>());

        // int start =0;
        // int end =0;
        for(int i=0;i<arr.length;i++){
            // start =0;
            // if(i>0 && arr[i]==arr[i-1]){
            //     start = end +1;
            // }
            // end = outer.size()-1;
            int n = outer.size();
            for(int j = 0; j< n;j++){
                List<Integer> inner = new ArrayList<>(outer.get(j));
                inner.add(arr[i]);
                outer.add(inner);
            }
        }
        return outer;
    }
}
