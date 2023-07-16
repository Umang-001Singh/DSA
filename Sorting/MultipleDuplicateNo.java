package Sorting;

import javax.lang.model.type.IntersectionType;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class MultipleDuplicateNo {
    public static void main(String [] args){
        int [] arr={4,3,2,7,8,2,3,1};
        ArrayList<Integer> ansfinal=new ArrayList<Integer>(5);
        ansfinal=Duplicate(arr);
        System.out.println(ansfinal);
    }

    static ArrayList<Integer> Duplicate(int []arr){
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

        ArrayList<Integer> ans=new ArrayList<Integer>(5);

        for(int j=0;j<arr.length;j++){
            if(arr[j]!=(j+1)){
                ans.add(arr[j]);
            }
        }
        return ans;
    }

    static void swap(int []arr, int first,int last){
        int temp=arr[last];
        arr[last]=arr[first];
        arr[first]=temp;
    }
}
