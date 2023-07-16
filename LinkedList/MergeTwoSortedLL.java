package LinkedList;

public class MergeTwoSortedLL {
    public static void main(String[] args) {
        CustomLL list1 = new CustomLL();
        list1.insertLast(1);
        list1.insertLast(5);
        
        CustomLL list2 = new CustomLL();
        list2.insertLast(1);
        list2.insertLast(2);
        list2.insertLast(9);
        list2.insertLast(14);
        
        list1.display();
        list2.display();



    }

    public static ListNode MergeSortedLL(ListNode first, ListNode second){
        ListNode head = null;
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




    public class ListNode {
            int val;
        ListNode next;
        ListNode() {}
            ListNode(int val) { this.val = val; }
            ListNode(int val, ListNode next) { this.val = val; this.next = next; }
        }
}
