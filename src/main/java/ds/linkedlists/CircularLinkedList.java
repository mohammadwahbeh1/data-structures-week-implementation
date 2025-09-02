package ds.linkedlists;

public class CircularLinkedList<T> {
    private static class Node<T> {
        T value;
        Node<T> next;
        Node(T value) { this.value = value; }
    }

    private Node<T> tail;
    private int size;

    public void add(T value) {
        Node<T> node = new Node<>(value);
        if (tail == null) {
            tail = node;
            tail.next = tail;
        } else {
            node.next = tail.next;
            tail.next = node;
            tail = node;
        }
        size++;
    }

    public T remove() {
        if (isEmpty()) throw new IllegalStateException("Empty");
        Node<T> head = tail.next;
        T value = head.value;
        if (head == tail) tail = null;
        else tail.next = head.next;
        size--;
        return value;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }
}
