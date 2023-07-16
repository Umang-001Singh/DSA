package Recursion;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
    int []arr={4,3,2,1};
    bubble(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    static void bubble(int [] arr, int f, int l){
        if(l==0){
            return;
        }

        if(f<l){
            if(arr[f]>arr[f+1]){
                //swap
                int temp=arr[f];
                arr[f]=arr[f+1];
                arr[f+1]=temp;
            }
            bubble(arr,f+1, l);
        }
        else{
            bubble(arr,0,l-1);
        }
    }
 }
