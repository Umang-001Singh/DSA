package Hashing;

public class KadanesAlgorithm {
    public static void main(String[] args) {
        int []nums = {-2, -3, 4, -1, -2, 1, 5, -3};
        int ans = maxSubArray(nums);
        System.out.println(ans);
    }

    public static int maxSubArray(int []nums){
        int ans = sum(nums);
        return ans;
    }

    public static int sum(int []arr){
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for(int i = 0;i<arr.length;i++){
            sum = sum + arr[i];
            max = Math.max(max, sum);
            if(sum < 0){
                sum = 0;
            }
        }
        return max;
    }
}
