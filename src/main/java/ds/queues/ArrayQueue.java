package ds.queues;

public class ArrayQueue<T> {
    private T[] data;
    private int front, rear, size, capacity;

    @SuppressWarnings("unchecked")
    public ArrayQueue(int capacity) {
        this.capacity = capacity;
        this.data = (T[]) new Object[capacity];
        this.front = this.size = 0;
        this.rear = -1;
    }

    public void enqueue(T value) {
        if (size == capacity) throw new IllegalStateException("Queue full");
        rear = (rear + 1) % capacity;
        data[rear] = value;
        size++;
    }

    public T dequeue() {
        if (isEmpty()) throw new IllegalStateException("Queue empty");
        T value = data[front];
        front = (front + 1) % capacity;
        size--;
        return value;
    }

    public T peek() {
        if (isEmpty()) throw new IllegalStateException("Queue empty");
        return data[front];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }
}
