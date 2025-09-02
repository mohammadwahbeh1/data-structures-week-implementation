package ds.linkedlists;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DoublyLinkedListTest {

    @Test
    void basics() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        assertTrue(list.isEmpty());

        list.addFirst(1);  // 1
        list.addLast(2);   // 1,2
        list.addLast(3);   // 1,2,3

        assertEquals(3, list.size());

        assertEquals(1, list.removeFirst()); // removes 1
        assertEquals(3, list.removeLast());  // removes 3
        assertEquals(1, list.size());

        assertEquals(2, list.removeFirst()); // now empty
        assertTrue(list.isEmpty());

        assertThrows(IllegalStateException.class, list::removeFirst);
    }
}
