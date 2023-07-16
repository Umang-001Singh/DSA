package LinkedList;

public class LinkedListCycleStartingNode {
    public ListNode detectCycle(ListNode head) {
        ListNode first = head;
        ListNode second = head;

        int cycleLen = CycleLen(head);

        if(cycleLen == 0){
            return null;
        }

        for(int i=0;i<cycleLen;i++){
            second = second.next;
        }

        while(first != second){
            first = first.next;
            second = second.next;
        }
        return first;
    }

    public int CycleLen(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        int size =0;
        while(fast != null && fast.next != null){

            fast = fast.next.next;
            slow =slow.next;
            if(fast == slow){
                size = Length(slow);
                break;
            }
        }
        return size;
        
    }

    private static int Length(ListNode slow){
        int length = 0;
        ListNode s = slow;
        do{
            s = s.next;
            length+=1;
        }while(s !=slow);
        return length;
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
