package Recursion;

import java.util.ArrayList;

public class ReturnList {
    public static void main(String [] args){
        int [] arr={1,2,3,4,4,5};
        ArrayList<Integer> list=new ArrayList<Integer>();        // 2nd Method
        ArrayList<Integer> ans=Search(arr,4,0,list); // ArrayList<Integer> ans= Search(arr, target, 0,
        System.out.println(ans);                                 // new ArrayList<>());

    }

    static ArrayList<Integer> Search(int [] arr, int target, int index, ArrayList<Integer> list){
        if(index==arr.length){
            return list;
        }
        if(arr[index]==target){
            list.add(index);
        }
        return Search(arr, target, index+1,list);
    }
}
