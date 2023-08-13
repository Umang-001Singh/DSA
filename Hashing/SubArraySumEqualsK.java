package Hashing;

import java.util.HashMap;

public class SubArraySumEqualsK {
    public static void main(String[] args) {
        int []arr = {0, 0, 5, 5, 0, 0};
        int ans = subarraySum(arr, 0);
        System.out.println(ans);
    }

    public static int subarraySum(int []nums, int k){
        int ans = Sum(nums, k);
        return ans;
    }

    public static int Sum(int []arr, int k){
        HashMap<Integer, Integer> map = new HashMap<>();

        int count = 0;
        int sum = 0;
        map.put(0, 1);
        for(int i = 0;i<arr.length;i++){
            sum += arr[i];
            if(map.containsKey(sum - k)){
                count += map.get(sum - k);
                if(map.containsKey(sum)){
                    int get = map.get(sum);
                    map.put(sum, ++get);
                }
                else{
                    map.put(sum, 1);
                }
            }
            else if(sum == k){
                count++;
                if(map.containsKey(sum)){
                    int get = map.get(sum);
                    map.put(sum, ++get);
                }
                else{
                    map.put(sum, 1);
                }
            }
            
            else{
                if(map.containsKey(sum)){
                    int get = map.get(sum);
                    map.put(sum, ++get);
                }
                else{
                    map.put(sum, 1);
                }
            }
        }
        return count;
    }
}
