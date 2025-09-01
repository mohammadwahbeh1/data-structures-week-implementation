package ds.arrays;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DynamicArrayTest {
    @Test void addGet() {
        DynamicArray<Integer> a = new DynamicArray<>();
        a.add(1); a.add(2); a.add(3);
        assertEquals(3, a.size());
        assertEquals(2, a.get(1));
    }
    @Test void insertRemove() {
        DynamicArray<String> a = new DynamicArray<>();
        a.add("a"); a.add("c");
        a.add(1, "b");
        assertEquals("b", a.get(1));
        assertEquals("b", a.removeAt(1));
        assertEquals(2, a.size());
        assertTrue(a.remove("a"));
        assertFalse(a.contains("zzz"));
    }
}
