package ds.queues;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ArrayQueueTest {

    @Test
    void basics() {
        ArrayQueue<Integer> q = new ArrayQueue<>(3);
        assertTrue(q.isEmpty());

        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);

        assertEquals(3, q.size());
        assertEquals(10, q.peek());
        assertThrows(IllegalStateException.class, () -> q.enqueue(40)); // queue full

        assertEquals(10, q.dequeue());
        assertEquals(20, q.dequeue());
        assertEquals(30, q.dequeue());
        assertTrue(q.isEmpty());

        assertThrows(IllegalStateException.class, q::dequeue); // queue empty
    }
}
