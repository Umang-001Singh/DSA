package Recursion;

import java.lang.reflect.Array;
import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
    int [] arr={4,3,2,1,8,19};
    selection(arr, 0, arr.length-1,0); // selection(arr, 0 , arr.length, 0);
    System.out.println(Arrays.toString(arr));
    }

    static void selection(int [] arr,int f, int l, int max){
        if(l==0){
            return;
        }

        if(f<=l) { //if(f<l){
            if (arr[f] > arr[max]) {
                selection(arr, f + 1, l, f);
            } else {
                selection(arr, f + 1, l, max);
            }
        }
        else{
            //swap
            int temp=arr[max];
            arr[max]=arr[l];  //arr[max]=arr[l-1];
            arr[l]=temp;      //arr[l-1]=arr[max];
            selection(arr,0,l-1,0);

        }

    }
}

