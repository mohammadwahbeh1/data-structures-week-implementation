package ds.advancedstructures;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class UnionFindTest {

    @Test
    void testUnionFind() {
        UnionFind uf = new UnionFind(5);

        // initially, nothing is connected
        assertFalse(uf.connected(0, 1));

        // union some sets
        uf.union(0, 1);
        uf.union(2, 3);

        // check connections
        assertTrue(uf.connected(0, 1));
        assertFalse(uf.connected(1, 2));
        uf.union(1, 2); // merge two sets
        assertTrue(uf.connected(0, 3)); // all connected now
    }
}
