package Hashing;

import java.util.HashMap;

public class LongestSubarrayWithSumK {
    public static void main(String[] args) {
        int []arr = {-7, 17, -12, 2, 11, -1, 4, 11, -18};
        int ans = lenOfSubarr(arr, arr.length, 25);
        System.out.println(ans);
    }

    public static int lenOfSubarr(int[] A, int N, int K){
        int ans = longest(A, K);
        return ans;
    }

    public static int longest(int []arr, int K){
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int count = 0;
        int max = 0;
        for(int i = 0;i<arr.length;i++){
            sum += arr[i];
            count = 0;
            
            if(sum == K){
                count = i+1;
            }

            else if(map.containsKey(sum - K)){
                int temp = map.get(sum - K);
                count = i - temp;
            }
            
            if(!map.containsKey(sum)){
                map.put(sum, i);
            }
            max = Math.max(max, count);
        }
        return max;
    }
}
