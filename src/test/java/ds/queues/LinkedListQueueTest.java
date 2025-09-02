package ds.queues;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LinkedListQueueTest {

    @Test
    void basics() {
        LinkedListQueue<String> q = new LinkedListQueue<>();
        assertTrue(q.isEmpty());

        q.enqueue("a");
        q.enqueue("b");
        q.enqueue("c");

        assertEquals(3, q.size());
        assertEquals("a", q.peek());

        assertEquals("a", q.dequeue());
        assertEquals("b", q.dequeue());
        assertEquals("c", q.dequeue());
        assertTrue(q.isEmpty());

        assertThrows(IllegalStateException.class, q::dequeue);
    }
}
