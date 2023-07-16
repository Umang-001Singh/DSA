package LinkedList;

public class ReverseLL {
    static private Node head;
    static private Node tail;
    private static int size;


    
    public static void main(String[] args) {
        
    }

    //Using Recusion
    private void reverse(Node node){
        if(node == tail){
            head = tail;
            return; 
        }

        reverse(node.next);
        tail.next = node;
        tail = node;
        tail.next = null;
    }

    //Using In Place Method
    private void reverseInPlace(Node node){
        //Used for In Place Method, Assume tail is not gives
        Node prev = null;
        Node present= head;
        Node Next = present.next;

        if(size < 2){
            return;
        }

        if(head == null){
            return;
        }
        while(present != null){
        prev = present.next;
        prev = present;
        present = Next;
        if(Next != null){
            Next = Next.next;
        }
        }
    head = prev;

    }

    public class Node{
        private int value;
        public Node next;

        public Node(int value){
            this.value = value;
        }

        public Node(int value, Node next){
            this.value = value;
            this.next = next;
        }
    }
}
