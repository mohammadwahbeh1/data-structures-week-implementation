package ds.linkedlists;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SinglyLinkedListTest {
    @Test void basics() {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        list.addFirst(2);
        list.addLast(3);
        list.add(1, 5); // 2,5,3
        assertEquals(3, list.size());
        assertEquals(5, list.get(1));
        assertEquals(2, list.removeFirst());
        assertEquals(3, list.removeLast());
        assertTrue(list.remove(Integer.valueOf(5)));
        assertTrue(list.isEmpty());
    }
}
