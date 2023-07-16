package Sorting;

import java.util.ArrayList;
import java.util.List;

public class DissapearingNo {
    public static void main(String []args){
        int []arr={4,3,2,7,8,2,3,1};
        ArrayList<Integer> farr=new ArrayList<Integer>(5);
        farr=Disappearing(arr);
        System.out.println(farr);
    }

    static ArrayList<Integer> Disappearing(int [] arr){
            int i=0;
            while(i<arr.length){
            int correct=arr[i]-1;
            if(arr[i]!=arr[correct]){
                swap(arr,i,correct);
            }
            else{
                i++;
            }
        }

        ArrayList<Integer> arrLi= new ArrayList<Integer>(5);

        for(int j=0;j<arr.length;j++){
            if(arr[j]!=(j+1)){
                arrLi.add(j+1);
            }
        }
    return arrLi;
    }

    static void swap(int []arr,int first,int last){

            int temp=arr[first];
            arr[first]=arr[last];
            arr[last]=temp;
        }

}
