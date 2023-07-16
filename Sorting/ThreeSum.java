package Sorting;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public static void main(String [] args){
        int []arr={-1,0,1,2,-1,4};
        ArrayList<ArrayList<Integer>> ans=new ArrayList<ArrayList<Integer>>();
        ans=threeSum(arr);
        System.out.println(ans);
    }

    static ArrayList<ArrayList<Integer>> threeSum(int [] arr){
        for(int i=0;i<arr.length-2;i++){
            for(int j=i;j>0;j--){
                if(arr[j]<arr[j-1]){
                    swap(arr,j,j-1);
                }
                else{
                    break;
                }
            }
        }

        ArrayList<ArrayList<Integer>> x=new ArrayList<ArrayList<Integer>>(5);
        //Two pointer method
        for(int i=0;i<arr.length-2;i++){
            for(int j=i+1;j<arr.length-1;j++){
                int k=arr.length-1;
                while(j<k){
                    if(arr[i]+arr[j]+arr[k]==0){
                        x.add(new ArrayList<Integer>(Arrays.asList(arr[i],arr[j],arr[k])));
                    }
                    k--;
                }
            }
        }
        return x;
    }

    static void swap(int []arr, int first, int second){
        int temp=arr[first];
        arr[first]=arr[second];
        arr[second]=temp;
    }
}
