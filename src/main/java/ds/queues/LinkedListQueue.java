package ds.queues;

public class LinkedListQueue<T> {
    private static class Node<T> {
        T value;
        Node<T> next;
        Node(T value) { this.value = value; }
    }

    private Node<T> front, rear;
    private int size;

    public void enqueue(T value) {
        Node<T> node = new Node<>(value);
        if (rear != null) rear.next = node;
        rear = node;
        if (front == null) front = rear;
        size++;
    }

    public T dequeue() {
        if (isEmpty()) throw new IllegalStateException("Queue empty");
        T value = front.value;
        front = front.next;
        if (front == null) rear = null;
        size--;
        return value;
    }

    public T peek() {
        if (isEmpty()) throw new IllegalStateException("Queue empty");
        return front.value;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }
}
