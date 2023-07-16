package Recursion;

import java.util.ArrayList;

public class MergeIntervals {
    public static void main(String[] args) {
        int [][] nums={{-5,2},{1,5}};
        ArrayList<ArrayList<Integer>> ans=merge(nums);
        System.out.println(ans);
    }

    public static ArrayList<ArrayList<Integer>> merge(int arr[][]){
        ArrayList<ArrayList<Integer>> list= new ArrayList<ArrayList<Integer>>();
        for(int i=0;i<arr.length;i++){
            ArrayList<Integer> list1 = new ArrayList<>();
            if(  i<arr.length-1 && arr[i][arr[i].length-1]>=arr[i+1][0]){
                list1.add(arr[i][0]);
                list1.add(arr[i+1][arr[i+1].length-1]);
                i++;
            }
            else{
                list1.add(arr[i][0]);
                list1.add(arr[i][arr[i].length-1]);
            }
            list.add(list1);
        }
        return list;
    }

    // private static int[][] shorten(int [][] arr,int x){
    //     for(int j=x;j<arr.length-1;j++){
    //         arr[j][0]=arr[j+1][0];
    //         arr[j][arr[j].length-1]=arr[j+1][arr[j+1].length-1];
    //     }
    //     return arr;
    // }
}
