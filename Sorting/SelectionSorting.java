package Sorting;

import java.util.Arrays;

public class SelectionSorting {
    public static void main(String [] args){
        int []arr={3,5,2,4,1};
        SelectSort(arr);
        System.out.println(Arrays.toString(arr));

    }

    static void SelectSort(int [] arr){

        int maxIndex=0;
        for(int i=0;i<=arr.length-1;i++){
            maxIndex= getMax(arr, 0 , arr.length-1-i);
            swap(arr, maxIndex, arr.length-1-i);

        }
    }

    static int getMax(int [] nums,int start, int end ){
        int max=start;
        for(int i=start;i<=end;i++){
            if(nums[i]>nums[max]){
                max=i;
            }
        }
        return max;
    }

    static void swap(int [] arr, int maxIndex,int last ){
        int temp=arr[last];
         arr[last]=arr[maxIndex];
         arr[maxIndex]=temp;
    }
}
