package Sorting;

public class MissingPosNo {
    public static void main(String []args){
        int []arr={3,4,-1,1};
        int finalans=Missing(arr);
        System.out.println(finalans);

    }

    static int Missing(int []arr){
        int i=0;
        while(i<arr.length){
            int correct=arr[i]-1;
            if( (correct<arr.length) && (correct>=0) && (arr[i]!=arr[correct]) ){
                swap(arr, i ,correct);
            }
            else{
                i++;
            }
        }

        int ans=0;


        for(int j=0;j<arr.length;j++){
            if(arr[j]!=(j+1)){
                return j+1;
            }
        }
        return arr.length+1;
    }

    static void swap(int []arr, int first, int last){
        int temp=arr[first];
        arr[first]=arr[last];
        arr[last]=temp;
    }
}
