package ds.linkedlists;

public class CircularLinkedList<T> {
    // Node class to hold data and link
    private static class Node<T> {
        T value;
        Node<T> next;
        Node(T value) { this.value = value; }
    }

    private Node<T> tail; // points to the last node
    private int size;     // number of elements

    // add element to the end of the circular list
    public void add(T value) {
        Node<T> node = new Node<>(value);
        if (tail == null) {
            // first node points to itself
            tail = node;
            tail.next = tail;
        } else {
            // insert new node after tail and update tail
            node.next = tail.next; // new node points to head
            tail.next = node;      // old tail points to new node
            tail = node;           // update tail
        }
        size++;
    }

    // remove element from the front (head)
    public T remove() {
        if (isEmpty()) throw new IllegalStateException("Empty list");
        Node<T> head = tail.next;   // head is next of tail
        T value = head.value;
        if (head == tail) {
            // only one element in the list
            tail = null;
        } else {
            // skip over head
            tail.next = head.next;
        }
        size--;
        return value;
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
