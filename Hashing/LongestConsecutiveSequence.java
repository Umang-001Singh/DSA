package Hashing;

import java.util.HashSet;

public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        int []nums = {100, 4, 200, 1, 3, 2};
        int ans = longestConsecutive(nums);
        System.out.println(ans);
    }

    public static int longestConsecutive(int []nums){
        int ans = longest(nums);
        return ans;
    }

    public static int longest(int []arr){
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0;i<arr.length;i++){
            set.add(arr[i]);
        }

        int count = 0;
        int length = 0;
        for(int i = 0;i<arr.length;i++){
            if(set.contains(arr[i] - 1)){
                continue;
            }
            else{
                count = 0;
                count++;
                int val = arr[i];
                while(set.contains(val + 1)){
                    val = val + 1;
                    count++;
                }
            }
            length = Math.max(length, count);
        }
        return length;
    }
}
