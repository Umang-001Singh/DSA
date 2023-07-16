package Heaps.PriorityQueues;


import java.util.Arrays;

public class HeapSort {
    public static void main(String[] args) {
        int []arr = {1,2,4,5,3};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    //THIS CODE IS SORTING IN ASCENDING ORDER
    // public static void heapSort(int []arr){
    //     for (int i = arr.length/2; i >= 0; i--) {
    //         Heapify(arr, i, arr.length);
    //     }

    //     int n = arr.length;
    //     for(int i = n-1;i>=0;i--){
    //         int temp = arr[0];
    //         arr[0] = arr[i];
    //         arr[i] = temp;

    //         Heapify(arr,0, i);
    //     }

    // }

    // public static void Heapify(int []arr, int i, int size){
    //     int left = 2*i + 1;
    //     int right = 2*i + 2;
    //     int maxId = i;

    //     if(left < size && arr[maxId] <arr[left]){
    //         maxId = left;
    //     }

    //     if(right < size && arr[maxId] < arr[right]){
    //         maxId = right;
    //     }
        
    //     if(maxId != i){
    //         int temp = arr[maxId];
    //         arr[maxId] = arr[i];
    //         arr[i] = temp;

    //         Heapify(arr, maxId, size);
    //     }

    // }

    //THIS CODE IS FOR SORTING IN DESCENDING ORDER
    public static void heapSort(int []arr){
        int n = arr.length;
        for (int i = n/2; i >=0; i--) {
            Heapify(arr, i ,n); //TIME COMPLEXITY OF THIS LOOP: O(n/2*logn) = o(n*logn)
        }

        //swap first and last numbers
        for(int i = n-1;i>=0;i--){ //TIME COMPLEXITY OF THIS LOOP: O(n*logn)
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            Heapify(arr, 0, i); //FINAL TIME COMPLEXITY = O(2*n*logn) = O(n*logn)
        }
    }

    public static void Heapify(int []arr, int i, int size){
        int left = 2*i + 1;
        int right = 2*i + 2;
        int minId = i;

        if(left < size && arr[left]< arr[minId]){
            minId = left;
        }

        if(right < size && arr[right] < arr[minId]){
            minId = right;
        }

        if(minId != i){
            //SWAP
            int temp =arr[i];
            arr[i] = arr[minId];
            arr[minId] = temp;

            Heapify(arr, minId, size);
        }
    }
}
