package base.datastructure;

import java.util.Iterator;

public class MyLinkedList<T> implements Iterable<T> {
    private Node<T> head;
    private Node<T> tail;
    private int mSize;

    public MyLinkedList() {
        init();
    }

    private void init() {
        head = new Node<>(null, null, null);
        tail = new Node<>(null, head, null);
        head.next = tail;
        mSize = 0;
    }

    public int size() {
        return mSize;
    }

    public void add(T data) {
        add(size(), data);
    }

    public void add(int index, T data) {
        addBefore(getNode(index), data);
    }

    public void addBefore(Node<T> p, T data) {
        Node<T> newNode = new Node<>(data, p.prev, p);
        newNode.prev.next = newNode;
        p.prev = newNode;
        mSize++;
    }

    public void remove(int index) {
        Node<T> needToRemove = getNode(index);
        needToRemove.prev.next = needToRemove.next;
        needToRemove.next.prev = needToRemove.prev;
        mSize--;
    }

    private Node<T> getNode(int index) {
        Node<T> p;
        if ((size() / 2) > index) {
            p = tail;
            for (int i = size(); i > index; i--) {
                p = p.prev;
            }
        } else {
            p = head.next;
            for (int i = 0; i < index; i++) {
                p = p.next;
            }
        }
        return p;
    }

    @Override
    public Iterator<T> iterator() {
        return new MyLinkedListIterator();
    }

    class MyLinkedListIterator implements Iterator<T> {
        private Node<T> current = head.next;
        private int count = 0;

        @Override
        public boolean hasNext() {
            return current != tail;
        }

        @Override
        public T next() {
            T nextItem = current.data;
            current = current.next;
            return nextItem;
        }
    }

    private static class Node<T> {
        public Node(T data, Node<T> prev, Node<T> next) {
            this.data = data;
            this.prev = prev;
            this.next = next;
        }

        public T data;
        public Node<T> prev;
        public Node<T> next;
    }
}
