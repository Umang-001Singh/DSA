package Recursion;

import java.util.Arrays;

public class SortArrayByParity {
    public static void main(String[] args) {
        int [] nums = {44,206,210,354,898,1198,1642,1718,1862,1974,2016,2074,2370,
            2390,2690,2742,2792,2936,3498,3562,3674,3746,3948,4514,4544,4550,2615,
            4882,4910,2395,2133,3103,3201,3277,3405,1691,3507,1667,3593,1509,1467,
            1447,4205,1039,819,755,4693,4733,497,241};
        int [] ans = Sort(nums);
        System.out.println(Arrays.toString(ans));
    }

    public static int[] Sort(int []arr){
        Arrays.sort(arr);
        int[] mix=Parity(arr);
        return mix;
    }

    private static int[] Parity(int [] arr){
        
        for(int i=0;i<=arr.length-1;i++){
            if(arr[i]%2!=0){
                for(int j=arr.length-1;j>i;j--){
                    if(arr[j]%2==0){
                        int temp=arr[i];
                        arr[i]=arr[j];
                        arr[j]=temp; 
                    }
                }
            }
        }
        return arr;
    }
}
