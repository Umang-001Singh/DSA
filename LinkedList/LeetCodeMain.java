package LinkedList;

public class LeetCodeMain extends LeetCodeLL{
    public static void main(String[] args) {
        LeetCodeLL list = new LeetCodeLL();
        list.insertFirst(5);
        list.insertFirst(4);
        list.insertFirst(3);
        list.insertFirst(2);
        list.insertFirst(1);

        // list.DisplayNode(head);

        ListNode ans = reverseInKGroup(list, 4);
        list.DisplayNode(ans);

        
    }
}
