package Recursion;

import java.util.Arrays;

public class MergeSortInPlace2 {
    public static void main(String[] args) {
        int [] arr={5,4,3,2,1};
        mergeInPlace(arr, 0, arr.length);
        System.out.println(Arrays.toString(arr));
    }

    public static void mergeInPlace(int [] arr, int s, int e){
        if(e-s==1){
            return;
        }

        int m=(s+e)/2;
        mergeInPlace(arr, s, m);
        mergeInPlace(arr, m, e);

        Merge( arr, s, m, e);

    }

    private static void Merge(int [] arr, int s, int m, int e){
        int [] mix = new int [e-s];
        int i=s,j=m;
        int k=0;


        while(i<m && j<e){
            if(arr[i]<arr[j]){
                mix[k] = arr[i];
                i++;
            }
            else{
                mix[k]=arr[j];
                j++;
            }
            k++;
        }

        while(i<m){
            mix[k]=arr[i];
            i++;
            k++;
        }

        while(j<e){
            mix[k]=arr[j];
            j++;
            k++;
        }

        for(int l=0;l<mix.length;l++){
            arr[s+l]=mix[l];
        }
    }
}