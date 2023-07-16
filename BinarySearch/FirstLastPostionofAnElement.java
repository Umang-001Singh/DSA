package BinarySearch;

import java.util.ArrayList;
import java.util.Arrays;

public class FirstLastPostionofAnElement {
    public static void main(String[] args) {
        int []nums={5,7,7,7,8,8,10};
        int target=10;
        int []ans={-1,-1};
        int start=FirstLastPosition(nums,target,true);
        int end=FirstLastPosition(nums, target, false);
        ans[0]=start;
        ans[1]=end;
        System.out.println(Arrays.toString(ans));

    }

    static int FirstLastPosition(int []arr,int target,boolean startIndex){
    int ans=-1;
    int start=0;
    int end=arr.length-1;
    while(start<=end) {
        int mid = start + (end - start) / 2;
        if (target < arr[mid]) {
            end = mid - 1;
        } else if (target > arr[mid]) {
            start = mid + 1;
        } else {
            ans = mid;
            if (startIndex) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
    }
    return ans;
    }
}



