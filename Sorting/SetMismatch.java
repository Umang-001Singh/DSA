package Sorting;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class SetMismatch {
    public static void main(String []args){
    int [] arr={1,1};
    ArrayList<Integer> finalans=new ArrayList<Integer>(5);
    finalans=Mismatch(arr);
        System.out.println(finalans);
    }

    static ArrayList<Integer> Mismatch(int [] arr){
        int i=0;
        while(i<arr.length){
            int correct=arr[i]-1;
            if(arr[i]!=arr[correct]){
                swap(arr, i ,correct);
            }
            else{
                i++;
            }
        }

        ArrayList<Integer> ans=new ArrayList<Integer>(5);
        for(int j=0;j<arr.length;j++){
            if(arr[j]!=(j+1)){
                ans.add(arr[j]);
                ans.add(j+1);
            }
        }
        return ans;
    }

    static void swap(int []arr, int first, int last){
        int temp=arr[first];
        arr[first]=arr[last];
        arr[last]=temp;
    }
}
