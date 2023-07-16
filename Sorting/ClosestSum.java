package Sorting;

public class ClosestSum {
    public static void main(String []args){
        int []arr={1,1,1,0};
        int target=-100;
        System.out.println(Closest(arr,target));

    }

    static int Closest(int [] arr,int target){

        //Selection Sort
        for(int i=0;i<arr.length;i++){
            int getMax=getMax(arr,0,arr.length-1-i);
            int last=arr.length-1-i;
            swap(arr,getMax,last);
        }

        //Two pointer method
        int diff=Integer.MAX_VALUE;
        int ans=0;
        int Sum=0;
        for(int i=0; i<arr.length-2;i++){
            for(int j=i+1;j<arr.length-1;j++){
                int k=arr.length-1;
                while(j<k){
                    Sum=arr[i]+arr[j]+arr[k];
                    if(Math.abs((target)-(Sum))<diff){
                        ans=Sum;
                        diff=Math.abs(target-Sum);
                    }
                    k--;
                }
            }
        }
        return ans;
    }

    static void swap(int []arr, int first, int second){
        int temp=arr[first];
        arr[first]=arr[second];
        arr[second]=temp;
    }

    static int getMax(int []arr, int start, int end){
        int max=arr[start];
        int ans=0;
        for(int i=start;i<=end;i++){
            if(arr[i]>max){
                max=arr[i];
                ans=i;
            }
        }
        return ans;
    }
}
