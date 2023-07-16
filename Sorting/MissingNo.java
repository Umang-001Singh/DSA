package Sorting;

public class MissingNo {
    public int missingNumber(int[] arr) {



        int i=0;
        int ans=0;
        while(i<arr.length){
            if(i!=arr[i]){
                if(arr[i]==arr.length){
                    i++;
                }
                else{
                    int temp=arr[arr[i]];
                    arr[arr[i]]=arr[i];
                    arr[i]=temp;
                }
            }
            else{
                i++;
            }
        }

        for(int j=0;j<arr.length;j++){
            if(j!=arr[j]){
                ans=j;
                return ans;
            }
        }
        return arr.length;
    }
}

