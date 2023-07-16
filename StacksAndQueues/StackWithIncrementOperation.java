package StacksAndQueues;

public class StackWithIncrementOperation {
    static class CustomStack {  //NESTING THE CLASS
        int [] arr;
        int i; //POINTER
    
        public CustomStack(int maxSize) {
            this.arr = new int[maxSize];
        }
        
        public void push(int x) {
            if(i==arr.length){
                return;
            }
            else{
                arr[i]=x;
                i++;
            }
        }
        
        public int pop() {
            if(i==0){
                return -1;
            }
            else{
                int j = i-1;
                int ans = arr[j];
                j--;
                i--;
                return ans;
            }
        }
        
        public void increment(int k, int val) {
            if(i<0){
                return;
            }
            else{
                int j;
                for(j = 0;j<i && j<k;j++){
                    arr[j] = arr[j] + val;
                }
                                
                
                
            }
        }
    }
}
