package Hashing;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
        
    }

    public static int[] twoSum(int []nums, int target){
        int []ans = new int[2];
        ans = sum(nums, target);
        return ans;
    }

    public static int[] sum(int []arr, int target){
        Map<Integer, Integer> map = new HashMap<>();
        int [] ans = new int[2];
        for(int i = 0;i<arr.length;i++){
            if(map.containsKey(target - arr[i])){
                ans[0] = map.get(target - arr[i]);
                ans[1] = i;
            }
            map.put(arr[i], i);
        }
        return ans;
    }
}
