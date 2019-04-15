package base.datastructure;

public class Node<V> {
    V value;
    public Node<V> next;

    public Node(V value) {
        this.value = value;
    }
}
