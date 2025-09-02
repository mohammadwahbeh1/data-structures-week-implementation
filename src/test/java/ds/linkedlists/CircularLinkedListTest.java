package ds.linkedlists;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CircularLinkedListTest {

    @Test
    void basics() {
        CircularLinkedList<Integer> list = new CircularLinkedList<>();
        assertTrue(list.isEmpty());

        list.add(5);
        list.add(10);
        list.add(15);

        assertEquals(3, list.size());

        assertEquals(5, list.remove());  // removes head
        assertEquals(10, list.remove());
        assertEquals(15, list.remove());
        assertTrue(list.isEmpty());

        assertThrows(IllegalStateException.class, list::remove);
    }
}
