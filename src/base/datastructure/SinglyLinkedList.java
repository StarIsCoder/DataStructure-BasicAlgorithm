package base.datastructure;

import java.util.ArrayList;

public class SinglyLinkedList<V> {
    Node<V> head;

    public void printList() {
        Node<V> n = head;
        while (n != null) {
            System.out.print(n.value + " ");
            n = n.next;
        }
        System.out.println();
    }

    public void insertFirst(V data) {
        Node<V> newNode = new Node<>(data);
        newNode.next = head;
        head = newNode;
    }

    public void deleteFirst() {
        head = head.next;
    }

    public void deleteAfter(Node<V> after) {
        Node tmp = head;
        while (tmp != null) {
            if (tmp.value == after.value) {
                tmp.next = tmp.next != null ? tmp.next.next : null;
                break;
            }
            tmp = tmp.next;
        }
    }

    public void insertLast(V data) {
        Node<V> newNode = new Node<>(data);
        Node<V> tmp = head;
        while (tmp.next != null) {
            tmp = tmp.next;
        }
        tmp.next = newNode;
    }

    public static void main(String[] args) {
        {
            byte[] holder = new byte[64 * 1024 * 1024];
        }

        System.gc();

        SinglyLinkedList<Integer> linkedList = new SinglyLinkedList();

        linkedList.head = new Node(1);
        Node<Integer> second = new Node(2);
        Node<Integer> third = new Node(3);

        linkedList.head.next = second;
        second.next = third;
        System.out.println("Construct list");
        linkedList.printList();

        //insert first
        System.out.println("insert node");
        linkedList.insertFirst(0);
        linkedList.printList();

        //delete first
        System.out.println("delete first node");
        linkedList.deleteFirst();
        linkedList.printList();

        //delete after
        System.out.println("delete after particular node");
        linkedList.deleteAfter(second);
        linkedList.printList();

        //insert last
        System.out.println("insert last");
        linkedList.insertLast(5);
        linkedList.printList();
    }


}
