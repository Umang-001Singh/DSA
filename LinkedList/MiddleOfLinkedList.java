package LinkedList;

public class MiddleOfLinkedList {
    public ListNode middleNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while( fast != null && fast.next != null ){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;


        //SECOND METHOD 


        // ListNode midPrev = null;
        // while(head != null && head.next != null){
        //     midPrev = (midPrev == null) ? head : midPrev.next;
        //     head = head.next.next;
        // }
        // ListNode mid = midPrev.next;
        // midPrev.next = null;
        // return mid;
    }

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
}
}
