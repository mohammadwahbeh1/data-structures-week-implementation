package ds.advancedstructures;

import java.util.*;

public class GraphTraversal {
    private Map<Integer, List<Integer>> adjList = new HashMap<>(); // adjacency list

    // add an edge from u to v
    public void addEdge(int u, int v) {
        adjList.putIfAbsent(u, new ArrayList<>());
        adjList.get(u).add(v);
    }

    // BFS starting from node
    public List<Integer> bfs(int start) {
        List<Integer> result = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();

        queue.offer(start);
        visited.add(start);

        while (!queue.isEmpty()) {
            int node = queue.poll();
            result.add(node);

            for (int neighbor : adjList.getOrDefault(node, new ArrayList<>())) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.offer(neighbor);
                }
            }
        }
        return result;
    }

    // DFS starting from node
    public List<Integer> dfs(int start) {
        List<Integer> result = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();
        dfsHelper(start, visited, result);
        return result;
    }

    // helper for DFS (recursive)
    private void dfsHelper(int node, Set<Integer> visited, List<Integer> result) {
        if (visited.contains(node)) return;
        visited.add(node);
        result.add(node);

        for (int neighbor : adjList.getOrDefault(node, new ArrayList<>())) {
            dfsHelper(neighbor, visited, result);
        }
    }
}
