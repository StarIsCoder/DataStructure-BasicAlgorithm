package base.datastructure;

public class MyLinkedStack<V> {
    Node<V> bottom;

    public void push(V data) {
        Node<V> newNode = new Node<>(data);
        Node<V> temp = bottom;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    public V pop() {
        Node<V> temp = bottom;
        if (temp.next == null) return null;
        while (temp.next.next != null) {
            temp = temp.next;
        }
        V v = temp.next.value;
        temp.next = null;
        return v;
    }

    public MyLinkedStack() {
        bottom = new Node<>(null);
    }

    private static class Node<V> {
        V value;
        public Node<V> next;

        public Node(V value) {
            this.value = value;
        }
    }
}
