package ds.nonlinear;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class GraphTest {
    @Test void basics() {
        Graph g = new Graph();
        g.addVertex(1);
        g.addEdge(1, 2);
        g.addEdge(1, 3);
        assertEquals(2, g.getNeighbors(1).size());
        assertTrue(g.getNeighbors(1).contains(2));
    }
}

