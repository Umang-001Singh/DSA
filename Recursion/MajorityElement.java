package Recursion;

import java.util.Arrays;

public class MajorityElement {
    public static void main(String[] args) {
        int [] nums={1};
        int [] ans =MergeSort(nums);
        int  fans = Largest(ans);
        System.out.println(fans);
    }

    public static int[] MergeSort(int [] arr){
        if(arr.length==1){
            return arr;
        }

        int m=arr.length/2;

        int left[]= MergeSort(Arrays.copyOfRange(arr, 0, m));
        int right[]=MergeSort(Arrays.copyOfRange(arr, m, arr.length));

        int mix[] = Merge(left, right);
        return mix;
     }

     private static int[] Merge(int [] first, int [] second){
        int i=0,j=0,k=0;

        int [] mix= new int[first.length +second.length];
        while(i<first.length && j<second.length){
            if(first[i]>second[j]){
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

    public static int Largest(int []arr){
        if((arr.length ==1 ) || (arr.length == 2)) {
            return arr[0];
        }

        else if ( arr.length %2 ==0){
            if(arr[arr.length/2]==arr[arr.length/2 + 1]){
                return arr[arr.length/2 + 1];
            }
            else{
                return arr[arr.length/2 - 1];
            }
        }
        else{
            return arr[arr.length/2];
        }
        
    } 
}
