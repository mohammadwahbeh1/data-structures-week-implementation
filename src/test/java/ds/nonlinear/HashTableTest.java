package ds.nonlinear;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class HashTableTest {
    @Test void basics() {
        HashTable<String, Integer> map = new HashTable<>(10);
        map.put("one", 1);
        map.put("two", 2);
        assertEquals(1, map.get("one"));
        assertEquals(2, map.get("two"));
        assertTrue(map.remove("one"));
        assertNull(map.get("one"));
    }
}
