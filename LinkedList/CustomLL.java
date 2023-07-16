package LinkedList;

import java.util.LinkedList;

public class CustomLL {
    public static Node head;
    public static Node tail;
    public static int size;

    public CustomLL(){
        this.size =0;
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

    public  void bubbleSort(int start,int end){
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
                    tail = first;
                    second.next = tail;
                    pre.next = second;
                    tail.next = null;
                    
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

    public Node get(int start) {
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

    public class Node{
        public int value;
        public Node next;

        public Node(int value){
            this.value = value;
        }

        public Node(int value, Node next){
            this.value = value;
            this.next = next;
        }
    }

    public void RecIns(int value, int index){
        Node node = head;
        Node temp = RecInsInternal(value, index, head);
        head = temp;
    }

    public Node RecInsInternal(int value, int index, Node node){
        if(index == 0){
            Node temp = new Node(value, node);
            return temp;
        }

        node.next = RecInsInternal(value, index-1, node.next);
        return node;
    }


    //BUILD IN LINKED LIST
    //LinkedList<Integer> list = new LinkedList<>();

    //DELETING THE DUPLICATES
    public void duplictes(){
        Node node = head;
        head = duplictesInternal(node);
    }

    public Node duplictesInternal(Node node){
        // Node node = head;
        while(node.next != null){
            if(node.value == node.next.value){
                node.next = node.next.next;
                size--;
            }
            else{
                node=node.next;
            }
        }
        return head;
    }


    //FOR COMBINING TWO SORTED ARRAYS
    public static CustomLL Combine( CustomLL first, CustomLL second){
        CustomLL ans = new CustomLL();
        Node f = first.head;
        Node s = second.head;
        while(f != null || s != null){
            if(f.value <= s.value){
            ans.insertLast(f.value);
            f = f.next;
            }
            else{
                ans.insertLast(s.value);
                s = s.next;
            }
        }
        while(s.next != null){
            ans.insertLast(s.value);
            s = s.next;
            // size++;
        }
        while(f.next != null){
            ans.insertLast(f.value);
            f = f.next;
            // size++;
        }
        return ans;
    }

    //REMOVING DUPLICATES FROM SORTED LIST 2
    public Node deleteNodeSorted(Node head){
        if(head == null){
            return null;
        }
        Node ans = new Node(0);
        // Node mem = null;
        Node dummy = ans;
        Node node = head;
        Node mem = null;
        
        while(node.next != null){
            if(node == head){
                if(node.value == node.next.value){
                    Node local = new Node(node.value);
                    mem.next = local;
                    mem = mem.next;
                }
                else{
                    Node local = new Node(node.value);
                    dummy.next = local;
                    dummy = dummy.next;
                }
                node = node.next;
            }
            else{
                if((node.value == mem.value) || (node.value == node.next.value)){
                    Node local = new Node(node.val);
                    mem.next = local;
                    mem = mem.next;
                }
                else{
                    Node local = new Node(node.val);
                    dummy.next = local;
                    dummy = dummy.next;
                }
                node = node.next;
            }
        }

        if(node.val != mem.val){
            Node local = new Node(node.val);
            dummy.next = local;
            dummy = dummy.next;
        } 
        return ans.next;
    }
}
