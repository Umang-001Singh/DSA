package LinkedList;

public class MergeSort {
    
        public ListNode sortList(ListNode head) {
            if(head == null || head.next == null){
                return head;
            }
    
            ListNode mid = middleNode(head);
            ListNode left = sortList(head);
            ListNode right = sortList(mid);
    
        
            return MergeSortedLL(left, right);
        }
    
        public static ListNode MergeSortedLL(ListNode first, ListNode second){
            ListNode head = null;    //IN LEETCODE USE:- ListNode head = new ListNode();
            ListNode tail = head;
            while(first != null && second != null){
                if(first.val < second.val){
                    tail.next = first;
                    tail = tail.next;
                    first = first.next;
                }
                else{
                    tail.next = second;
                    tail = tail.next;
                    second = second.next;
                }
            }
    
            while(first!=null){
                    tail.next = first;
                    tail = tail.next;
                    first = first.next;
            }
    
            while(second != null){
                    tail.next = second;
                    tail = tail.next;
                    second = second.next;
            }
            
            return head.next;
        }
    
        public ListNode middleNode(ListNode head) {
        ListNode midPrev = null;
            while(head != null && head.next != null){
                if(midPrev == null){
                    midPrev = head;
                }
                else{
                    midPrev = midPrev.next;
                }
                head = head.next.next;
            }
            ListNode mid = midPrev.next;
            midPrev.next = null;
            return mid;
        }

        public class ListNode {
            int val;
            ListNode next;
            ListNode() {}
                 ListNode(int val) { this.val = val; }
                 ListNode(int val, ListNode next) { this.val = val; this.next = next; }
             }
    
}
