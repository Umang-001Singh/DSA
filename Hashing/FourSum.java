package Hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
    public static void main(String[] args) {
        int []nums = //{4, 3, 3, 4, 4, 2, 1, 2, 1, 1};
        {1000000000,1000000000,1000000000,1000000000};
        int target = -294967296;
        List<List<Integer>> ans = new ArrayList<>();
        ans = sum(nums, target);
        System.out.println(ans);
    }

    public static List<List<Integer>> sum(int []nums, int target){
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        ans = fourSum(nums, target);
        return ans;
    }

    public static List<List<Integer>> fourSum(int []arr, int target){
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 0;i<arr.length;i++){
            // if (i > 0 && arr[i] == arr[i - 1]){ 
            //     continue;
            // }
            for(int j = i+1;j<arr.length;j++){
                // if (j > i + 1 && arr[j] == arr[j - 1]){
                //     continue;
                // }
                int front = j+1;
                int back = arr.length-1;
                while(front<back){
                    // long sum = arr[i];
                    // sum += arr[j];
                    // sum += arr[front];
                    // sum += arr[back];
                    long sum = (long)arr[i] + (long)arr[j] + (long)arr[front] + (long)arr[back];
                    if(sum < target){
                        front++;
                    }
                    else if(sum > target){
                        back--;
                    }
                    else{
                        ArrayList<Integer> list = new ArrayList<>();
                        list.add(arr[i]);
                        list.add(arr[j]);
                        list.add(arr[back]);
                        list.add(arr[front]);
                        ans.add(list);
                        front++;
                        back--;

                        while(front<back && arr[front] == arr[front-1]){
                            front++;
                        }
                        while(front<back && arr[back] == arr[back+1]){
                            back--;
                        }
                    }
                }
                while(j<arr.length-1 && arr[j] == arr[j+1]){
                    j++;
                }
            }
            while(i<arr.length-1 && arr[i] == arr[i+1]){
                i++;
            }
        }
        return ans;
    }
}
