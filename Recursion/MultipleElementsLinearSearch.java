package Recursion;

//import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class MultipleElementsLinearSearch {
    public static void main(String[] args) {
        int [] arr={1,2,3,4,6,8};
        ArrayList<Integer> ans=new ArrayList<>();
        ans=Search(arr, 4, 0,new ArrayList<>());
        System.out.println(ans);
    }

    public static ArrayList<Integer> Search(int [] arr, int target, int index, ArrayList<Integer> ans) {
        if (index == arr.length) {
            return ans;
        }
        if (target == arr[index]) {
            ans.add(index);
        }
        return Search(arr, target, index + 1, ans);
    }
}
