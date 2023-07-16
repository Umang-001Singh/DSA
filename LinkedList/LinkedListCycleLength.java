package LinkedList;

public class LinkedListCycleLength {
    public static void main(String[] args) {
        CustomLL list = new CustomLL();
        
    }
    public int CycleLen(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        int size =0;
        while(fast != null && fast.next != null){

            fast = fast.next.next;
            slow =slow.next;
            if(fast == slow){
                do{
                    slow = slow.next;
                    size++;
                }while(slow != fast);
            }
            return size;
        }
        return 0;
        
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
