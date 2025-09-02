package ds.advancedstructures;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class GraphTraversalTest {

    @Test
    void testBfsAndDfs() {
        GraphTraversal graph = new GraphTraversal();

        // build graph
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 3);

        // BFS from 2
        List<Integer> bfsResult = graph.bfs(2);
        assertEquals(List.of(2, 0, 3, 1), bfsResult);

        // DFS from 2
        List<Integer> dfsResult = graph.dfs(2);
        assertEquals(List.of(2, 0, 1, 3), dfsResult);
    }
}
