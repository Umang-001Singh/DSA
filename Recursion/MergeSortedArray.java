package Recursion;

import java.util.Arrays;

public class MergeSortedArray {
    public static void main(String[] args) {
        int [] num1={0};
        int [] num2={1};
        num1 = Merge(num1, 0, num2, 1);
        // num1= MergeTwoPointer(num1,0, num2,1);
        System.out.println(Arrays.toString(num1));

    }

    public static int[] Merge(int [] nums1, int m, int [] nums2, int n){
        int k=m+n;
        int x=0;
        int y=0;
        int [] mix=new int[k];
        for(int i=0;i<k;i++){
            if(i<m){
                mix[i]=nums1[x];
                x++;
            }
            else{
                mix[i]=nums2[y];
                y++;
            }
        }

        nums1 = MergeSort(mix);
        return nums1;
    }

    public static int[] MergeSort(int [] arr){
        if(arr.length == 1){
            return arr;
        }

        int m=arr.length/2;

        int left[] = MergeSort(Arrays.copyOfRange(arr, 0, m));
        int right[] = MergeSort(Arrays.copyOfRange(arr, m, arr.length));

        int mix[] = MergeSorted(left,right);
        // System.out.println(Arrays.toString(mix));
        return mix;
    }

    private static int[] MergeSorted(int [] first, int [] second){
        int i=0,j=0,k=0;
        int mix[]= new int [first.length+second.length];

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

    // USING TWO POINTER APPROACH

    // public static int[] MergeTwoPointer(int [] nums1, int m, int[] nums2, int n){
    //     int i=m-1;
    //     int j=n-1;
    //     int k=m+n-1;

    //     while( j>=0){
    //         if(i>=0 && nums1[i]>nums2[j]){
    //             nums1[k]=nums1[i];
    //             i--;
    //         }
    //         else{
    //             nums1[k]=nums2[j];
    //             j--;
    //         }
    //         k--;
    //     }
    
    //     return nums1;
    // }
}
