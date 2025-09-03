package ds.linkedlists;

public class DoublyLinkedList<T> {
    // Node stores value and links to prev/next
    private static class Node<T> {
        T value;
        Node<T> prev, next;
        Node(T value) { this.value = value; }
    }

    private Node<T> head, tail; // first and last nodes
    private int size;           // number of elements

    // add element to the front
    public void addFirst(T value) {
        Node<T> node = new Node<>(value);
        if (head == null) {
            // empty list → head and tail are the same
            head = tail = node;
        } else {
            node.next = head;
            head.prev = node;
            head = node;
        }
        size++;
    }

    // add element to the end
    public void addLast(T value) {
        Node<T> node = new Node<>(value);
        if (tail == null) {
            // empty list → head and tail are the same
            head = tail = node;
        } else {
            tail.next = node;
            node.prev = tail;
            tail = node;
        }
        size++;
    }

    // remove element from the front
    public T removeFirst() {
        if (isEmpty()) throw new IllegalStateException("Empty list");
        T val = head.value;
        head = head.next;
        if (head != null) head.prev = null; // update new head
        else tail = null;                   // list became empty
        size--;
        return val;
    }

    // remove element from the end
    public T removeLast() {
        if (isEmpty()) throw new IllegalStateException("Empty list");
        T val = tail.value;
        tail = tail.prev;
        if (tail != null) tail.next = null; // update new tail
        else head = null;                   // list became empty
        size--;
        return val;
    }

    // check if list is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // return number of elements
    public int size() {
        return size;
    }
}
