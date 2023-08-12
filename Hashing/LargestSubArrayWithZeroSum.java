package Hashing;

import java.util.HashMap;

public class LargestSubArrayWithZeroSum {
    public static void main(String[] args) {
        int []arr = {1, -1, 3, 2, -2, -8, 1, 7, 10, 23};
        int ans = maxLen(arr, arr.length);
        System.out.println(ans);
    }

    public static int maxLen(int []arr, int n){
        int ans = sum(arr);
        return ans;
    }

    public static int sum(int []arr){
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        int count = 0;
        int sum = 0;
        int max = 0;
        for(int i = 0;i<arr.length;i++){
            count = 0;
                sum = sum + arr[i];
                if(sum == 0){
                    count = i + 1;
                }
                else if(map.containsKey(sum)){
                    count = i - map.get(sum);
                }
                else{
                    map.put(sum, i);
                }
                max = Math.max(max, count);
            }
        return max;
    }
}