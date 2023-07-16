package Recursion;

public class LinearSearch {
    public static void main(String[] args) {
        int [] arr={2,3,1,4,14,5};
        System.out.println(SearchLast(arr, 2, arr.length-1));
    }

//    public static int Search(int [] arr, int target, int index){
//        if(index == arr.length){
//            return -1;
//        }
//        if(target == arr[index]){
//            return index;
//    }
//        return Search(arr, target, index + 1);
//    }

    public static int SearchLast(int [] arr, int target, int index){
        if(index == -1){
            return -1;
        }
        if(target == arr[index]){
            return index;
        }
        return SearchLast(arr, target, index-1);
    }
}
