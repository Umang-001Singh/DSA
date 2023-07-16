package Recursion;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int [] arr= {5,4,3,2,1};
        int [] ans=Mergesort(arr);
        System.out.println(Arrays.toString(ans));
    }

    public static int[] Mergesort(int [] arr){
        if(arr.length==1){
            return arr;
        }

        int m=arr.length/2;

        int [] left = Mergesort(Arrays.copyOfRange(arr, 0,m));
        int [] right = Mergesort(Arrays.copyOfRange(arr, m, arr.length));

        int [] mixed = Merge(left, right);

        return mixed;
    }

    private static int[] Merge(int [] first, int [] second){
        int i=0,j=0;
        int k=0;
        int [] mix = new int[first.length + second.length];

        while(i<first.length && j<second.length){
            if(first[i]<second[j]){
                mix[k]=first[i];
                i++;
            }
            else{
                mix[k]=second[j];
                j++;
            }
            k++;
        }

        while(i<first.length){
            mix[k]=first[i];
            i++;
            k++;
        }

        while(j<second.length){
            mix[k]=second[j];
            j++;
            k++;
        }
        return mix;
    }
    
}
