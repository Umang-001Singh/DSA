package Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class PermutationArray {
    public static void main(String [] srgs) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the length of the array");
        int i = in.nextInt();
        int[] nums = new int[i];
        System.out.println("Enter elements");
        for (int j = 0; j < nums.length; j++) {
            nums[j] = in.nextInt();
        }
        int[] ans = new int[nums.length];
        for (int k = 0; k < nums.length; k++) {
            ans[k] = nums[nums[k]];
        }
        System.out.println(Arrays.toString(ans));
    }
}
