package Heaps.PriorityQueues;

import java.util.ArrayList;

public class AddInHeap {
    static class Heap{
        ArrayList<Integer> list = new ArrayList<>();
        
        public void add(int n){
            list.add(n); //SINCE list IS NOT A STATIC MEMBER, KEEP add FUNCTION NON-STATIC

            //Fix the Heap (MinHeap)
            int ch = list.size() - 1;
            int par = (ch - 1)/2;
            
                while(list.get(ch) < list.get(par)){
                    int temp = list.get(ch);
                    list.set(ch, list.get(par));  //obj.set funciton syntax: obj.set(index, value);
                    list.set(par, temp);

                    ch = par;
                    par = (ch - 1)/2;
                }
            
        }

        public int peek(){
            return list.get(0);
        }

        private void heapify(int i){
            int left = 2*i + 1;
            int right = 2*i +2;
            int minI = i;

            //IF VALUE OF i IS EQUAL TO list.size() - 1, THEN left AND right WILL HAVE A 
            //VALUE GREATER THAN SIZE OF LIST, SO IS CHECK IS PROVIDED
            if(left<(list.size()) && list.get(minI)> list.get(left)){
                minI = left;
            }

            if(right<(list.size()) && list.get(minI)>list.get(right)){
                minI = right;
            }

            if(minI != i){
                //swap
                int temp = list.get(minI);
                list.set(minI, list.get(i));
                list.set(i, temp);

                heapify(minI);
            }
        }

        public boolean isEmpty(){
            return list.size() == 0;
        }

        public int delete(){
            int val = peek();

            //Step 1: Swap with last node
            int last = list.size() - 1;
            int temp = list.get(last);
            list.set(last, val); //obj.set funciton syntax: obj.set(index, value);
            list.set(0, temp);

            //Step 2: Delete the last index
            list.remove(list.size()-1);

            //Step 3: Heapify the heap
            heapify(0);
            return val;
        }
    }

    public static void main(String[] args) {
        Heap heap = new Heap();
        heap.add(1);
        heap.add(2);
        heap.add(3);
        heap.add(5);
        heap.add(7);

        while(!heap.isEmpty()){
            System.out.println(heap.delete());
        }
    }
}
