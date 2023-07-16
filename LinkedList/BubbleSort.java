package LinkedList;

public class BubbleSort extends CustomLL {
    private Node head;
    private Node tail;
    private static int size;

    public BubbleSort(){
        this.size =0;
    }
    public static void main(String[] args) {
        CustomLL list = new CustomLL();
        for (int i = 7; i > 0; i--) {
            list.insertLast(i);
        }
        list.display();
        list.bubbleSort(0, size - 1);
        list.display();
    }

    public void bubbleSort(int start,int end){
        if(end == 0){
            return;
        }

        if(start < end){
            Node first = get(start);
            Node second = get(start + 1);
            
            if(first.value > second.value){
                //SWAP
                //IF FIRST IS AT HEAD
                if(first == head){
                    head = second;
                    first.next = second.next;
                    second.next = first;
                }
                else if(second == tail){
                    Node pre = get(start - 1);
                    pre.next = second;
                    tail = first;
                    first.next = null;
                    second.next = tail;
                    
                }
                else{
                    Node pre = get(start - 1);
                    pre.next = second;
                    first.next = second.next;
                    second.next = first;
                }
                bubbleSort(start + 1, end);
            }
            else{
                bubbleSort(0, end - 1);
            }
        }
    }

    private Node get(int start) {
        Node node = head;
        while(start > 0){
            node = node.next;
            start -= 1;
        }
        return node;
    }
    public void display(){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.value + "->");
            temp = temp.next;
        }
        System.out.print("END");
        System.out.println();
    }

    public void insertFirst(int value){
        Node node = new Node(value);
        node.next = head;
        head = node;

        if(tail == null){
            tail = head;
        }

        size += 1;
    }

    public void insertLast(int value){
        if(head == null){
            insertFirst(value);
        }
        else{
            Node node = head;
            Node insert = new Node(value);
            while(node.next != null){
                node = node.next;
            }
            node.next = insert;
            insert.next = null;
            size++;
        }

    }


    private class Node{
        private int value;
        private Node next;

        public Node(int value){
            this.value = value;
        }

        public Node(int value, Node next){
            this.value = value;
            this.next = next;
        }
    }

}


