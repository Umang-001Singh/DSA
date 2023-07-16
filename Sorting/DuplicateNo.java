package Sorting;

public class DuplicateNo {
    public static void main(String[] args) {
        int []arr={1,3,3};
        System.out.println(Duplicate(arr));


    }

    static int Duplicate(int[] arr) {
        int i = 0;
        while (i < arr.length) {
            int correct = arr[i] - 1;
            if (arr[i] != arr[correct]) {
                swap(arr, i, correct);
            } else {
                i++;
            }
        }
        int ans = 0;
        for (int j = 0; j < arr.length; j++) {
            if (arr[j] != j + 1) {
                ans = arr[j];
            }
        }
        return ans;
    }

    static void swap(int []arr, int first, int last){
        int temp=arr[first];
        arr[first]=arr[last];
        arr[last]=temp;
    }
}
