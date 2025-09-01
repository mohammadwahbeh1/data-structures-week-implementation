package ds.stacks;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StackTest {
    @Test void arrayStack() {
        StackArray<String> s = new StackArray<>();
        s.push("a"); s.push("b");
        assertEquals("b", s.peek());
        assertEquals("b", s.pop());
        assertEquals("a", s.pop());
        assertTrue(s.isEmpty());
    }
    @Test void linkedStack() {
        StackLinkedList<Integer> s = new StackLinkedList<>();
        s.push(10); s.push(20);
        assertEquals(20, s.peek());
        assertEquals(20, s.pop());
        assertEquals(10, s.pop());
        assertTrue(s.isEmpty());
    }
}
