package ds.linkedlists;

public class DoublyLinkedList<T> {
    private static class Node<T> {
        T value;
        Node<T> prev, next;
        Node(T value) { this.value = value; }
    }

    private Node<T> head, tail;
    private int size;

    public void addFirst(T value) {
        Node<T> node = new Node<>(value);
        if (head == null) head = tail = node;
        else {
            node.next = head;
            head.prev = node;
            head = node;
        }
        size++;
    }

    public void addLast(T value) {
        Node<T> node = new Node<>(value);
        if (tail == null) head = tail = node;
        else {
            tail.next = node;
            node.prev = tail;
            tail = node;
        }
        size++;
    }

    public T removeFirst() {
        if (isEmpty()) throw new IllegalStateException("Empty");
        T val = head.value;
        head = head.next;
        if (head != null) head.prev = null;
        else tail = null;
        size--;
        return val;
    }

    public T removeLast() {
        if (isEmpty()) throw new IllegalStateException("Empty");
        T val = tail.value;
        tail = tail.prev;
        if (tail != null) tail.next = null;
        else head = null;
        size--;
        return val;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }
}
