package Recursion;

import java.util.Arrays;

public class ContainsDuplicate {
    public static void main(String[] args) {
        int [] nums = {1,2,3,4};
        nums= MergeSort(nums);
        boolean ans = Duplicate(nums);
        System.out.println(ans);
        }
    

    public static int [] MergeSort(int [] arr){
        if(arr.length == 1){
            return arr;
        }

        int m= arr.length/2;

        int left[]= MergeSort(Arrays.copyOfRange(arr,0,m));
        int right[] = MergeSort(Arrays.copyOfRange(arr,m,arr.length));

        int mix[] = Merge(left, right);
        return mix;
    }

    private static int[] Merge(int [] first, int [] second){
        int i=0,j=0,k=0;

        int [] mix=new int[first.length + second.length];
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

        while(i<first.length ){
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

    public static boolean Duplicate(int [] arr){
        for(int i=0; i<arr.length-1;i++){
            if(arr[i]==arr[i+1]){
                return true;
            }
        }
        return false;
    }
}
