package LinkedList;

public class SumOfTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode node1 = l1;
        ListNode node2 = l2;

        ListNode ans = sum(node1, node2);

        return ans;
    }

    private ListNode sum(ListNode head1, ListNode head2){
        int carry = 0;
        int sum = 0;
        ListNode first = head1;
        ListNode second = head2;
        if(first == null && second == null){
            return head2;
        }

        while(first != null && second != null){
            sum = first.val + second.val + carry;
            if(sum >= 10){
                carry = 1;
                int rem = sum%10;
                second.val = rem;
                // first.val = rem;
            }
            else{
                carry = 0;
                second.val = sum;
                // first.val = sum;
            }
            first = first.next;
            second = second.next;
        }

        while(first != null){
           ListNode local = new ListNode(first.val + carry, null);
           second = local;
           second = second.next;
           carry = 0;
           first = first.next;
        }

        while(second != null){
           second.val = second.val + carry;
           carry = 0;
           second = second.next;
        }
        return head2;
    }

    private class ListNode {
        int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }
}

// Definition for singly-linked list.

 
// class Solution {
    
// }