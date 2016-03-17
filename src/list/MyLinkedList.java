package list;

/**
 * Created by jcohe_000 on 3/17/2016.
 */



class Node {
    Node next = null;
    int data;

    public Node(int d) {
        this.data = d;
    }

    void appendToTail(int d) {
        Node end = new Node(d);
        Node n = this;
        while(n.next != null) {
            n = n.next;
        }
        n.next = end;
    }

    Node deleteNode(Node head, int d) {
        Node n = head;

        if (n.data == d) {
            return head.next;   // Moved head
        }

        while(n.next != null) {
            if (n.next.data != d) {
                n.next = n.next.next;
                return head;    // head didnt change
            }
            n = n.next;     // walk the list
        }
        return head;
    }


}

public class MyLinkedList {
    public Node head;

    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();
        list.head = new Node(1);

        list.head.appendToTail(95);
        list.head.appendToTail(23);

        Node ptr = list.head;
        while(ptr != null) {
            System.out.println(ptr.data);
            ptr = ptr.next;
        }

    }
}