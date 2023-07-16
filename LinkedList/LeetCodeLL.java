package LinkedList;

public class LeetCodeLL {
    public static ListNode head;
    public static ListNode tail;
    public static int size;
    
    public LeetCodeLL(){
        this.size =0;
    }

    public  void display(){
        ListNode temp = head;
        while(temp != null){
            System.out.print(temp.val + "->");
            temp = temp.next;
        }
        System.out.print("END");
        System.out.println();
    }

    public  void DisplayNode(ListNode head){
        ListNode node = head;
        while(node != null){
            System.out.print(node.val + "->");
            node = node.next;
        }
        System.out.println("END");
    }
    
    public  void insertFirst(int val){
        ListNode node = new ListNode(val);
        node.next = head;
        head = node;

        if(tail == null){
            tail = head;
        }

        size += 1;
    }


    public  void insertLast(int val){
        if(head == null){
            insertFirst(val);
        }
        else{
            ListNode node = head;
            ListNode insert = new ListNode(val);
            while(node.next != null){
                node = node.next;
            }
            node.next = insert;
            insert.next = null;
        }
    }

    //REVERSE NODES IN K GROUP
    public static ListNode reverseInKGroup(LeetCodeLL list, int k){
        ListNode head = list.head;
        if(k<=1 || head == null){
            return head;
        }
        
        ListNode node = head;
        ListNode prev = null;
        ListNode pres = head;
        ListNode next = pres.next;
        ListNode beg =prev;
        ListNode end = pres;

        int count = 0;
        int length = 0;
        while(node != null){
            length++;
            node =node.next;
        }

        while(length - count >=k){
            for(int i = 0;i<k;i++){
                pres.next = prev;
                prev = pres;
                pres = next;
                if(next != null){
                    next = next.next;
                }
                count++;
            }

            if(beg == null){
                head = prev;
                // beg.next = prev;
            }
            else{
                beg.next = prev;
            }
            end.next = pres;
            prev = end;
            beg = prev;
            end = pres;
        }
        return head;
    }
            

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

}
